package com.example.woe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class kirim_password extends AppCompatActivity {
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kirim_password);

        login = (Button) findViewById(R.id.btn_login_send);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login(){
        Intent intent4 = new Intent(this, MainActivity.class);
        startActivity(intent4);
    }
}