package com.example.testt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class jadwal_sidang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_sidang);
    }



    public void detailSeminarr(View view) {
        Intent intent = new Intent(jadwal_sidang.this,detail_sidang.class);
        startActivity(intent);
    }
}