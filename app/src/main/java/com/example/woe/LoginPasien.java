package com.example.woe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginPasien extends AppCompatActivity {

    private Button mLoginMenuPasien;
    private TextView ForgotPasswordPasien;
    private TextView Signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pasien);

        mLoginMenuPasien = (Button) findViewById(R.id.btn_login_pasien);
        ForgotPasswordPasien = (TextView) findViewById(R.id.forgot_password_pasien);
        Signup = (TextView) findViewById(R.id.textview_sign_up);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
        ForgotPasswordPasien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lupapassword();
            }
        });

        mLoginMenuPasien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuPasien();
            }
        });
    }

    private void menuPasien(){
        Intent intent = new Intent(this, MenuPasien.class);
        intent.putExtra("name", "username");
        startActivity(intent);
    }

    private void Lupapassword(){
        Intent intent4 = new Intent(this, lupa_password.class);
        startActivity(intent4);
    }

    private void signup(){
        Intent intent5 = new Intent(this, registrasi_akun_pasien.class);
        startActivity(intent5);
    }
}