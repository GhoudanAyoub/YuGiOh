package com.example.hilt_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hilt_java.Models.card;

public class fullinfo extends AppCompatActivity {
    TextView t, t2, t3, t4,desc,amaz,ebay,cardmarket,tcgplayer;
    ImageView i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullinfo);
        view();
        card card = getIntent().getParcelableExtra("card");
        String url = getIntent().getStringExtra("image");
        t.setText(card.getName());
        t2.setText(card.getAtk() + " ATK");
        t3.setText(card.getDef() + " DEF");
        t4.setText(card.getType());
        desc.setText(card.getDesc());
        amaz.setText(getIntent().getStringExtra("amaz")+"$");
        ebay.setText(getIntent().getStringExtra("ebay")+"$");
        cardmarket.setText(getIntent().getStringExtra("cardmarket")+"$");
        tcgplayer.setText(getIntent().getStringExtra("tcgplayer")+"$");
        Glide.with(getApplicationContext())
                .load(url)
                .placeholder(R.drawable.backcard).into(i);

    }

    public void view(){
        t = findViewById(R.id.name2);
        t2 = findViewById(R.id.atk2);
        t3 = findViewById(R.id.def2);
        t4 = findViewById(R.id.type2);
        desc = findViewById(R.id.desc);
        amaz = findViewById(R.id.amaz);
        ebay = findViewById(R.id.ebay);
        cardmarket = findViewById(R.id.cardmarket);
        tcgplayer = findViewById(R.id.tcgplayer);
        i = findViewById(R.id.imageView2);
    }
}