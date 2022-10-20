package com.example.testt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class pendaftaran_sidang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran_sidang);
    }


    public void ajuk(View view) {
        Intent intent = new Intent(pendaftaran_sidang.this,jadwal_sidang.class);
        startActivity(intent);
    }
}