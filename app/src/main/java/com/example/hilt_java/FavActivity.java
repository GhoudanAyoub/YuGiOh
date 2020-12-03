package com.example.hilt_java;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hilt_java.Adapter.cardAdapter;
import com.example.hilt_java.Models.card;
import com.example.hilt_java.UI.ModelView;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@AndroidEntryPoint
public class FavActivity extends AppCompatActivity {

    public ModelView modelView;
    public RecyclerView RecyclerViewCard;
    private com.example.hilt_java.Adapter.cardAdapter cardAdapter;
    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
        RecyclerViewCard = findViewById(R.id.RecyclerViewFav);
        cardAdapter = new cardAdapter(getApplicationContext());
        RecyclerViewCard.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewCard.setAdapter(cardAdapter);
        Swipe();

        modelView = new ViewModelProvider(this).get(ModelView.class);
        modelView.getCard();
        modelView.getFavList().observe(this,cards -> {
            if (cards==null)
                findViewById(R.id.nodatafound).setVisibility(View.VISIBLE);
            else
                findViewById(R.id.nodatafound).setVisibility(View.GONE);
                cardAdapter.setList(cards);
        });
        findViewById(R.id.homeButton).setOnClickListener(v -> super.onBackPressed());
    }


    private void Swipe(){
        ItemTouchHelper.SimpleCallback touchHelper = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                modelView.DeleteData(cardAdapter.getCardList(viewHolder.getAdapterPosition()).getName());
                cardAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Deleted from Favorites", Toast.LENGTH_SHORT).show();
            }
        };
        new ItemTouchHelper(touchHelper).attachToRecyclerView(RecyclerViewCard);
    }
}