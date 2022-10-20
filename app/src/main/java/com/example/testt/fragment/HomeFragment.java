package com.example.testt.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import com.example.sidangmahasiswa.R;
import com.example.sidangmahasiswa.activity.AddLogbookActivity;

public class HomeFragment extends Fragment {
    RelativeLayout btnTambahLogBook;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btnTambahLogBook = view.findViewById(R.id.tambahLogBook);

        btnTambahLogBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddLogbookActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}