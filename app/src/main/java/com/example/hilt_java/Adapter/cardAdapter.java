package com.example.hilt_java.Adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hilt_java.Models.card;
import com.example.hilt_java.Models.cardImage;
import com.example.hilt_java.R;
import com.example.hilt_java.fullinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import io.reactivex.annotations.NonNull;

public class cardAdapter extends RecyclerView.Adapter<cardAdapter.cardAdapterHolder> implements Filterable {

    public static List<card> cardList = new ArrayList<>();
    private List<card> itemsModelListFiltered;
    private final Context context;
    public static Map<Integer,Float> map = new HashMap<>();
    public static int positions;

    public cardAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public cardAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new cardAdapterHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull cardAdapterHolder holder, @SuppressLint("RecyclerView") int position) {
        try {
            cardImage card = itemsModelListFiltered.get(position).getCardImageList().get(0);
            positions=holder.getAdapterPosition();
            map.put(position,new Random(6).nextFloat());
            holder.screen.setOnClickListener(v -> {
                        try {
                            context.getApplicationContext()
                                    .startActivity(new Intent(context.getApplicationContext(), fullinfo.class)
                                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                            .putExtra("card", itemsModelListFiltered.get(position))
                                            .putExtra("amaz", itemsModelListFiltered.get(0).getCardPriceList().get(0).getAmazon_price())
                                            .putExtra("ebay", itemsModelListFiltered.get(0).getCardPriceList().get(0).getEbay_price())
                                            .putExtra("cardmarket", itemsModelListFiltered.get(0).getCardPriceList().get(0).getCardmarket_price())
                                            .putExtra("tcgplayer", itemsModelListFiltered.get(0).getCardPriceList().get(0).getTcgplayer_price())
                                            .putExtra("image", card.getImage_url())

                                    );
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
            );
            holder.t.setText(itemsModelListFiltered.get(position).getName());
            holder.t2.setText(itemsModelListFiltered.get(position).getAtk() + " ATK");
            holder.t3.setText(itemsModelListFiltered.get(position).getDef() + " DEF");
            holder.t4.setText(itemsModelListFiltered.get(position).getType());
            Glide.with(context).load(card.getImage_url()).placeholder(R.drawable.backcard).into(holder.i);

        } catch (Exception e) {
            //Toast.makeText(context.getApplicationContext(), "No Card With This Name!!", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public void setList(List<card> cardList) {
        this.cardList = cardList;
        this.itemsModelListFiltered = cardList;
        notifyDataSetChanged();
    }

    public card getCardList(int position) {
        return cardList.get(position);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();
                if (constraint == null || constraint.length() == 0) {
                    filterResults.count = cardList.size();
                    filterResults.values = cardList;
                } else {
                    List<card> resultsModel = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();

                    for (card itemsModel : cardList) {
                        if (itemsModel.getName().toLowerCase().contains(searchStr)
                                || itemsModel.getType().toLowerCase().contains(searchStr)) {
                            resultsModel.add(itemsModel);
                        }
                        filterResults.count = resultsModel.size();
                        filterResults.values = resultsModel;
                    }
                    notifyDataSetChanged();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                itemsModelListFiltered = (List<card>) results.values;
                notifyDataSetChanged();
            }
        };

    }

    public class cardAdapterHolder extends RecyclerView.ViewHolder {

        TextView t, t2, t3, t4;
        ImageView i;
        LinearLayout screen;
        ImageButton imageButton;

        public cardAdapterHolder(View itemView) {
            super(itemView);
            t = itemView.findViewById(R.id.name);
            t2 = itemView.findViewById(R.id.atk);
            t3 = itemView.findViewById(R.id.def);
            t4 = itemView.findViewById(R.id.type);
            i = itemView.findViewById(R.id.imageView);
            imageButton = itemView.findViewById(R.id.imageButton);
            screen = itemView.findViewById(R.id.screen);
            imageButton.setOnClickListener(v -> {
                float val = new Random().nextInt(5);
                View popup = LayoutInflater.from(context).inflate(R.layout.card_star, null,
                        false);
                final RatingBar bar = popup.findViewById(R.id.ratingE);
                final TextView idA = popup.findViewById(R.id.idAE);
                Log.d("",val+"/5558/"+map.get(positions).intValue());
                bar.setRating(map.get(positions).intValue()==0?val:map.get(positions).floatValue());
                idA.setText(positions+"");
                new AlertDialog.Builder(itemView.getContext())
                        .setTitle("Star : ")
                        .setView(popup)
                        .setPositiveButton("Approve", (dialog1, which) -> {
                            float s = bar.getRating();
                            int ids = Integer.parseInt(idA.getText().toString());
                            map.put(ids,s);
                        })
                        .setNegativeButton("Cancel", null)
                        .create().show();
            });
        }
    }
}