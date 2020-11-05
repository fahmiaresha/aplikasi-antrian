package com.example.woe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class lupa_password extends AppCompatActivity {
    private Button btnSendPassword;
    private TextView TextviewLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_password);

        btnSendPassword = (Button) findViewById(R.id.btn_send_password);
        TextviewLogin = (TextView) findViewById(R.id.text_login);

        TextviewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        btnSendPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendpassword();
            }
        });
    }

    private void sendpassword(){
        Intent intent5 = new Intent(this, kirim_password.class);
        startActivity(intent5);
    }

    private void login(){
        Intent intent4 = new Intent(this, MainActivity.class);
        startActivity(intent4);
    }


}