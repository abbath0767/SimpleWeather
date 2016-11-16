package com.luxary_team.simpleweather;

import android.app.Application;

import com.google.firebase.crash.FirebaseCrash;

import net.danlew.android.joda.JodaTimeAndroid;

public class App extends Application {

    public final static String DEBUG_TAG = "debug_tag";

    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);
        FirebaseCrash.report(new Exception("My first Android non-fatal error"));
    }
}
