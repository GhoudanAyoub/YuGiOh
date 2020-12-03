package com.example.hilt_java.Retrofit;

import androidx.lifecycle.LiveData;

import com.example.hilt_java.Models.Fav;
import com.example.hilt_java.Models.card;
import com.example.hilt_java.Models.data;
import com.example.hilt_java.Presistence.Doa;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class Repository {
    private Api api;
    private Doa doa;

    @Inject
    public Repository(Api api, Doa doa) {
        this.api = api;
        this.doa = doa;
    }

    public Single<data> getData(){
        return api.getAllData();
    }


    public void saveData(Fav f){ doa.saveData(f);}
    public void DeleteData(int id){doa.DeleteData(id);}
    public LiveData<List<Fav>> getFav(){return doa.getFav();}
}
