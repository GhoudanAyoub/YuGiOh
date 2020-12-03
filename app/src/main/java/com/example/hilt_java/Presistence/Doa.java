package com.example.hilt_java.Presistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.hilt_java.Models.card;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface Doa {

    @Insert
    public void saveData(card c);

    @Query("Delete from card where name = :name")
    public void DeleteData(String name);

    @Query("Select * from card")
    public LiveData<List<card>> getCard();


}
