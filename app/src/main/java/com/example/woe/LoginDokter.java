package com.example.woe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginDokter extends AppCompatActivity {

    private Button mLoginMenuDokter;
    private TextView ForgotPasswordDokter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_dokter);

        mLoginMenuDokter = (Button) findViewById(R.id.btn_login);
        ForgotPasswordDokter = (TextView) findViewById(R.id.forgot_password_dokter);

        mLoginMenuDokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuDokter();
            }
        });

        ForgotPasswordDokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lupapassword();
            }
        });


    }

    private void menuDokter(){
        Intent intent = new Intent(this, MenuDokter.class);
        intent.putExtra("name", "username");
        startActivity(intent);
    }

    private void Lupapassword(){
        Intent intent4 = new Intent(this, lupa_password.class);
        startActivity(intent4);
    }
}