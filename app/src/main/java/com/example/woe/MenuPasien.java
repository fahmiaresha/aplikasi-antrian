package com.example.woe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

public class MenuPasien extends AppCompatActivity {


    private ImageView btnDokter;
    private ImageView btnPoliklinik;
    private ImageView btnCatatanPasien;
    private ImageView btnContactUs;
    private ImageView btnHistory;
    private ImageView btnNotifPasien;

    private ImageView btnProfilePasien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pasien);

        btnCatatanPasien = (ImageView) findViewById(R.id.button15);
        btnContactUs = (ImageView) findViewById(R.id.button16);
        btnDokter = (ImageView) findViewById(R.id.button13);
        btnHistory = (ImageView) findViewById(R.id.button17);
        btnNotifPasien = (ImageView) findViewById(R.id.button18);
        btnPoliklinik = (ImageView) findViewById(R.id.button14);
        btnProfilePasien = (ImageView) findViewById(R.id.button21);
        ImageView btn_logout = (ImageView)  findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MenuPasien.this);
                dialog.setContentView(R.layout.alert_logout);
                dialog.setTitle("alert");

                Button btn_cancel = (Button) dialog.findViewById(R.id.btn_cancel_logout);
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                Button btn_ok = (Button) dialog.findViewById(R.id.btn_ok_logout);
                btn_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        login();
                    }
                });

                dialog.show();
            }
        });

        btnCatatanPasien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catatanPasien();
            }
        });

        btnContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactUs();
            }
        });

        btnDokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dokter();
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history();
            }
        });



        btnNotifPasien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifPasien();
            }
        });



        btnPoliklinik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poliklinik();
            }
        });

        btnProfilePasien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profilePasien();
            }
        });
    }

    private void catatanPasien(){
        Intent intent = new Intent(this, CatatanPasien.class);
        startActivity(intent);
    }

    private void contactUs(){
        String phoneNumber = "089634656688";
        Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
        startActivity(dialPhoneIntent);
//        Intent intent1 = new Intent(this, ContactUs.class);
//        startActivity(intent1);
    }

    private void dokter(){
        Intent intent2 = new Intent(this, Dokter.class);
        startActivity(intent2);
    }

    private void history(){
        Intent intent3 = new Intent(this, History.class);
        startActivity(intent3);
    }



    private void notifPasien(){
        Intent intent5 = new Intent(this, NotifPasien.class);
        startActivity(intent5);
    }

    private void pengumuman(){
        Intent intent6 = new Intent(this, Pengumuman.class);
        startActivity(intent6);
    }

    private void poliklinik(){
        Intent intent7 = new Intent(this, Poliklinik.class);
        startActivity(intent7);
    }

    private void profilePasien(){
        Intent intent8 = new Intent(this, ProfilePasien.class);
        startActivity(intent8);
    }

    private void login(){
        Intent intent4 = new Intent(this, MainActivity.class);
        startActivity(intent4);
    }
}