package com.example.hilt_java.Presistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.hilt_java.Models.Fav;

import java.util.List;

@Dao
public interface Doa {

    @Insert
    void saveData(Fav f);

    @Query("Delete from Fav where id = :id")
    void DeleteData(int id);

    @Query("Select * from Fav")
    LiveData<List<Fav>> getFav();


}
