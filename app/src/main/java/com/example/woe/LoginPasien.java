package com.example.woe;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginPasien extends AppCompatActivity {

    private Button mLoginMenuPasien;
    private TextView ForgotPasswordPasien;
    private TextView Signup;
    EditText email_pasien,password_pasien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pasien);

        email_pasien = (EditText) findViewById(R.id.email_pasien);
        password_pasien = (EditText) findViewById(R.id.password_pasien);

        mLoginMenuPasien = (Button) findViewById(R.id.btn_login_pasien);
        ForgotPasswordPasien = (TextView) findViewById(R.id.forgot_password_pasien);
        Signup = (TextView) findViewById(R.id.textview_sign_up);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
        ForgotPasswordPasien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lupapassword();
            }
        });

        mLoginMenuPasien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cek_login();
//                menuPasien();
            }
        });
    }

    private void menuPasien(){
        Intent intent = new Intent(this, MenuPasien.class);
        intent.putExtra("name", "username");
        startActivity(intent);
    }

    private void register(){
        Intent intent55 = new Intent(this, registrasi_akun_pasien.class);
        startActivity(intent55);
    }

    private void Lupapassword(){
        Intent intent4 = new Intent(this, lupa_password.class);
        startActivity(intent4);
    }

    private void signup(){
        Intent intent5 = new Intent(this, registrasi_akun_pasien.class);
        startActivity(intent5);
    }

    void cek_login(){
        String url="https://android.tech.masuk.id/api/login-pasien";
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
                                menuPasien();
                            }
                            if (status.equals("salah_password")){
                                //alert_salah_password
                                final Dialog dialog = new Dialog(LoginPasien.this);
                                dialog.setContentView(R.layout.alert_gagal_login);
                                dialog.setTitle("alert");

                                Button btn_alert = (Button) dialog.findViewById(R.id.btn_ok_gagal_login);
                                btn_alert.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog.dismiss();
                                    }
                                });
                                dialog.show();
                            }
                            if (status.equals("akun_tidak_terdaftar")){
                                final Dialog dialog = new Dialog(LoginPasien.this);
                                dialog.setContentView(R.layout.alert_akun_tidak_terdaftar);
                                dialog.setTitle("alert");

                                Button btn_ok = (Button) dialog.findViewById(R.id.btn_ok);
                                btn_ok.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog.dismiss();
                                    }
                                });

                                Button btn_registrasi = (Button) dialog.findViewById(R.id.btn_registrasi);
                                btn_registrasi.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        register();
                                    }
                                });

                                dialog.show();
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
                form.put("email_pasien",email_pasien.getText().toString());
                form.put("password_pasien",password_pasien.getText().toString());
                return form;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(respon);
    }
}