package com.example.testt;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testt.datamodels.DetailSeminarResponse;
import com.example.testt.retrofit.StoryClient;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSeminar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_seminar);

        getData();
    }

    public void getData()
    {
        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");
        SharedPrefManager sharedPrefManager = new SharedPrefManager(this);
        StoryClient client = RetrofitClientInstance.getRetrofitInstance().create(StoryClient.class);
        Call<DetailSeminarResponse> call = client.detailseminar("Bearer "+ token);

        call.enqueue(new Callback<DetailSeminarResponse>()
        {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<DetailSeminarResponse> call, Response<DetailSeminarResponse> response)
            {

                    DetailSeminarResponse data = response.body();
                    Log.d("hasilnya", String.valueOf(data.getReviewers(getPackageName())));
                if(response.isSuccessful())
                {
                    String register = data.getRegisteredAt();
                    TextView tvregister = findViewById(R.id.registered);
                    tvregister.setText("Mendaftar pada : "+register );

                    Integer thesis = data.getThesisId();
                    TextView tvthesis = findViewById(R.id.thesisid);
                    tvthesis.setText("Kode Tesis : "+thesis.toString());

                    String jurnal = data.getFileJournal();
                    TextView tvjurnal = findViewById(R.id.jurnal);
                    tvjurnal.setText("File Jurnal : "+jurnal );

                    Integer fileRepor = data.getRoomId();
                    TextView tvdata = findViewById(R.id.room);
                    tvdata.setText("Ruangan : "+fileRepor.toString());

                    String fileReport = data.getFileReport();
                    TextView tvTest = findViewById(R.id.filereport);
                    tvTest.setText("File Laporan : "+fileReport);


                    String seminarat = data.getSeminarAt();
                    TextView tanggaltv = findViewById(R.id.seminar);
                    tanggaltv.setText("Seminar pada : "+seminarat);

                    Integer status = data.getStatus();
                    TextView tvstatus = findViewById(R.id.status);
                    tvstatus.setText("Status : "+status);




//                    List<ReviewersItem> file = data.getReviewers(getPackageName());
//                    TextView pengujitv = findViewById(R.id.penguji); pengujitv.setText(file.toString());
//
//                    List<ReviewersItem> filee = data.getReviewers(getPackageName());
//                    TextView pengujiitv = findViewById(R.id.pengujii); pengujiitv.setText(filee.toString());

//                    List<ReviewersItem> reviewersItems = DetailSeminarResponse.getreviewers();
//                    Log.d("ListLogbook-Debug", reviewersItems.toString());
//                    adapter.setItemList(reviewersItems);
//                    }
                }

            }

            @Override
            public void onFailure(Call<DetailSeminarResponse> call, Throwable t) {
                Toast.makeText(DetailSeminar.this, "GAGAL", Toast.LENGTH_SHORT).show();
            };


        });
    }
}
