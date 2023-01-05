package com.example.testt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.testt.adapters.listlogbook_adapteree;
import com.example.testt.models.logbookff;

import java.util.ArrayList;

public class a_list_logbook extends AppCompatActivity implements listlogbook_adapteree.logbookClickListener{
    private RecyclerView rvLogbook;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alist_logbook);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        token = sharedPref.getString("TOKEN","");



        rvLogbook = findViewById(R.id.rv_logbook);

        listlogbook_adapteree adapter = new listlogbook_adapteree(getlogbook());
        adapter.setListenerlb(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvLogbook.setLayoutManager(layoutManager);
        rvLogbook.setAdapter(adapter);
    }


    public ArrayList<logbookff> getlogbook(){
        ArrayList<logbookff> listlogbook = new ArrayList<>();
        listlogbook.add(new logbookff(
                null,
                "1 Maret 2022",
                null
        ));
        listlogbook.add(new logbookff(
                null,
                "2 Maret 2022",
                null
        ));
        listlogbook.add(new logbookff(
                null,
                "3 Maret 2022",
                null
        ));
        return listlogbook;
    }

    public void a5kehomescreen(View view) {
        Intent intent = new Intent(a_list_logbook.this, semhas.class);
        startActivity(intent);
    }
    public void a5tambahlogbook(View view) {
        Intent intent = new Intent(a_list_logbook.this, c_edit_logbook.class);
        startActivity(intent);
    }


    @Override
    public void onlogbookClick(logbookff logbook) {
        Intent detaillogbook = new Intent(this, b_detail_logbook.class);
        detaillogbook.putExtra("panah",logbook.getPanah());
        startActivity(detaillogbook);
    }
}