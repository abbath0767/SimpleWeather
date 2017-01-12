package com.luxary_team.simpleweather.controller.data_controllers;


import android.content.Context;

import com.luxary_team.simpleweather.controller.network_threads.ApiBuilder;
import com.luxary_team.simpleweather.model.OpenWeatherApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    @Singleton
    public BindCityManager provideBindCityManager(Context context) {
        return new BindCityManager(context);
    }

    @Provides
    @Singleton
    public CityListSPController provideCityListSPController(Context context) {
        return new CityListSPController(context);
    }

    @Provides
    @Singleton
    public OpenWeatherApi provideOpenWeatherApi() {
        return ApiBuilder.buildService();
    }
}
