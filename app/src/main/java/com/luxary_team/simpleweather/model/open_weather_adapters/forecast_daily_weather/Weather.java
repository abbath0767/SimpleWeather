package com.luxary_team.simpleweather.model.open_weather_adapters.forecast_daily_weather;

public class Weather {

    private String icon;

    public String getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "icon='" + icon + '\'' +
                '}';
    }
}
