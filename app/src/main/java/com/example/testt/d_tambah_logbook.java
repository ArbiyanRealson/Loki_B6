package com.example.testt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testt.datamodels.DetailLogbookResponse;
import com.example.testt.datamodels.DetailTAResponse;
import com.example.testt.datamodels.TambahLogbookResponse;
import com.example.testt.retrofit.StoryClient;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class d_tambah_logbook extends AppCompatActivity {

    TextView pembimbing, tanggal, catt, masalah;
    Button simpan_btn;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtambah_logbook);
        simpan_btn = findViewById(R.id.button);

        SharedPreferences sharedPref = getSharedPreferences("prefs", MODE_PRIVATE);
        token = sharedPref.getString("TOKEN", "");

        simpan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tambahlogbook();
            }
        });
    }
    public void tambahlogbook() {
        pembimbing = findViewById(R.id.textInputEditText3);
        tanggal = findViewById(R.id.textInputEditText31);
        catt = findViewById(R.id.textInputEditText32);
        masalah = findViewById(R.id.textInputEditText33);

        simpan_btn = findViewById(R.id.button);

        String supervisor_id = pembimbing.getText().toString();
        String date = tanggal.getText().toString();
        String progress = catt.getText().toString();
        String problem = masalah.getText().toString();

        simpan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(new OkHttpClient.Builder().build())
                        .build();

                StoryClient client = retrofit.create(StoryClient.class);

                Call<TambahLogbookResponse> call = client.tambahLogbook(supervisor_id,date, progress, problem,"Bearer "+token);

                call.enqueue(new Callback<TambahLogbookResponse>() {
                    @Override
                    public void onResponse(Call<TambahLogbookResponse> call, Response<TambahLogbookResponse> response) {

                        if (response.isSuccessful()) {
                            TambahLogbookResponse tambahJudulResponse = response.body();
                            if (tambahJudulResponse != null) {
                                Toast.makeText(d_tambah_logbook.this, "Berhasil tambah progress", Toast.LENGTH_SHORT).show();

                                SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
                                SharedPreferences.Editor editor= sharedPref.edit();
                                editor.apply();

                                Intent Intent = new Intent(d_tambah_logbook.this, semhas.class);
                                startActivity(Intent);
                            }
                        } else {
                            Toast.makeText(d_tambah_logbook.this, "Gagal tambah progress", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<TambahLogbookResponse> call, Throwable t) {
                        Toast.makeText(d_tambah_logbook.this, "Gagal tambah progress", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void a8kehomescreen(View view) {
        Intent intent = new Intent(d_tambah_logbook.this, semhas.class);
        startActivity(intent);
    }
}