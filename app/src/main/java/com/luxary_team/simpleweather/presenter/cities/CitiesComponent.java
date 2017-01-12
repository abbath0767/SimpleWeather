package com.luxary_team.simpleweather.presenter.cities;

import com.luxary_team.simpleweather.controller.DataComponent;
import com.luxary_team.simpleweather.ui.fragment.cities.CitiesFragment;

import dagger.Component;

@CitiesScope
@Component (dependencies = DataComponent.class, modules = CitiesModule.class)
public interface CitiesComponent {
    void inject(CitiesFragment fragment);
}
