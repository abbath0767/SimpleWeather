package com.luxary_team.simpleweather.model.open_weather_adapters.current_weather;

import java.util.ArrayList;
import java.util.List;

public class CurrentCityWeather {

    private List<Weather> weather = new ArrayList<>();
    private Data main;
    private Rain rain = null;
    private Wind wind;
    private long dt;

    public Weather getWeather() {
        return weather.get(0);
    }

    public Data getMain() {
        return main;
    }

    public Rain getRain() {
        return rain;
    }

    public Wind getWind() {
        return wind;
    }

    public long getDt() {
        return dt;
    }

    @Override
    public String toString() {
        return "CurrentCityWeather{" +
                "weather=" + weather.get(0) +
                ", main=" + main +
                '}';
    }
}
