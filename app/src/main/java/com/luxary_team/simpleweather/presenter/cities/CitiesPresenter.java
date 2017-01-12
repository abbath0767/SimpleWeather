package com.luxary_team.simpleweather.presenter.cities;

import com.luxary_team.simpleweather.App;
import com.luxary_team.simpleweather.controller.data_controllers.BindCityManager;
import com.luxary_team.simpleweather.controller.data_controllers.CityListSPController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;


public class CitiesPresenter implements CitiesContract.Presenter {

    private CitiesContract.View mCitiesFragment;
    private Set<String> mCitiesList;

    @Inject
    BindCityManager mBindCityManager;
    @Inject
    CityListSPController mCityListSPController;

    @Inject
    public CitiesPresenter(final CitiesContract.View fragment) {
        mCitiesFragment = fragment;
        App.getComponent().inject(this);
    }

    public void loadData() {
        loadCitiesList();
        viewData();
    }

    private void loadCitiesList() {
        mCitiesList = mCityListSPController.getCitiesFromSP();
    }

    private void viewData() {
        getView().showData(fromSetToList(mCitiesList));
    }

    public List<String> fromSetToList(final Set<String> citiesList) {
        List<String> list = new ArrayList<>();
        list.add(mBindCityManager.getBindCity());

        for (String city: citiesList) {
            if (!city.equals(list.get(0))) {
                list.add(city);
            }
        }

        return list;
    }

    @Override
    public CitiesContract.View getView() {
        return mCitiesFragment;
    }
}
