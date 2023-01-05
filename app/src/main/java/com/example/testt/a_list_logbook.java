package com.example.testt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.testt.adapters.list_logbook_adapter;
import com.example.testt.datamodels.ListLogbookkResponse;
import com.example.testt.datamodels.LogbooksItem;
import com.example.testt.retrofit.StoryClient;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class a_list_logbook extends AppCompatActivity implements list_logbook_adapter.logbookClickListener{
    private RecyclerView rvLogbook;
    private list_logbook_adapter adapter;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alist_logbook);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        token = sharedPref.getString("TOKEN","");


/*        LinearLayoutManager layoutManager = new LinearLayoutManager(this);*/

/*        rvLogbook.setLayoutManager(layoutManager);
        rvLogbook.setAdapter(adapter);*/



        RecyclerView rvLogbook = findViewById(R.id.rv_logbook);

        rvLogbook.setLayoutManager(new LinearLayoutManager(this));
        adapter = new list_logbook_adapter();
        adapter.setListenerlb(this);
        rvLogbook.setAdapter(adapter);

        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();
        StoryClient client = retrofit.create(StoryClient.class);

        Call<ListLogbookkResponse> call = client.listlb("Bearer "+token);
        call.enqueue(new Callback<ListLogbookkResponse>() {
            @Override
            public void onResponse(Call<ListLogbookkResponse> call, Response<ListLogbookkResponse> response) {
                ListLogbookkResponse listLogbookkResponse = response.body();
                if (listLogbookkResponse != null){
                    List<LogbooksItem> logbooks = listLogbookkResponse.getLogbooks();
                    adapter.setItemList(logbooks);
                }
            }

            @Override
            public void onFailure(Call<ListLogbookkResponse> call, Throwable t) {

            }
        });

        /*list_logbook_adapter adapter = new list_logbook_adapter(getlogbook());
        adapter.setListenerlb(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvLogbook.setLayoutManager(layoutManager);
        rvLogbook.setAdapter(adapter);*/

    }

////cek point
    /*public ArrayList<logbook> getlogbook(){
        ArrayList<logbook> listlogbook = new ArrayList<>();
        listlogbook.add(new logbook(
                null,
                "1 Maret 2022",
                null
        ));
        listlogbook.add(new logbook(
                null,
                "2 Maret 2022",
                null
        ));
        listlogbook.add(new logbook(
                null,
                "3 Maret 2022",
                null
        ));
        return listlogbook;
    }
*/
    public void a5kehomescreen(View view) {
        Intent intent = new Intent(a_list_logbook.this, semhas.class);
        startActivity(intent);
    }
    public void a5tambahlogbook(View view) {
        Intent intent = new Intent(a_list_logbook.this, d_tambah_logbook.class);
        startActivity(intent);
    }


    @Override
    public void onlogbookClick(LogbooksItem logbook) {
        Intent detaillogbook = new Intent(this, b_detail_logbook.class);
        detaillogbook.putExtra("panah",logbook.getDate());
        startActivity(detaillogbook);
    }
}