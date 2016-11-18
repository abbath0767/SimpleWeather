package com.luxary_team.simpleweather.model.support_obj;


import com.luxary_team.simpleweather.model.open_weather_adapters.forecast_hourly_weather.Weather;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.Locale;

import static com.luxary_team.simpleweather.util.StrForm.TMP_DEF;

public class WeatherFor3Hour {

    private String day;
    private String icon;
    private String tmp;

    private WeatherFor3Hour(final String day,final String icon,final String tmp) {
        this.day = day;
        this.icon = icon;
        this.tmp = tmp;
    }

    public static WeatherFor3Hour valueOf(final Weather weather) {

        DateTime dateTime = new DateTime(weather.getDt() * 1000L, DateTimeZone.getDefault());
        //minute always = 00;
        String day = dateTime.getHourOfDay() + ":00";

        //todo need icon manager
        String icon = weather.getWeatherD().get(0).getIcon();
        String tmp = String.format(Locale.getDefault(), TMP_DEF, weather.getMain().getTemp());

        return new WeatherFor3Hour(day, icon, tmp);
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

    @Override
    public String toString() {
        return "WeatherFor3Hour{" +
                "day='" + day + '\'' +
                ", icon='" + icon + '\'' +
                ", tmp='" + tmp + '\'' +
                '}';
    }
}
