package com.luxary_team.simpleweather.model.support_obj;


import com.luxary_team.simpleweather.model.open_weather_adapters.forecast_daily_weather.Weathers;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.Locale;

public class WeatherForDay {
    private String day;
    private String icon;
    private String tmp;

    public WeatherForDay(final String day, final String icon, final String tmp) {
        this.day = day;
        this.icon = icon;
        this.tmp = tmp;
    }

    public static WeatherForDay valueOf(final Weathers old) {
        DateTime dateTime = new DateTime(old.getDt() * 1000L, DateTimeZone.getDefault());
        String day = dateTime.dayOfWeek().getAsShortText();
        //todo need update (not need)
        String icon = "nullable icon";
        String temp =  String.format(Locale.getDefault(), "%.0f°C", old.getTemp().getAverage());

        return new WeatherForDay(day, icon, temp);
    }

    public String getDay() {
        return day;
    }

    public String getIcon() {
        return icon;
    }

    public String getTmp() {
        return tmp;
    }
}
