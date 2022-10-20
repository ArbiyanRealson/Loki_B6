package com.example.testt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sidang_ta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidang_ta);
    }

    public void ajukann(View view) {
        Intent intent = new Intent(sidang_ta.this,pendaftaran_sidang.class);
        startActivity(intent);
    }
}