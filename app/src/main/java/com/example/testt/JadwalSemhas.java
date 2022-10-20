package com.example.testt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class JadwalSemhas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_semhas);
    }
    public void detailSeminar(View view)
    {
        Intent intent = new Intent(JadwalSemhas.this, DetailSeminar.class);
        startActivity(intent);
    }

    public void tambahPeserta(View view)
    {
        Intent intent = new Intent(JadwalSemhas.this, TambahPeserta.class);
        startActivity(intent);
    }
}