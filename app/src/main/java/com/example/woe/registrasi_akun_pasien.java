package com.example.woe;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class registrasi_akun_pasien extends AppCompatActivity {
    private TextView Signin;
    TextInputEditText no_ktp,no_kk,nama_lengkap,alamat_lengkap,no_telp,email,password,username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi_akun_pasien);

        no_ktp=(TextInputEditText) findViewById(R.id.no_ktp);
        no_kk=(TextInputEditText) findViewById(R.id.no_kk);
        nama_lengkap=(TextInputEditText) findViewById(R.id.nama_lengkap);
        username=(TextInputEditText) findViewById(R.id.username);
        password=(TextInputEditText) findViewById(R.id.password);
        alamat_lengkap=(TextInputEditText) findViewById(R.id.alamat_lengkap);
        no_telp=(TextInputEditText) findViewById(R.id.no_telp);
        email=(TextInputEditText) findViewById(R.id.email);

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
                register();
            }
        });
    }

    private void signin(){
        Intent intent5 = new Intent(this, MainActivity.class);
        startActivity(intent5);
    }

    void register(){
        String url="https://android.tech.masuk.id/api/input-pasien";
        StringRequest respon=new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            String status=jsonObject.getString("message");
                            if (status.equals("ok")){
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
//                                AlertDialog.Builder builder= new AlertDialog.Builder(registrasi_akun_pasien.this);
//                                builder.setTitle("Success");
//                                builder.setMessage("You're already register");
//                                builder.setPositiveButton("Oke",
//                                        new DialogInterface.OnClickListener() {
//                                            @Override
//                                            public void onClick(DialogInterface dialog, int which) {
//                                                dialog.dismiss();
//                                                finish();
//                                            }
//                                        });
//                                AlertDialog dialog= builder.create();
//                                dialog.show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> form=new HashMap<>();
                form.put("NO_KK",no_kk.getText().toString());
                form.put("NO_KTP",no_ktp.getText().toString());
                form.put("USERNAME",username.getText().toString());
                form.put("EMAIL",email.getText().toString());
                form.put("PASSWORD",password.getText().toString());
                form.put("NAMA",nama_lengkap.getText().toString());
                form.put("NO_TELP",no_telp.getText().toString());
                form.put("ALAMAT",alamat_lengkap.getText().toString());
                return form;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(respon);
    }
}