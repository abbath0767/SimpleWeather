package com.luxary_team.simpleweather.controller;


import com.luxary_team.simpleweather.AppModule;
import com.luxary_team.simpleweather.controller.data_controllers.CityListSPController;
import com.luxary_team.simpleweather.controller.data_controllers.DataModule;
import com.luxary_team.simpleweather.model.OpenWeatherApi;
import com.luxary_team.simpleweather.presenter.cities.CitiesPresenter;
import com.luxary_team.simpleweather.presenter.general.GeneralPresenter;
import com.luxary_team.simpleweather.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component (modules = {DataModule.class, AppModule.class})
@Singleton
public interface DataComponent {

    void inject(CitiesPresenter presenter);

    void inject(CityListSPController controller);

    void inject(MainActivity activity);

    void inject(GeneralPresenter generalPresenter);

    OpenWeatherApi getOpenWeatherApi();
}
