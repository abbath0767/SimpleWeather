package com.luxary_team.simpleweather.model.open_weather_adapters.current_weather;

public class Data {
    private float temp;
    private float pressure;

    public float getTemp() {
        return temp;
    }

    public float getPressure() {
        return pressure;
    }

    @Override
    public String toString() {
        return "Data{" +
                "temp=" + temp +
                ", pressure=" + pressure +
                '}';
    }
}
