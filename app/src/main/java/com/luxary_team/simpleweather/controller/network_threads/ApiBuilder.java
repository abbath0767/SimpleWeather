package com.luxary_team.simpleweather.controller.network_threads;

import com.luxary_team.simpleweather.model.OpenWeatherApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBuilder {

    public static OpenWeatherApi buildService() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(OpenWeatherApi.ENDPOINT)
                .build();

        return retrofit.create(OpenWeatherApi.class);
    }
}
