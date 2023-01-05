package com.example.testt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.testt.datamodels.LogoutResponse;
import com.example.testt.retrofit.StoryClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.testt.RetrofitClientInstance;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

public class semhas extends AppCompatActivity {
    String token;
    private Boolean isLoggedIn = false;
    Button log_out;
    SharedPrefManager sharedPrefManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        token = sharedPref.getString("TOKEN","");
        Intent mainIntent = getIntent();
        String username = mainIntent.getStringExtra("USERX");
        isLoggedIn = mainIntent.getBooleanExtra("LOGX", false);

        if (token.equals("")) {
            //Panggil activity Login
            Intent loginIntent = new Intent(this,login.class);
            startActivity(loginIntent);
            finish();
        }
        setContentView(R.layout.activity_semhas);


        //sharedPrefManager = new SharedPrefManager(this);

        log_out = findViewById(R.id.log_out);

        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                logout();
            }
        });

    }



    public void logout(){
        StoryClient client = RetrofitClientInstance.getRetrofitInstance().create(StoryClient.class);


        Call<LogoutResponse> call = client.logout("Bearer " + token );
        call.enqueue(new Callback<LogoutResponse>() {
            @Override
            public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
                if(response.isSuccessful()){
                    LogoutResponse ganti = response.body();
                    Toast.makeText(semhas.this, ganti.getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(semhas.this, splash.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<LogoutResponse> call, Throwable t) {

            }
        });
    }
  //});}

    public void aju(View view) {
        Intent intent = new Intent(semhas.this,Seminar_Hasil.class);
        startActivity(intent);
    }

    public void sidang(View view) {
        Intent intent = new Intent(semhas.this, sidang_ta.class);
        startActivity(intent);
    }

    public void kelistlb(View view) {
        Intent intent = new Intent(semhas.this, a_list_logbook.class);
        startActivity(intent);
    }

//    public void logout(View view) {
//        Intent intent = new Intent(semhas.this, splash.class);
//        startActivity(intent);
//    }
}

//    public void logout(View view) {
//        Intent intent = new Intent(semhas.this,splash.class);
//        startActivity(intent);
//    }
