package com.example.hilt_java.Retrofit;

import com.example.hilt_java.Models.card;
import com.example.hilt_java.Models.data;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static ApiClient Instance;
    private Api apiInstance;

    public ApiClient(){
        String BASE_URL ="https://db.ygoprodeck.com/api/v7/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiInstance = retrofit.create(Api.class);
    }

    public static ApiClient getInstance(){
        if (Instance == null){
            Instance = new ApiClient();
        }
        return Instance;
    }

    public Single<card> getAllData(){
        return apiInstance.getAllData();
    }

}
