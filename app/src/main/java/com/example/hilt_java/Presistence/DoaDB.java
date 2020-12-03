package com.example.hilt_java.Presistence;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.hilt_java.Models.Fav;
import com.example.hilt_java.Models.card;

@Database(entities = {Fav.class},version = 5 )
@TypeConverters(Converters.class)
public abstract class DoaDB extends RoomDatabase {
    public abstract Doa doa();
}
