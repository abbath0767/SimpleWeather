package com.luxary_team.simpleweather.presenter.cities;

import com.luxary_team.simpleweather.presenter.Presenter;
import com.luxary_team.simpleweather.ui.fragment.cities.CitiesFragment;


public class CitiesPresenter implements Presenter {

    private static CitiesPresenter instance;

    private CitiesFragment mCitiesFragment;

    public static CitiesPresenter getInstance(CitiesFragment fragment) {
        if (instance == null)
            instance = new CitiesPresenter(fragment);

        return instance;
    }

    private CitiesPresenter(CitiesFragment fragment) {
        mCitiesFragment = fragment;
    }

    @Override
    public CitiesFragment getView() {
        return mCitiesFragment;
    }
}
