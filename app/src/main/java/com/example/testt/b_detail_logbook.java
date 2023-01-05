package com.example.testt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.testt.datamodels.DetailLogbookResponse;
import com.example.testt.retrofit.StoryClient;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class b_detail_logbook extends AppCompatActivity {
    TextView tanggal, nama, nimmhs, pembimbing, catt, masalah;
    Button edit_btn;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bdetail_logbook);

        SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
        token = sharedPref.getString("TOKEN", "");

        detailLogbook();
    }

    public void detailLogbook(){
        tanggal = findViewById(R.id.textView3);
        nama = findViewById(R.id.textView5);
        nimmhs = findViewById(R.id.textView7);
        pembimbing = findViewById(R.id.texttanggal);
        catt = findViewById(R.id.textView12);
        masalah = findViewById(R.id.textView14);


        SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);

        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();
        StoryClient client = retrofit.create(StoryClient.class);




        Call<DetailLogbookResponse> call = client.detailLogbook("Bearer "+token);
        call.enqueue(new Callback<DetailLogbookResponse>() {
            @Override
            public void onResponse(Call<DetailLogbookResponse> call, Response<DetailLogbookResponse> response) {
                if (response.isSuccessful()){
                    /*if (!response.isSuccessful()) {
                        jam.setText("waktu sidang");
                        lokasi.setText("lokasi sidang");
                        tanggal.setText("nama penguji");
                        return;
                    }else {*/
                    DetailLogbookResponse detailLogbookResponse = response.body();

                    String trialAt = detailLogbookResponse.getTrialAt();
                    String startAt = detailLogbookResponse.getStartAt();
                    /*                        String roomId = detailSidanggResponse.getRoomId().toString();*/
/*                        String name2 = detailSidanggResponse.getExaminers();

                        penguji.setText(name2);*/
                    tanggal.setText(trialAt);
                    //jam.setText(startAt);
                    /*                        lokasi.setText((CharSequence) roomId);*/

                    /*      }*/
                }
            }
            @Override
            public void onFailure(Call<DetailLogbookResponse> call, Throwable t) {
                Toast.makeText(b_detail_logbook.this, "Terjadi error", Toast.LENGTH_SHORT).show();
            }
        });


/*        Call<SupervisorsItem> call2 = client.supervisor("Bearer "+token);
        call2.enqueue(new Callback<SupervisorsItem>() {
            @Override
            public void onResponse(Call<SupervisorsItem> call2, Response<SupervisorsItem> response) {
                if (response.isSuccessful()){
                    if (!response.isSuccessful()) {
                        pembimbing.setText("Nama pembimbing");
                        return;
                    }else {
                        SupervisorsItem supervisorsItem = response.body();

                        assert supervisorsItem != null;
                        String name = supervisorsItem.getName();

                        pembimbing.setText(name);
                    }
                }
            }
            @Override
            public void onFailure(Call<SupervisorsItem> call2, Throwable t) {
                Toast.makeText(b5_detail_sidang.this, "Terjadi error", Toast.LENGTH_SHORT).show();
            }
        });*/
/*
        Call<ExaminersItem> call3 = client.examiner("Bearer "+token);
        call3.enqueue(new Callback<ExaminersItem>() {
            @Override
            public void onResponse(Call<ExaminersItem> call3, Response<ExaminersItem> response) {
                if (response.isSuccessful()){
                 *//*   if (!response.isSuccessful()) {
                        penguji.setText("Nama penguji");
                        return;
                    }else {*//*
                        ExaminersItem examinersItem = response.body();

                        String name = examinersItem.getName();

                        penguji.setText(name);
             *//*       }*//*
                }
            }
            @Override
            public void onFailure(Call<ExaminersItem> call3, Throwable t) {
                Toast.makeText(b5_detail_sidang.this, "Terjadi error", Toast.LENGTH_SHORT).show();
            }
        });*/

        Call<DetailTAResponse> call4 = client.detailta("Bearer "+token);
        call4.enqueue(new Callback<DetailTAResponse>() {
            @Override
            public void onResponse(Call<DetailTAResponse> call4, Response<DetailTAResponse> response) {
                if (response.isSuccessful()){
                  /*  if (!response.isSuccessful()) {
                        judul.setText("judul TA");
                        return;
                    }else {*/
                    DetailTAResponse detailTAResponse = response.body();

                    String title = detailTAResponse.getTitle();
                    String name = detailTAResponse.getStudent().getName();
                    String nim = detailTAResponse.getStudent().getNim();
/*                        String name1 = detailTAResponse.getSupervisors();

                        pembimbing.setText(name1);*/
                    nama.setText(name);
                    nimmhs.setText(nim);
                    judul.setText(title);
                    /*        }*/
                }
            }
            @Override
            public void onFailure(Call<DetailTAResponse> call4, Throwable t) {
                Toast.makeText(b5_detail_sidang.this, "Terjadi error", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void a6listlogbook(View view) {
        Intent intent = new Intent(b_detail_logbook.this, a_list_logbook.class);
        startActivity(intent);
    }
    public void a6editlogbook(View view) {
        Intent intent = new Intent(b_detail_logbook.this, c_edit_logbook.class);
        startActivity(intent);
    }
}