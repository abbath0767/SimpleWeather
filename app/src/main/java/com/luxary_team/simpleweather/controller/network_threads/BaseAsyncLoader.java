package com.luxary_team.simpleweather.controller.network_threads;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.luxary_team.simpleweather.model.OpenWeatherApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseAsyncLoader<Adapter> extends AsyncTask<String, Void, Adapter> {

    private final Gson gson;
    private final Retrofit retrofit;
    private final OpenWeatherApi openWeatherApi;
    private Adapter result;

    public BaseAsyncLoader() {
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(OpenWeatherApi.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        openWeatherApi = retrofit.create(OpenWeatherApi.class);

        Log.d("TAG", "constructor abstract BaseAsyncLoader");
    }



    public Adapter getResult() {
        return result;
    }

    protected void setResult(final Adapter result) {
        this.result = result;
    }

    public OpenWeatherApi getApi() {
        return openWeatherApi;
    }
}
