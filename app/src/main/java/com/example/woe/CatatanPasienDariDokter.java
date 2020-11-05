package com.example.woe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CatatanPasienDariDokter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catatan_pasien_dari_dokter);

        Button dokter_memberi_catatan = findViewById(R.id.dokter_memberi_catatan);
        dokter_memberi_catatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dokter_memberi_catatan();
            }
        });

        Button dokter_melihat_catatan = findViewById(R.id.dokter_melihat_catatan);
        dokter_melihat_catatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dokter_melihat_catatan();
            }
        });
    }

    private void dokter_memberi_catatan(){
        Intent intent4 = new Intent(this, catatan_pasien_dokter_memberi_catatan.class);
        startActivity(intent4);
    }

    private void dokter_melihat_catatan(){
        Intent intent5 = new Intent(this, catatan_pasien_dokter_melihat_catatan.class);
        startActivity(intent5);
    }
}