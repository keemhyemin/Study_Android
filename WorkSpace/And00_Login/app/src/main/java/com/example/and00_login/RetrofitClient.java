package com.example.and00_login;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {

    public Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.31:8080/middle/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        return retrofit;
    }
}
