package com.example.andy.mvvmtest;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface LoginService {
    @FormUrlEncoded
    @POST("users/{username}/repos")
    Observable<List<ListBean>> dologin(@Body User username);


    class Factory {
        public static LoginService create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.0.1:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(LoginService.class);
        }
    }
}
