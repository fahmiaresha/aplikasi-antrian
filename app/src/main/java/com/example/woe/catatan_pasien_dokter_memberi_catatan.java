package com.example.woe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class catatan_pasien_dokter_memberi_catatan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catatan_pasien_dokter_memberi_catatan);

        Button btn_kirim_catatan_dari_dokter = (Button)  findViewById(R.id.btn_kirim_catatan_dari_dokter);
        btn_kirim_catatan_dari_dokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(catatan_pasien_dokter_memberi_catatan.this);
                dialog.setContentView(R.layout.alert_kirim_catatan);
                dialog.setTitle("alert");

                Button btn_ok_kirim_catatan = (Button) dialog.findViewById(R.id.btn_ok_kirim_catatan);
                btn_ok_kirim_catatan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}