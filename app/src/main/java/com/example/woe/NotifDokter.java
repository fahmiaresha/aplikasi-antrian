package com.example.woe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotifDokter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif_dokter);

        Button btn_terima_tolak_antrian = (Button) findViewById(R.id.btn_terima_tolak_antrian);
        btn_terima_tolak_antrian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_terima_tolak_antrian();
            }
        });

        Button detail_pasien = (Button) findViewById(R.id.detail_pasien);
        detail_pasien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detail_pasien();
            }
        });
    }

    private void btn_terima_tolak_antrian(){
        Intent intent4 = new Intent(this, detail_catatan_pasien_dokter.class);
        startActivity(intent4);
    }

    private void detail_pasien(){
        Intent intent5 = new Intent(this, detail_antrian_catatan_dokter.class);
        startActivity(intent5);
    }
}