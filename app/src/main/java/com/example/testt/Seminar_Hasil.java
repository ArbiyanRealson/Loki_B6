package com.example.testt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.testt.datamodels.FormSemhasResponse;
import com.example.testt.datamodels.LoginResponse;
import com.example.testt.datamodels.LogoutResponse;
import com.example.testt.retrofit.StoryClient;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Seminar_Hasil extends AppCompatActivity {
    String token;
    Button ajukan;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seminar_hasil);
        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        token = sharedPref.getString("TOKEN", "");
        sharedPrefManager = new SharedPrefManager(this);

        ajukan = findViewById(R.id.ajukan);

        ajukan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ajukan();
            }

            public void ajukan() {
                StoryClient client = RetrofitClientInstance.getRetrofitInstance().create(StoryClient.class);


                Call<FormSemhasResponse> call = client.getFromSemhas("Bearer " + token);
                call.enqueue(new Callback<FormSemhasResponse>() {
                    @Override
                    public void onResponse(Call<FormSemhasResponse> call, Response<FormSemhasResponse> response) {
                        if (response.isSuccessful()) {
                            FormSemhasResponse ganti = response.body();
                            Toast.makeText(Seminar_Hasil.this, ganti.getMessage(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Seminar_Hasil.this, JadwalSemhas.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<FormSemhasResponse> call, Throwable t) {

                    }
                });

            }


        });
    }
}

//    private void createNotificationChannel() {
//        // Create the NotificationChannel, but only on API 26+ because
//        // the NotificationChannel class is new and not in the support library
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            CharSequence name = "1";
//            String description = "1";
//            int importance = NotificationManager.IMPORTANCE_DEFAULT;
//            NotificationChannel channel = new NotificationChannel("1", name, importance);
//            channel.setDescription(description);
//            // Register the channel with the system; you can't change the importance
//            // or other notification behaviors after this
//            NotificationManager notificationManager = getSystemService(NotificationManager.class);
//            notificationManager.createNotificationChannel(channel);
//        }
//    }
//
//    public void ajukan(View view) {
//        Intent intent = new Intent(Seminar_Hasil.this, JadwalSemhas.class);
//        startActivity(intent);
//
//        createNotificationChannel();
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "1")
//                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setContentTitle("Tugas Besar PTB")
//                .setContentText("Seminar Hasil Telah Diajukan")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//
//        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
//        notificationManagerCompat.notify(1, builder.build());
//
//
//    }