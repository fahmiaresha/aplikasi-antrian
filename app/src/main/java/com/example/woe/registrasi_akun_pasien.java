package com.example.woe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class registrasi_akun_pasien extends AppCompatActivity {
    private TextView Signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi_akun_pasien);

        Signin =(TextView) findViewById(R.id.textview_sign_in);
        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signin();
            }
        });

        Button btn_sign_up = (Button)  findViewById(R.id.btn_sign_up);
        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(registrasi_akun_pasien.this);
                dialog.setContentView(R.layout.alert_daftar_akun);
                dialog.setTitle("alert");

                Button btn_alert = (Button) dialog.findViewById(R.id.btn_ok_create_akun);
                btn_alert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });


    }
    private void signin(){
        Intent intent5 = new Intent(this, MainActivity.class);
        startActivity(intent5);
    }
}