package com.example.hilt_java.UI;

import android.annotation.SuppressLint;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hilt_java.Models.card;
import com.example.hilt_java.Retrofit.Repository;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ModelView extends ViewModel {
    private Repository repository;

    private LiveData<List<card>> FavList = null;
    public LiveData<List<card>> getFavList() { return FavList; }

    private MutableLiveData<List<card>> cardMutableLiveData = new MutableLiveData<List<card>>();
    public LiveData<List<card>> getCardMutableLiveData() {
        if (cardMutableLiveData ==null)
            cardMutableLiveData = new MutableLiveData<>();
        return cardMutableLiveData;
    }

    @ViewModelInject
    public ModelView(Repository repositoryRet) {
        this.repository = repositoryRet;
    }

    @SuppressLint("CheckResult")
    public void getData(){
        repository.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> cardMutableLiveData.setValue(data.getCards()),
                        Throwable::printStackTrace);
    }

    public void getCard(){ FavList = repository.getCard(); }
    public void SaveData( card card){ repository.saveData(card); }
    public void DeleteData(String name){repository.DeleteData(name);}
}
