package com.example.testt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TambahPeserta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_peserta);
    }
    public void end(View view)
    {
        Intent intent = new Intent(TambahPeserta.this, JadwalPeserta.class);
        startActivity(intent);
    }
}