package com.example.testt.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testt.R;
import com.example.testt.models.logbookff;

import java.util.ArrayList;

public class list_logbook_adapter extends RecyclerView.Adapter<list_logbook_adapter.listlogbookVH>{

    ArrayList<logbookff> listLoogbook = new ArrayList<>();
    logbookClickListener listenerlb;


    public list_logbook_adapter(ArrayList<logbookff> listLoogbook) {
        this.listLoogbook = listLoogbook;
    }

    public void setListLoogbook(ArrayList<logbookff> listLoogbook) {
        this.listLoogbook = listLoogbook;
    }

    public void setListenerlb(logbookClickListener listenerlb) {
        this.listenerlb = listenerlb;
    }


    @NonNull
    @Override
    public listlogbookVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_listlogbook2sss, parent, false);
        return new listlogbookVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listlogbookVH holder, int position) {
        logbookff logbook = listLoogbook.get(position);
        holder.imageView4.setImageResource(R.drawable.ic_dalamproses);
        holder.texttanggal.setText(logbook.getTanggal());
        holder.imageView8.setImageResource(R.drawable.ic_panahkanan);
    }

    @Override
    public int getItemCount() {
        return listLoogbook.size();
    }

    public interface logbookClickListener{
        void onlogbookClick(logbookff logbook);
    }

    public class listlogbookVH extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView texttanggal;
        public ImageView imageView8, imageView4;

        public listlogbookVH(@NonNull View itemView) {
            super(itemView);
            imageView4 = itemView.findViewById(R.id.imageView4);
            texttanggal = itemView.findViewById(R.id.texttanggal) ;
            imageView8 = itemView.findViewById(R.id.imageView8);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            logbookff logbook = listLoogbook.get(getAdapterPosition());
            listenerlb.onlogbookClick(logbook);
        }
    }
}
