package com.working4enjoyment.decidecabina;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private static TextInputLayout usernameT;
    private static TextInputLayout passwordT;
    private static String passwordS;
    private static String usernameS;
    private static EditText username;
    private static EditText password;
    private static Voting voting;
    private static TextView errorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button send;

        voting= (Voting) getIntent().getSerializableExtra("voting");

        usernameT = (TextInputLayout) findViewById(R.id.username);
        passwordT = (TextInputLayout) findViewById(R.id.password);

        username = (EditText) findViewById(R.id.campo_username);
        password = (EditText) findViewById(R.id.campo_password);

        errorView = (TextView) findViewById(R.id.error);

        if(getIntent().getExtras().getString("username")!=null){
            username.setText(getIntent().getExtras().getString("username"));
        }else if(getIntent().getExtras().getString("password")!=null){
            password.setText(getIntent().getExtras().getString("password"));
        }

        if(getIntent().getExtras().getString("error")!=null){
            errorView.setVisibility(View.VISIBLE);
            errorView.setText(getIntent().getExtras().getString("error"));
        }

        usernameT.setError("");
        passwordT.setError("");

        send = (Button) findViewById(R.id.btn_enviar);

        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                usernameS = username.getText().toString();
                passwordS = password.getText().toString();

                if((usernameS != null && usernameS.isEmpty()) || usernameS == null){
                    usernameT.setError("Debe rellenar este campo");

                }else if((passwordS != null && passwordS.isEmpty()) || passwordS == null){
                    passwordT.setError("Debe rellenar este campo");
                }else{
                    Intent intent = new Intent(view.getContext(), LoginIntentService.class);
                    intent.putExtra("voting", voting);
                    intent.putExtra("username", usernameS);
                    intent.putExtra("password", passwordS);
                    view.getContext().startService(intent);
                }



            }
        });

    }

}