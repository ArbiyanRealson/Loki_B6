package com.example.testt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, homeFragment).commit();
                        return true;

                    case R.id.hasilSeminar:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, seminarHasilFragment).commit();
                        return true;

                    case R.id.sidang:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, sidangFragment).commit();
                        return true;
                    case R.id.logbook:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, logbookFragment).commit();
                        return true;
                    case R.id.account:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, accountFragment).commit();
                        return true;
                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.home);

    }

    HomeFragment homeFragment = new HomeFragment();
    SeminarHasilFragment seminarHasilFragment = new SeminarHasilFragment();
    SidangFragment sidangFragment = new SidangFragment();
    LogbookFragment logbookFragment = new LogbookFragment();
    AccountFragment accountFragment = new AccountFragment();

    public void masuk(View view)
    {
        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);
    }
}