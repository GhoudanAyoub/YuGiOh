package com.example.hilt_java.Presistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.hilt_java.Models.Fav;
import com.example.hilt_java.Models.card;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface Doa {

    @Insert
    public void saveData(Fav f);

    @Query("Delete from Fav where id = :id")
    public void DeleteData(int id);

    @Query("Select * from Fav")
    public LiveData<List<Fav>> getFav();


}
