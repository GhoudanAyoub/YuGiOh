package com.example.hilt_java.UI;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hilt_java.Models.card;
import com.example.hilt_java.Models.data;
import com.example.hilt_java.Retrofit.ApiClient;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RetModelView extends ViewModel {
    public CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<card> singleMutableLiveData = new MutableLiveData<card>();

    public LiveData<card> getSingleMutableLiveData() {
        return singleMutableLiveData;
    }

    public void getData(){
        ApiClient.getInstance()
                .getAllData()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<card>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onSuccess(@NonNull card data) {
                        singleMutableLiveData.setValue(data);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                    }
                });
    }
}
