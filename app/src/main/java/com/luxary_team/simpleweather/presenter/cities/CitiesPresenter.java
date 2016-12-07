package com.luxary_team.simpleweather.presenter.cities;

import com.luxary_team.simpleweather.controller.data_controllers.BindCityManager;
import com.luxary_team.simpleweather.controller.data_controllers.CityListSPController;
import com.luxary_team.simpleweather.presenter.Presenter;
import com.luxary_team.simpleweather.ui.fragment.cities.CitiesFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class CitiesPresenter implements Presenter {

    private static CitiesPresenter instance;

    private CitiesFragment mCitiesFragment;
    private Set<String> mCitiesList;

    public static CitiesPresenter getInstance(final CitiesFragment fragment) {
        if (instance == null)
            instance = new CitiesPresenter(fragment);

        return instance;
    }

    private CitiesPresenter(final CitiesFragment fragment) {
        mCitiesFragment = fragment;
    }

    public void loadData() {
        loadCitiesList();
        viewData();
    }

    private void loadCitiesList() {
        mCitiesList = CityListSPController.getInstance(mCitiesFragment.getContext()).getCitiesFromSP();
    }

    private void viewData() {
        getView().showData(mCitiesList);
    }

    public List<String> fromSetToList(final Set<String> citiesList) {
        List<String> list = new ArrayList<>();
        list.add(BindCityManager.getInstance(getView().getContext()).getBindCity());

        for (String city: citiesList) {
            if (!city.equals(list.get(0))) {
                list.add(city);
            }
        }

        return list;
    }

    @Override
    public CitiesFragment getView() {
        return mCitiesFragment;
    }
}
