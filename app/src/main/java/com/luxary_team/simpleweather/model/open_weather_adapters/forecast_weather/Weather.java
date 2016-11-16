package com.luxary_team.simpleweather.model.open_weather_adapters.forecast_weather;

import java.util.ArrayList;
import java.util.List;

public class Weather {
    private long dt;

    private Main main;

    private List<WeatherD> weather = new ArrayList<>();

    public long getDt() {
        return dt;
    }

    public Main getMain() {
        return main;
    }

    public List<WeatherD> getWeatherD() {
        return weather;
    }
}
