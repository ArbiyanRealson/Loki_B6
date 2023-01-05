package com.example.testt.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testt.R;
import com.example.testt.datamodels.AudiencesItem;

import java.util.ArrayList;
import java.util.List;

public class ListPesertaAdapter extends RecyclerView.Adapter<ListPesertaAdapter.ViewHolder> {




    private List<AudiencesItem> itemList = new ArrayList<>();

    public void setItemList(List<AudiencesItem> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        AudiencesItem audiences = itemList.get(position);
        holder.namePeserta.setText(audiences.getName());
        holder.nimPeserta.setText(audiences.getNim());
        holder.phonePeserta.setText(audiences.getPhone());

        Glide.with(holder.imageViewphoto).load(audiences.getPhoto()).into(holder.imageViewphoto);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        public TextView namePeserta;
        public TextView nimPeserta;
        public TextView phonePeserta;

        public ImageView imageViewphoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            namePeserta = itemView.findViewById(R.id.nama);
            nimPeserta = itemView.findViewById(R.id.nim);
            phonePeserta = itemView.findViewById(R.id.noHP);

            imageViewphoto = itemView.findViewById(R.id.avatar);
        }
    }
}
