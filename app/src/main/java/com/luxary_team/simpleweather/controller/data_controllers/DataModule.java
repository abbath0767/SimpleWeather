package com.luxary_team.simpleweather.controller.data_controllers;


import android.content.Context;

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
}
