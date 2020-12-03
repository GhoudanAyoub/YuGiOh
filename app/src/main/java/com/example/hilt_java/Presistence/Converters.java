package com.example.hilt_java.Presistence;

import androidx.room.TypeConverter;

import com.example.hilt_java.Models.card_images;
import com.example.hilt_java.Models.card_prices;
import com.example.hilt_java.Models.card_sets;
import com.google.gson.Gson;

public class Converters {

    @TypeConverter
    public String FromCard_setsToString(card_sets card_sets){
        return new Gson().toJson(card_sets);
    }

    @TypeConverter
    public card_sets FromStringTocard_sets(String json){
        return new Gson().fromJson(json, card_sets.class);
    }


    @TypeConverter
    public String Fromcard_imagesToString(card_images card_images){
        return new Gson().toJson(card_images);
    }

    @TypeConverter
    public card_images FromStringTocard_images(String json){ return new Gson().fromJson(json, card_images.class); }

    @TypeConverter
    public String Fromcard_pricesToString(card_prices card_prices){
        return new Gson().toJson(card_prices);
    }

    @TypeConverter
    public card_prices FromStringTocard_prices(String json){
        return new Gson().fromJson(json, card_prices.class);
    }
}
