package com.example.testt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class semhas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semhas);
    }

    public void aju(View view) {
        Intent intent = new Intent(semhas.this,Seminar_Hasil.class);
        startActivity(intent);
    }
}