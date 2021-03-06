package com.luxary_team.simpleweather.controller.data_controllers;

import android.content.Context;

public class BindCityManager {
    public static final String BIND_CITY = "bind_city";
    private static final String DEFAULT_CITY = "Moscow";
    private static Context mContext;

    public BindCityManager(final Context context) {
        mContext = context;
    }

    public String getBindCity() {
        return mContext.getSharedPreferences(BIND_CITY, Context.MODE_PRIVATE).getString(BIND_CITY, DEFAULT_CITY);
    }

    //пока не используем но будем скоро
    public void changeBindCity(final String cityName) {
        mContext.getSharedPreferences(BIND_CITY, Context.MODE_PRIVATE).edit().putString(BIND_CITY, cityName).apply();
    }
}
