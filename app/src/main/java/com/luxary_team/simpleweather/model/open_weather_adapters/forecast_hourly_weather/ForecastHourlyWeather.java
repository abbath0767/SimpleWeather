package com.luxary_team.simpleweather.model.open_weather_adapters.forecast_hourly_weather;

import java.util.ArrayList;
import java.util.List;

public class ForecastHourlyWeather {

    private List<Weather> list = new ArrayList<>();

    public List<Weather> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "ForecastHourlyWeather{" +
                "list size =" + list.size() +
                '}';
    }
}
