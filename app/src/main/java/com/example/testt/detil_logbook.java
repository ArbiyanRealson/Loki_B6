package com.example.testt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class detil_logbook extends AppCompatActivity {
    String panah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semhas);

        Intent detailIntent = getIntent();
        if(detailIntent != null){
            panah = detailIntent.getStringExtra("panah");
        }
    }
}