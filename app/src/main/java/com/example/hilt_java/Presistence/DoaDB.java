package com.example.hilt_java.Presistence;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.hilt_java.Models.card;

//@Database(entities = {card.class},version = 1)
public abstract class DoaDB extends RoomDatabase {
/*
    public static DoaDB doaDBInstance;

    public static synchronized DoaDB getInstance(Context context){
        if (doaDBInstance == null){
            doaDBInstance = Room.databaseBuilder(
                    context.getApplicationContext()
                    ,DoaDB.class
                    ,"DoaDB")
                    .build();
        }
        return doaDBInstance;
    }

    public abstract Doa doa();

 */
}
