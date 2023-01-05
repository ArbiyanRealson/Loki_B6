package com.example.testt.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testt.R;
import com.example.testt.datamodels.LogbooksItem;

import java.util.ArrayList;
import java.util.List;

public class list_logbook_adapter extends RecyclerView.Adapter<list_logbook_adapter.listlogbookVH>{

    private List<LogbooksItem> itemList= new ArrayList<>();
    public void setItemList(List<LogbooksItem> itemList) {

        this.itemList = itemList;
        notifyDataSetChanged();
    }

/*    ArrayList<logbook> listLoogbook = new ArrayList<>();*/
    logbookClickListener listenerlb;


/*    public list_logbook_adapter() {
        this.listLoogbook = listLoogbook;
    }

    public void setListLoogbook(ArrayList<logbook> listLoogbook) {
        this.listLoogbook = listLoogbook;
    }*/

    public void setListenerlb(logbookClickListener listenerlb) {

        this.listenerlb = listenerlb;
    }


    @NonNull
    @Override
    public listlogbookVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_listlogbook2,parent,false);
        return new listlogbookVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listlogbookVH holder, int position) {
        LogbooksItem list = itemList.get(position);

        /*holder.imageView4.setImageResource(R.drawable.ic_dalamproses);*/
        holder.texttanggal.setText(list.getDate());
/*        holder.imageView8.setImageResource(R.drawable.ic_panahkanan);*/
    }

    @Override
    public int getItemCount() {

        return itemList.size();
    }

    public interface logbookClickListener{
        void onlogbookClick(LogbooksItem logbook);
    }

    public class listlogbookVH extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView texttanggal;
        public ImageView imageView8, imageView4;

        public listlogbookVH(@NonNull View itemView) {
            super(itemView);
/*            imageView4 = itemView.findViewById(R.id.imageView4);*/
            texttanggal = itemView.findViewById(R.id.texttanggal) ;
/*            imageView8 = itemView.findViewById(R.id.imageView8);*/

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            LogbooksItem logbook = itemList.get(getAdapterPosition());
            listenerlb.onlogbookClick(logbook);
        }
    }
}
