package com.luxary_team.simpleweather.model.open_weather_adapters.forecast_daily_weather;

import java.util.ArrayList;

//todo add more parameters
public class Weathers {
    private Temperatures temp;

    private long dt;

    private ArrayList<Weather> weather = new ArrayList<>();

    public Temperatures getTemp() {
        return temp;
    }

    public Weather getWeather() {
        return weather.get(0);
    }

    public long getDt() {
        return dt;
    }

    @Override
    public String toString() {
        return "Weathers{" +
                "temp=" + temp +
                ", weather=" + weather.get(0) +
                '}';
    }
}
