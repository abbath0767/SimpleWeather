package com.luxary_team.simpleweather;

import android.app.Application;

import com.luxary_team.simpleweather.controller.DataComponent;
import com.luxary_team.simpleweather.controller.DaggerAppComponent;

import net.danlew.android.joda.JodaTimeAndroid;

public class App extends Application {

    public final static String DEBUG_TAG = "debug_tag";

    private static DataComponent mComponent;
    public static DataComponent getComponent() {
        return mComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);
        mComponent = buildComponent();
    }

    private DataComponent buildComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
