package com.example.woe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class detail_catatan_pasien_dokter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_catatan_pasien_dokter);

        Button btn_konfirmasi = (Button) findViewById(R.id.btn_konfirmasi);
        btn_konfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(detail_catatan_pasien_dokter.this);
                dialog.setContentView(R.layout.alert_terima_antrian);
                dialog.setTitle("alert");

                Button btn_tolak_antrian = (Button) dialog.findViewById(R.id.btn_tolak_antrian);
                btn_tolak_antrian.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                Button btn_terima_antrian = (Button) dialog.findViewById(R.id.btn_terima_antrian);
                btn_terima_antrian.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btn_konfirmasi();
                    }
                });

                dialog.show();
            }
        });
    }

    private void btn_konfirmasi(){
        Intent intent4 = new Intent(this, NotifDokter.class);
        startActivity(intent4);
    }
}