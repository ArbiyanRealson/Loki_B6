package com.example.testt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Seminar_Hasil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seminar_hasil);
    }
    public void ajukan(View view)
    {
        Intent intent = new Intent(Seminar_Hasil.this, JadwalSemhas.class);
        startActivity(intent);
    }
}