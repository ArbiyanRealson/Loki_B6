package com.example.testt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class JadwalPeserta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_peserta);
    }
    public void detailSeminar(View view)
    {
        Intent intent = new Intent(JadwalPeserta.this, DetailSeminar.class);
        startActivity(intent);
    }

    public void tambahPeserta(View view)
    {
        Intent intent = new Intent(JadwalPeserta.this, TambahPeserta.class);
        startActivity(intent);
    }
}