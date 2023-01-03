package com.example.testt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.testt.datamodels.LoginResponse;
import com.example.testt.retrofit.StoryClient;
import com.google.android.material.textfield.TextInputEditText;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class login extends AppCompatActivity {

    TextInputEditText input_username , input_password;
    Button log_in;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        log_in = findViewById(R.id.log_in);
        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekLogin();
            }
        });


    }


    public void login(View view) {
        Intent intent = new Intent(login.this,semhas.class);
        startActivity(intent);
    }

    public void cekLogin() {
        input_username = findViewById(R.id.input_username);
        input_password = findViewById(R.id.input_password);
        log_in = findViewById(R.id.log_in);

        String username = input_username.getText().toString();
        String password = input_password.getText().toString();


        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        StoryClient client = retrofit.create(StoryClient.class);

        Call<LoginResponse> call = client.login(username, password);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Toast.makeText(login.this, "loading...", Toast.LENGTH_SHORT).show();
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    if (loginResponse != null) {

                        Toast.makeText(login.this, "Login Sukses", Toast.LENGTH_SHORT).show();


                        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("TOKEN", loginResponse.getAuthorisation().getToken());
                        editor.apply();


                        Intent mainIntent = new Intent(login.this, semhas.class);
                        startActivity(mainIntent);
                    }
                } else {
                    Toast.makeText(login.this, "Username/password anda salah", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(login.this, "Login Gagal", Toast.LENGTH_SHORT).show();
            }
   ;
        });
}}