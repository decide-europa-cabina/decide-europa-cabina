package com.working4enjoyment.decidecabina;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Usuario on 15/03/2017.
 */
public class LoginIntentService extends IntentService {

    private static Voting voting;
    private static String username;
    private static String password;
    private static String id;
    private static String token;
    private static Boolean error;



    public LoginIntentService() {
        super("Envio Login");
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    protected void onHandleIntent(Intent intent) {

        voting= (Voting) intent.getSerializableExtra("voting");
        username= intent.getExtras().getString("username");
        password= intent.getExtras().getString("password");
        Log.d("Objeto", username+" "+password);

        error= false;

        // params comes from the execute() call: params[0] is the url.
        HttpURLConnection con = null;
        try {
            // Construir los datos a enviar
            String data = "username=" + URLEncoder.encode(username,"UTF-8") + "&password=" + URLEncoder.encode(password,"UTF-8");


            URL url = new URL("https://decide-europa-cabina.herokuapp.com/authentication/login/");
            // URL url = new URL("http://pruebaamargura.webcindario.com/hora.php");
            con = (HttpURLConnection) url.openConnection();

            // Activar método POST
            con.setDoOutput(true);

            // Tamaño previamente conocido
            con.setFixedLengthStreamingMode(data.getBytes().length);

            // Establecer application/x-www-form-urlencoded debido a la simplicidad de los datos
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            OutputStream out = new BufferedOutputStream(con.getOutputStream());

            out.write(data.getBytes());
            out.flush();
            out.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            TokenDecide tokenObject= null;
            try {
                String inputLine;
                while ((inputLine = in.readLine()) != null){

                    Gson gson = new Gson();
                    tokenObject = gson.fromJson(inputLine, TokenDecide.class);
                }
                token= tokenObject.getToken();


                in.close();
            } catch (IOException e1) {
                e1.printStackTrace();
                Log.d("Objeto", "TOOOOKEN"+token);
                error= true;
            }

            if (con.getResponseCode()!=200){
                error= true;
            }

            //Pedimos el id del usuario
            data = "token=" + URLEncoder.encode(tokenObject.getToken(),"UTF-8");
            url = new URL("https://decide-europa-cabina.herokuapp.com/authentication/getuser/");
            // URL url = new URL("http://pruebaamargura.webcindario.com/hora.php");
            con = (HttpURLConnection) url.openConnection();

            // Activar método POST
            con.setDoOutput(true);

            // Tamaño previamente conocido
            con.setFixedLengthStreamingMode(data.getBytes().length);

            // Establecer application/x-www-form-urlencoded debido a la simplicidad de los datos
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            out = new BufferedOutputStream(con.getOutputStream());

            out.write(data.getBytes());
            out.flush();
            out.close();

            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            User user= null;
            try {
                String inputLine;
                while ((inputLine = in.readLine()) != null){

                    Gson gson = new Gson();
                    user = gson.fromJson(inputLine, User.class);
                }
                id= user.getId().toString();

                in.close();
            } catch (IOException e1) {
                e1.printStackTrace();
                error= true;
            }

            if (con.getResponseCode()!=200){
                error= true;
            }

        } catch (IOException e) {
            error= true;

        } finally {
            if (con != null) {
                con.disconnect();
            }
            getApplicationContext().stopService(new Intent(getApplicationContext(),LoginIntentService.class));

            if(error){
                Intent intentF = new Intent(getApplicationContext(), LoginActivity.class);
                intentF.putExtra("username", username);
                intentF.putExtra("password", password);
                intentF.putExtra("voting", voting);
                intentF.putExtra("error", "Se ha producido un error al iniciar sesión");
                getApplicationContext().startActivity(intentF);
            }else{
                Intent intentF = new Intent(getApplicationContext(), VoteActivity.class);
                intentF.putExtra("voting", voting);
                intentF.putExtra("id", id);
                intentF.putExtra("token", token);
                getApplicationContext().startActivity(intentF);
            }


        }




    }


}