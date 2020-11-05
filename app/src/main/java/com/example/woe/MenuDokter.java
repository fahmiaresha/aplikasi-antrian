package com.example.woe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MenuDokter extends AppCompatActivity {


    private ImageView btnCatatanPasienDariDokter;
    private Button btnLihatJadwalSaya;
    private ImageView btnHistoryDokter;
    private ImageView btnNotifDokter;
    private ImageView btnProfileDokter;
    private ImageView btn_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_dokter);


        btnCatatanPasienDariDokter =(ImageView) findViewById(R.id.button8);
        btnHistoryDokter = (ImageView) findViewById(R.id.button24);
        btnLihatJadwalSaya = (Button) findViewById(R.id.button25);
        btnNotifDokter = (ImageView) findViewById(R.id.button7);
        btnProfileDokter = (ImageView) findViewById(R.id.button4);

        btn_logout = (ImageView)  findViewById(R.id.btn_logout_dokter);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MenuDokter.this);
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





        btnCatatanPasienDariDokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catatandariDokter();
            }
        });

        btnHistoryDokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                historyDokter();
            }
        });

        btnLihatJadwalSaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lihatJadwalSaya();
            }
        });

        btnNotifDokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifDokter();
            }
        });

        btnProfileDokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profileDokter();
            }
        });
    }

//    private void pengumuman(){
//        Intent intent6 = new Intent(this, Pengumuman.class);
//        startActivity(intent6);
//    }



    private void catatandariDokter(){
        Intent intent5 = new Intent(this, CatatanPasienDariDokter.class);
        startActivity(intent5);
    }

    private void historyDokter(){
        Intent intent3 = new Intent(this, HistoryDokter.class);
        startActivity(intent3);
    }

    private void lihatJadwalSaya(){
        Intent intent2 = new Intent(this, JadwalSayaMenuDokter.class);
        startActivity(intent2);
    }

    private void notifDokter(){
        Intent intent1 = new Intent(this, NotifDokter.class);
        startActivity(intent1);
    }

    private void profileDokter(){
        Intent intent = new Intent(this, ProfileDokter.class);
        startActivity(intent);
    }

    private void login(){
        Intent intent4 = new Intent(this, MainActivity.class);
        startActivity(intent4);
    }
}