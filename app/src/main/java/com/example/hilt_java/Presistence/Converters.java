package com.example.hilt_java.Presistence;

import androidx.room.TypeConverter;

import com.example.hilt_java.Models.card;
import com.google.gson.Gson;

public class Converters {

    @TypeConverter
    public String FromCardToString(card card) {
        return new Gson().toJson(card);
    }

    @TypeConverter
    public card FromStringTocard(String json) {
        return new Gson().fromJson(json, card.class);
    }

}
