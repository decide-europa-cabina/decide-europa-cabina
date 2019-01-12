package com.working4enjoyment.decidecabina;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;


import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;


public class MainActivity extends AppCompatActivity {

    //Almacen de los eventos antes de construir el Adapter
    private static List<Voting> votings= new ArrayList<Voting>();

    //Adapter global, para poder pasarle parámetros desde otros métodos
    private static AdapterVoting arrayAdapterGlobal= null;

    //ListView
    private static ListView listViewGlobal= null;

    //Refrescar
    private static SwipeRefreshLayout swipeContainer;

    private static Activity activity;

    private static Boolean noVotings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        activity= this;
        //Cambiamos la letra de la descripción
       /* TextView descripcion = (TextView) this.findViewById(R.id.descripcion);
        String font_path = "font/Roboto-Regular.ttf";
        Typeface TF = Typeface.createFromAsset(this.getAssets(),font_path);
        descripcion.setTypeface(TF);   //finalmente aplicamos TYPEFACE al TEXTVIEW*/


        //Damos valor al swipeContainer
        swipeContainer = (SwipeRefreshLayout) this.findViewById(R.id.swipeContainer);

        // B. Creamos un nuevo ArrayAdapter con nuestra lista de eventos
        AdapterVoting arrayAdapter = new AdapterVoting(this, getVotings());

        // C. Seleccionamos la lista de nuestro layout y la enlazamos con el listview
        ListView miLista = (ListView) this.findViewById(R.id.milista);


        //Asignamos a las variables globales para usar en otros métodos
        listViewGlobal= miLista;
        arrayAdapterGlobal= arrayAdapter;
        listViewGlobal.setAdapter(arrayAdapterGlobal);

        noVotings= false;

        //Ahorramos cerca de 1/5 parte de los datos
        //Si el contador esta entre 1 y 4 no cargamos de nuevo los datos
        //Si el tamaño de la lista es cero, no hay eventos, se ha ido internet recargar de nuevo
        //Si no hay eventos, se recargará tambien(lista un solo objeto "No hay eventos")
        ConsultarDatos conectarBd=  new ConsultarDatos();
        conectarBd.execute("https://decide-europa-cabina.herokuapp.com/voting/");
        Log.d("Objeto", "El if"+ arrayAdapterGlobal.getCount());

        //Refrescamos
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                // fetchTimelineAsync(0);
                //Volvemos a ejecutar el proceso
                activity.findViewById(R.id.textoInternet).setVisibility(View.GONE);
                activity.findViewById(R.id.milista).setVisibility(View.GONE);
                activity.findViewById(R.id.no_eventos).setVisibility(View.GONE);
                activity.findViewById(R.id.textoCarga).setVisibility(View.VISIBLE);
                activity.findViewById(R.id.barra_progreso).setVisibility(View.VISIBLE);
                ConsultarDatos conectarBd = new ConsultarDatos();
                conectarBd.execute("https://decide-europa-cabina.herokuapp.com/voting/");
            }
        });

        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);



    }



    //Métodos

    //Mostramos los elementos que iran al listView
    public static List<Voting> getVotings(){
        return votings;
    }

    public static void setVotings(List<Voting> voting){
        votings= voting;
    }

    //Asociamos el Adapter y el listview
    public static void creaListView(AdapterVoting arrayAdapter, ListView lista){
        // D. Asignamos el adaptador a nuestra lista
        arrayAdapter.clear();
        arrayAdapter.addAll(votings);
        arrayAdapter.notifyDataSetChanged();//Atento si algo cambia
        lista.setAdapter(arrayAdapter);
        swipeContainer.setRefreshing(false);

    }

    public static void updateView(){
        Log.d("Objeto", "Las votaciones son 2" + getVotings());
        if(getVotings().size()!=0){
            creaListView(arrayAdapterGlobal,listViewGlobal);
            activity.findViewById(R.id.barra_progreso).setVisibility(View.GONE);
            activity.findViewById(R.id.no_eventos).setVisibility(View.GONE);
            activity.findViewById(R.id.textoCarga).setVisibility(View.GONE);
            activity.findViewById(R.id.milista).setVisibility(View.VISIBLE);

        }else if(noVotings){
            //Habilitamos no eventos y deshabilitamos carga
            activity.findViewById(R.id.barra_progreso).setVisibility(View.GONE);
            activity.findViewById(R.id.textoCarga).setVisibility(View.GONE);
            activity.findViewById(R.id.no_eventos).setVisibility(View.VISIBLE);


        }else{
            //Habilitamos no internet y deshabilitamos carga
            activity.findViewById(R.id.barra_progreso).setVisibility(View.GONE);
            activity.findViewById(R.id.textoCarga).setVisibility(View.GONE);
            activity.findViewById(R.id.textoInternet).setVisibility(View.VISIBLE);
        }
    }


    //Verificamos la conexion cuando pulsamos el boton
    public static boolean verificaConexion(Context ctx) {
        boolean bConectado = false;
        ConnectivityManager connec = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // No solo wifi, tambien GPRS
        NetworkInfo[] redes = connec.getAllNetworkInfo();
        // este bucle deberia no ser tan apa
        for (int i = 0; i < 2; i++) {
            // Tenemos conexion ponemos a true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                bConectado = true;
            }
        }
        return bConectado;
    }




    //DB
    //Para usar varios hilos
    private class ConsultarDatos extends AsyncTask<String, Void, String> {



        //Creamos el constructor
        public ConsultarDatos(){

        }
        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            noVotings= false;

            votings= Utility.serializeVoting(result);

            Log.d("Objeto", "Las votaciones son " + result);
            if(getVotings().size()==0){
                noVotings= true;
            }

            //Asociamos el listview y el adapter
            creaListView(arrayAdapterGlobal, listViewGlobal);

            updateView();

        }
    }





    private String downloadUrl(String myurl) throws IOException {
        // InputStream is = null;
        InputStream in = null;
        //Crea un toString de longitud maxima 500
        // Only display the first 500 characters of the retrieved
        // web page content.
        int len = 500;
        HttpURLConnection conn= null;

        try {
            //Lo convierte a url
            URL url = new URL(myurl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            int response = conn.getResponseCode();

            Log.d("respuesta", "The response is: " + response);
            //La respuesta se guarda en un ImputStream, en este cado is
            //   is = conn.getInputStream();
            Log.d("Objeto", "La agenda es " + conn.getContentLength());
            in= new BufferedInputStream(conn.getInputStream());
            // Convert the InputStream into a string
            // String contentAsString = readIt(is, conn.getContentLength());
            String contentAsString = readStream(in);
            Log.d("Objeto", "La agenda es " + contentAsString);
            return contentAsString;

            // Makes sure that the InputStream is closed after the app is
            // finished using it.
        } finally {
           /* if (is != null) {
                is.close();
            }*/

            if (in != null) {
                in.close();
            }

            if(conn!=null){
                conn.disconnect();

            }
        }

    }

    // Reads an InputStream and converts it to a String.
    public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }

    private static String readStream(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "");
            }
        } catch (IOException e) {

        } finally {
            try {
                is.close();
            } catch (IOException e) {

            }
        }
        return sb.toString();
    }




}



