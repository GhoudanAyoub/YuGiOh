package com.example.hilt_java.Retrofit;

import com.example.hilt_java.Models.card;
import com.example.hilt_java.Models.data;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @GET("cardinfo.php")
    Single<card> getAllData();
}
