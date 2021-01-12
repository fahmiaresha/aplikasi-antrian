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

public class LoginDokter extends AppCompatActivity {

    private Button mLoginMenuDokter;
    private TextView ForgotPasswordDokter;
    EditText email_dokter,password_dokter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_dokter);

        email_dokter = (EditText) findViewById(R.id.email_dokter);
        password_dokter = (EditText) findViewById(R.id.password_dokter);

        mLoginMenuDokter = (Button) findViewById(R.id.btn_login);
        ForgotPasswordDokter = (TextView) findViewById(R.id.forgot_password_dokter);

        mLoginMenuDokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cek_login();
//                menuDokter();
            }
        });

        ForgotPasswordDokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lupapassword();
            }
        });


    }

    private void menuDokter(){
        Intent intent = new Intent(this, MenuDokter.class);
        intent.putExtra("name", "username");
        startActivity(intent);
    }

    private void Lupapassword(){
        Intent intent4 = new Intent(this, lupa_password.class);
        startActivity(intent4);
    }
    void cek_login(){
        String url="https://android.tech.masuk.id/api/login-dokter";
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
                                menuDokter();
                            }
                            if (status.equals("salah_password")){
                                //alert_salah_password
                                final Dialog dialog = new Dialog(LoginDokter.this);
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
                form.put("email_dokter",email_dokter.getText().toString());
                form.put("password_dokter",password_dokter.getText().toString());
                return form;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(respon);
    }

}