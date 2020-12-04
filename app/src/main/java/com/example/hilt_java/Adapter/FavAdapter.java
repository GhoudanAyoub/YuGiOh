package com.example.hilt_java.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hilt_java.Models.Fav;
import com.example.hilt_java.Models.cardImage;
import com.example.hilt_java.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.FavAdapterHolder> {

    private List<Fav> FavList = new ArrayList<>();
    private final Context context;

    public FavAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FavAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavAdapterHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull FavAdapterHolder holder, int position) {
        holder.t.setText(FavList.get(position).getCard().getName());
        holder.t2.setText(FavList.get(position).getCard().getAtk() + " ATK");
        holder.t3.setText(FavList.get(position).getCard().getDef() + " DEF");
        holder.t4.setText(FavList.get(position).getCard().getType());
        cardImage card = FavList.get(position).getCard().getCardImageList().get(0);
        Glide.with(context).load(card.getImage_url()).placeholder(R.drawable.backcard).into(holder.i);

    }

    @Override
    public int getItemCount() {
        return FavList.size();
    }

    public void setList(List<Fav> FavList) {
        this.FavList = FavList;
        notifyDataSetChanged();
    }

    public Fav getFavList(int position) {
        return FavList.get(position);
    }

    public class FavAdapterHolder extends RecyclerView.ViewHolder {

        TextView t, t2, t3, t4;
        ImageView i;

        public FavAdapterHolder(View itemView) {
            super(itemView);
            t = itemView.findViewById(R.id.name);
            t2 = itemView.findViewById(R.id.atk);
            t3 = itemView.findViewById(R.id.def);
            t4 = itemView.findViewById(R.id.type);
            i = itemView.findViewById(R.id.imageView);
        }
    }
}