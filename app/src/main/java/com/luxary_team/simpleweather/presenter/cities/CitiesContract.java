package com.luxary_team.simpleweather.presenter.cities;


import java.util.List;

public interface CitiesContract {
    interface View {

        void showData(final List<String> citiesList);
    }

    interface Presenter {

        View getView();

        void loadData();
    }
}
