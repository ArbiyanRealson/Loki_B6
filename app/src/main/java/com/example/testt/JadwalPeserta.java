package com.example.testt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.testt.adapter.ListPesertaAdapter;
import com.example.testt.datamodels.AudiencesItem;
import com.example.testt.datamodels.ListPesertaResponse;
import com.example.testt.retrofit.StoryClient;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JadwalPeserta extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListPesertaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_peserta);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");
        Log.d("list",token.toString());

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ListPesertaAdapter();
        recyclerView.setAdapter(adapter);

        //Minta Data Ke server
        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        StoryClient client = retrofit.create(StoryClient.class);

        Call<ListPesertaResponse> call = client.getAudiens("Bearer " + token);

        call.enqueue(new Callback<ListPesertaResponse>() {
            @Override
            public void onResponse(Call<ListPesertaResponse> call, Response<ListPesertaResponse> response) {

                Log.d("ListLogbook-Debug", response.toString());
                ListPesertaResponse listPesertaResponse = response.body();
                if(listPesertaResponse != null ){

                    List<AudiencesItem> audiences = listPesertaResponse.getAudiences();
                    Log.d("ListLogbook-Debug", audiences.toString());
                    adapter.setItemList(audiences);
                }

            }

            @Override
            public void onFailure(Call<ListPesertaResponse> call, Throwable t) {

            }
        });
    }



    public void detailSeminar (View view)
    {
        Intent intent = new Intent(JadwalPeserta.this, DetailSeminar.class);
        startActivity(intent);
    }

    public void tambahPeserta (View view)
    {
        Intent intent = new Intent(JadwalPeserta.this, TambahPeserta.class);
        startActivity(intent);
    }

}