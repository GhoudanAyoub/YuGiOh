package com.example.hilt_java;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hilt_java.Adapter.FavAdapter;
import com.example.hilt_java.UI.ModelView;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FavActivity extends AppCompatActivity {

    public ModelView modelView;
    public RecyclerView RecyclerViewCard;
    private FavAdapter favAdapter;
    private TextView textView;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
        RecyclerViewCard = findViewById(R.id.RecyclerViewFav);
        textView = findViewById(R.id.textView5);
        favAdapter = new FavAdapter(getApplicationContext());
        RecyclerViewCard.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewCard.setAdapter(favAdapter);
        Swipe();

        modelView = new ViewModelProvider(this).get(ModelView.class);
        modelView.getFav();
        modelView.getFavList().observe(this, favs -> {
            if (favs.size() == 0) {
                findViewById(R.id.nodatafound).setVisibility(View.VISIBLE);
                textView.setText("Your Deck is Empty");
                favAdapter.notifyDataSetChanged();
            } else {
                findViewById(R.id.nodatafound).setVisibility(View.GONE);
                textView.setText(favs.size() + " Cards in Your Deck");
                favAdapter.setList(favs);
            }
        });
        findViewById(R.id.homeButton).setOnClickListener(v -> super.onBackPressed());
    }


    private void Swipe() {
        ItemTouchHelper.SimpleCallback touchHelper = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                modelView.DeleteData(favAdapter.getFavList(viewHolder.getAdapterPosition()).getId());
                favAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Deleted from Favorites", Toast.LENGTH_SHORT).show();
            }
        };
        new ItemTouchHelper(touchHelper).attachToRecyclerView(RecyclerViewCard);
    }
}