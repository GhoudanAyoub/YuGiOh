package com.example.hilt_java;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hilt_java.Adapter.cardAdapter;
import com.example.hilt_java.Models.Fav;
import com.example.hilt_java.Models.card;
import com.example.hilt_java.UI.ModelView;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    public ModelView modelView;
    public RecyclerView  RecyclerViewCard;
    private cardAdapter cardAdapter;
    public Fav fav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerViewCard = findViewById(R.id.RecyclerViewCard);
        cardAdapter = new cardAdapter(getApplicationContext());
        RecyclerViewCard.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewCard.setAdapter(cardAdapter);
        cardAdapter.notifyDataSetChanged();
        Swipe();

        modelView = new ViewModelProvider(this).get(ModelView.class);
        modelView.getData();
        modelView.getCardMutableLiveData().observe(this, cards -> cardAdapter.setList(cards));

        findViewById(R.id.favButton).setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),FavActivity.class)));
    }

    private void Swipe(){
        ItemTouchHelper.SimpleCallback touchHelper = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                card c = cardAdapter.getCardList(viewHolder.getAdapterPosition());
                fav = new Fav(c);
                modelView.SaveData(fav);
                cardAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Added To Favorites", Toast.LENGTH_SHORT).show();
            }
        };
        new ItemTouchHelper(touchHelper).attachToRecyclerView(RecyclerViewCard);
    }
}