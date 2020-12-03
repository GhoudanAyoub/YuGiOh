package com.example.hilt_java.Retrofit;

import com.example.hilt_java.Models.data;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface Api {

    @GET("cardinfo.php")
    Single<data> getAllData();
}
