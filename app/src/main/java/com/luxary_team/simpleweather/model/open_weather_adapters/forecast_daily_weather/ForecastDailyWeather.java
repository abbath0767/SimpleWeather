package com.luxary_team.simpleweather.model.open_weather_adapters.forecast_daily_weather;

import java.util.ArrayList;
import java.util.Arrays;

public class ForecastDailyWeather {

    private ArrayList<Weathers> list = new ArrayList<>();

    public ArrayList<Weathers> getWeathers() {
        return list;
    }

    @Override
    public String toString() {
        return "ForecastDailyWeather{" +
                "list=" + Arrays.toString(list.toArray()) +
                '}';
    }
}
