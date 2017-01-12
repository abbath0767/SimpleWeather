package com.luxary_team.simpleweather.presenter.cities;

import dagger.Module;
import dagger.Provides;

@Module
public class CitiesModule {

    private final CitiesContract.View mView;

    public CitiesModule(CitiesContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @CitiesScope
    CitiesContract.View provideitiesContractView() {
        return mView;
    }
}
