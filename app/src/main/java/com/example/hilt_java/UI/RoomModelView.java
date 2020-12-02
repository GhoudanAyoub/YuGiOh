package com.example.hilt_java.UI;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hilt_java.Models.card;
import com.example.hilt_java.Presistence.Repository;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RoomModelView extends ViewModel {
/*
    private Repository repository = null;
    public CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<List<card>> listMutableLiveData = new MutableLiveData<List<card>>();

    public LiveData<List<card>> getListMutableLiveData() {
        return listMutableLiveData;
    }

    public void SaveData(Context context, List<card> card){
        repository = new Repository(context);
        repository.saveData(card)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }
    public void getCard(Context context){
        repository = new Repository(context);
        repository.getCard()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<card>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull List<card> cards) {
                        listMutableLiveData.setValue(cards);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }

 */
}
