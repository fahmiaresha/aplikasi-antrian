package com.example.woe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class daftar_antrian_pasien extends AppCompatActivity {
    private ImageView home;
    private ImageView history;
    private ImageView notif;
    private ImageView profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_antrian_pasien);

        Button daftar_antrian = (Button)  findViewById(R.id.daftar_antrian);
        daftar_antrian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                daftar_antrian();
            }
        });
//        daftar_antrian.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final Dialog dialog = new Dialog(daftar_antrian_pasien.this);
//                dialog.setContentView(R.layout.alert_daftar_antrian);
//                dialog.setTitle("alert");
//
//                Button btn_alert = (Button) dialog.findViewById(R.id.btn_ok);
//                btn_alert.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        dialog.dismiss();
//                    }
//                });
//                dialog.show();
//            }
//        });

        home = findViewById(R.id.btn_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home();
            }
        });

        history = findViewById(R.id.btn_history);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history();
            }
        });

        notif = findViewById(R.id.btn_notif);
        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notif();
            }
        });

        profile = findViewById(R.id.btn_profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profile();
            }
        });
    }
    private void polianak(){
        Intent intent5 = new Intent(this, lihat_antrian_pasien.class);
        startActivity(intent5);
    }


    private void home(){
        Intent intent1 = new Intent(this, MenuPasien.class);
        startActivity(intent1);
    }

    private void notif(){
        Intent intent2 = new Intent(this, NotifPasien.class);
        startActivity(intent2);
    }

    private void profile(){
        Intent intent3 = new Intent(this, ProfilePasien.class);
        startActivity(intent3);
    }

    private void history(){
        Intent intent4 = new Intent(this, History.class);
        startActivity(intent4);
    }
    private void daftar_antrian(){
        Intent intent10 = new Intent(this, konfirmasi_daftar_antrian.class);
        startActivity(intent10);
    }

}