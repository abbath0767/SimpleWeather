package com.luxary_team.simpleweather.presenter.general;


import dagger.Module;
import dagger.Provides;

@Module
public class GeneralModule {

    private final GeneralContract.View mView;

    public GeneralModule(GeneralContract.View view) {
        mView = view;
    }

    @Provides
    @GeneralScope
    GeneralContract.View provideGeneralView() {
        return mView;
    }
}
