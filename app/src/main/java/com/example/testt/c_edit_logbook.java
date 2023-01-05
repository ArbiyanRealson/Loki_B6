package com.example.testt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class c_edit_logbook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cedit_logbook);
    }
    public void a7detaillogbook(View view) {
        Intent intent = new Intent(c_edit_logbook.this, b_detail_logbook.class);
        startActivity(intent);
    }
    public void a7tambaheditlogbook(View view) {
        Intent intent = new Intent(c_edit_logbook.this, a_list_logbook.class);
        startActivity(intent);
    }
}