package com.example.hilt_java.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hilt_java.Models.card;
import com.example.hilt_java.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;

public class cardAdapter extends RecyclerView.Adapter<cardAdapter.cardAdapterHolder> {

    private List<card> cardList = new ArrayList<>();
    private Context context;

    public cardAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public cardAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new cardAdapterHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull cardAdapterHolder holder, int position) {
        holder.t.setText(cardList.get(position).getName());
        holder.t2.setText(cardList.get(position).getAtk()+" ATK");
        holder.t3.setText(cardList.get(position).getDef()+" DEF");
        holder.t4.setText(cardList.get(position).getType());
        //Glide.with(context).load(cardList.get(position).getCard_images().getCardImageList().get(0).getImage_url()).into(holder.i);
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public void setList(List<card> cardList) {
        this.cardList = cardList;
        notifyDataSetChanged();
    }

    public card getCardList(int position){
        return cardList.get(position);
    }

    public class cardAdapterHolder extends RecyclerView.ViewHolder {

        TextView t,t2,t3,t4;
        ImageView i;
        public cardAdapterHolder(View itemView) {
            super(itemView);
            t = itemView.findViewById(R.id.textView);
            t2 = itemView.findViewById(R.id.textView2);
            t3 = itemView.findViewById(R.id.textView3);
            t4 = itemView.findViewById(R.id.textView4);
            i = itemView.findViewById(R.id.imageView);
        }
    }
}