package com.example.appwisata;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Daftar extends AppCompatActivity {

    EditText username, password, nama, email, conpassword;
    TextView txtLogin;
    Button btnDaftar;
    String levUser = "user";
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        username = (EditText) findViewById(R.id.edtUsernameDaftar);
        password = (EditText) findViewById(R.id.edtPasswordDaftar);
        conpassword = (EditText) findViewById(R.id.edtConPasswordDaftar);
        nama = (EditText) findViewById(R.id.edtNamaDaftar);
        email = (EditText) findViewById(R.id.edtEmailDaftar);
        btnDaftar = (Button) findViewById(R.id.btnDaftar);
        txtLogin = (TextView) findViewById(R.id.txtLogin);
        progressDialog = new ProgressDialog(Daftar.this);

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(Daftar.this,Login.class);
                startActivity(loginIntent);
            }
        });

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sNama = nama.getText().toString();
                String sUsername = username.getText().toString();
                String sEmail = email.getText().toString();
                String sPassword = password.getText().toString();
                String sConpassword = conpassword.getText().toString();
                //String slevUser = levUser;

                if (sPassword.equals(sConpassword) && !sPassword.equals("")){
                    CreateDataToServer(sUsername, sPassword, sNama, sEmail);
                    Intent loginIntent = new Intent(Daftar.this, Login.class);
                    startActivity(loginIntent);
                } else {
                    Toast.makeText(getApplicationContext(),"Password Tidak Sama", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void CreateDataToServer(final String username, final String password, final String nama, final String email){
        if (checkNetworkConnection()){
            progressDialog.show();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DbContract.SERVER_REGISTER_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String resp = jsonObject.getString("server_response");

                                if (resp.equals("[{\"status\":\"OK\"}]")){
                                    Toast.makeText(getApplicationContext(),"Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getApplicationContext(),resp, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("nama", nama);
                    params.put("username", username);
                    params.put("email", email);
                    params.put("password", password);
                    params.put("levUser", levUser);

                    return params;
                }
            };

            VolleyConnection.getInstance(Daftar.this).addToRequestQueue(stringRequest);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressDialog.cancel();

                }
            }, 2000);
        } else {
            Toast.makeText(getApplicationContext(),"Tidak Ada Koneksi Internet", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean checkNetworkConnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return (networkInfo != null && networkInfo.isConnected());
    }
}