package com.luxary_team.simpleweather.model.support_obj;


import com.luxary_team.simpleweather.model.open_weather_adapters.forecast_daily_weather.Weathers;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.Locale;

import static com.luxary_team.simpleweather.util.StrForm.TMP_DEF;

public class WeatherForDay {
    private String day;
    private String icon;
    private String tmp;

    private WeatherForDay(final String day, final String icon, final String tmp) {
        this.day = day;
        this.icon = icon;
        this.tmp = tmp;
    }

    public static WeatherForDay valueOf(final Weathers old) {
        DateTime dateTime = new DateTime(old.getDt() * 1000L, DateTimeZone.getDefault());
        String day = dateTime.dayOfWeek().getAsShortText();
        //todo need update (not need)
        String icon = "nullable icon";
        String temp =  String.format(Locale.getDefault(), TMP_DEF, old.getTemp().getAverage());

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
