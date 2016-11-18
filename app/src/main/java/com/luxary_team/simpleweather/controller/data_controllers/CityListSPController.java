package com.luxary_team.simpleweather.controller.data_controllers;


import android.content.Context;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;

import static com.luxary_team.simpleweather.App.DEBUG_TAG;

public class CityListSPController {

    private Context mContext;

    private static CityListSPController instatnce;
    private static final String CITY_LIST = "city_list";

    public static CityListSPController getInstatnce(final Context context) {
        if (instatnce == null)
            instatnce = new CityListSPController(context);
        return instatnce;
    }

    private CityListSPController(final Context context) {
        mContext = context;
    }

    public void addCityToSP(final String cityName) {
        Set<String> list = getCitiesFromSP();
        list.add(cityName);
        saveCitiesToSP(list);
        Log.d(DEBUG_TAG, "add city with name = " + cityName);
    }

    private void saveCitiesToSP(final Set<String> list) {
        mContext.getSharedPreferences(CITY_LIST, Context.MODE_PRIVATE).edit().putStringSet(CITY_LIST, list).apply();
    }

    public Set<String> getCitiesFromSP() {
        Set<String> list = new HashSet<>();
        list.add(BindCityManager.getInstance(mContext).getBindCity());
        return mContext.getSharedPreferences(CITY_LIST, Context.MODE_PRIVATE).getStringSet(CITY_LIST, list);
    }

    public void removeCityFromSP(final String cityName) {
        Set<String> list = getCitiesFromSP();
        list.remove(cityName);
        saveCitiesToSP(list);
    }
}
