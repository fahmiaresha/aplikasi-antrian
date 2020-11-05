package com.example.woe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mLoginDokterButton;
    private Button mLoginPasienButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginDokterButton = (Button) findViewById(R.id.button);
        mLoginPasienButton = (Button) findViewById(R.id.button2);

        mLoginDokterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginDokter();
            }
        });

        mLoginPasienButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPasien();
            }
        });
    }

    private void loginDokter(){
        Intent intent = new Intent(this, LoginDokter.class);
        startActivity(intent);
    }

    private void loginPasien(){
        Intent intent1 = new Intent(this, LoginPasien.class);
        startActivity(intent1);
    }
}