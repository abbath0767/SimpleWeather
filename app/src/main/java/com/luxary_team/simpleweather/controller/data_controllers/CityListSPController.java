package com.luxary_team.simpleweather.controller.data_controllers;


import android.content.Context;

import com.luxary_team.simpleweather.App;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

public class CityListSPController {

    private Context mContext;

    private static CityListSPController instance;
    private static final String CITY_LIST = "city_list";

    @Inject
    BindCityManager mBindCityManager;

    public static CityListSPController getInstance(final Context context) {
        if (instance == null)
            instance = new CityListSPController(context);
        return instance;
    }

    private CityListSPController(final Context context) {
        mContext = context;
        App.getComponent().inject(this);
    }

    public void addCityToSP(final String cityName) {
        Set<String> list = getCitiesFromSP();
        list.add(cityName);
        saveCitiesToSP(list);
    }

    private void saveCitiesToSP(final Set<String> list) {
        mContext.getSharedPreferences(CITY_LIST, Context.MODE_PRIVATE).edit().putStringSet(CITY_LIST, list).apply();
    }

    public Set<String> getCitiesFromSP() {
        Set<String> list = new HashSet<>();
        list.add(mBindCityManager.getBindCity());
        //todo mock
        list.add("Ivanteevka");
        list.add("Korolev");

        return mContext.getSharedPreferences(CITY_LIST, Context.MODE_PRIVATE).getStringSet(CITY_LIST, list);
    }

    public void removeCityFromSP(final String cityName) {
        Set<String> list = getCitiesFromSP();
        list.remove(cityName);
        saveCitiesToSP(list);
    }
}
