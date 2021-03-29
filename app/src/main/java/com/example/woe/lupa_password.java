package com.example.woe;

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

public class lupa_password extends AppCompatActivity {
    private Button btnSendPassword;
    private TextView TextviewLogin;
    EditText email_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_password);

        email_address = (EditText) findViewById(R.id.email_address);

        btnSendPassword = (Button) findViewById(R.id.btn_send_password);
        TextviewLogin = (TextView) findViewById(R.id.text_login);

        TextviewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        btnSendPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cek_email();
//                sendpassword();
            }
        });
    }

    private void sendpassword(){
        Intent intent5 = new Intent(this, kirim_password.class);
        startActivity(intent5);
    }

    private void login(){
        Intent intent4 = new Intent(this, MainActivity.class);
        startActivity(intent4);
    }

    void cek_email(){
        String url="https://android.tech.masuk.id/api/kirim-email";
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
                                sendpassword();
                            }
//                            if (status.equals("email_tidak_ditemukan")){
//                                //email_tidak_ditemukan
//                                final Dialog dialog = new Dialog(lupa_password.this);
//                                dialog.setContentView(R.layout.alert_email_tidak_ditemukan);
//                                dialog.setTitle("alert");
//
//                                Button btn_alert = (Button) dialog.findViewById(R.id.btn_ok_email_tidak_ditemukan);
//                                btn_alert.setOnClickListener(new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View v) {
//                                        dialog.dismiss();
//                                    }
//                                });
//                                dialog.show();
//                            }
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
                form.put("email_address",email_address.getText().toString());
                return form;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(respon);
    }


}