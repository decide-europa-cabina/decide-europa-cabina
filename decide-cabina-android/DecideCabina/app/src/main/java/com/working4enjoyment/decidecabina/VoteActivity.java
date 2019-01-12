package com.working4enjoyment.decidecabina;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class VoteActivity extends AppCompatActivity {

    private static Voting voting;
    private static String id;
    private static String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        List<String> options;

        options= new ArrayList<String>();

        voting= (Voting) getIntent().getSerializableExtra("voting");
        token= getIntent().getExtras().getString("token");
        id= getIntent().getExtras().getString("id");

        TextView text= (TextView) findViewById(R.id.descripcion);
        text.setText(voting.getQuestion().getDesc());

        for(Map<String, String> option : voting.getQuestion().getOptions()){
            List<String> optionTexts= new ArrayList<String>(option.values());
            for(int i=0; i< optionTexts.size(); i++){
                if(i%2!=0)
                    options.add(optionTexts.get(i));

            }
        }
        AdapterOptionVoting arrayAdapter = new AdapterOptionVoting(this, options);

        // C. Seleccionamos la lista de nuestro layout y la enlazamos con el listview
        ListView miLista = (ListView) this.findViewById(R.id.milistavote);


        //Asignamos a las variables globales para usar en otros métodos
        miLista.setAdapter(arrayAdapter);

    }

}
