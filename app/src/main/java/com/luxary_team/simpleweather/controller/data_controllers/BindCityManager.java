package com.luxary_team.simpleweather.controller.data_controllers;

import android.content.Context;

public class BindCityManager {
    public static final String BIND_CITY = "bind_city";
    private static final String DEFAULT_CITY = "Moscow";
    private static Context mContext;

    private static BindCityManager instatnce;

    private BindCityManager(final Context context) {
        mContext = context;
    }

    public static BindCityManager getInstance(final Context context) {
        if (instatnce == null)
            instatnce = new BindCityManager(context);
        return instatnce;
    }

    public String getBindCity() {
        return mContext.getSharedPreferences(BIND_CITY, Context.MODE_PRIVATE).getString(BIND_CITY, DEFAULT_CITY);
    }

    public void changeBindCity(final String cityName) {
        mContext.getSharedPreferences(BIND_CITY, Context.MODE_PRIVATE).edit().putString(BIND_CITY, cityName).apply();
    }
}
