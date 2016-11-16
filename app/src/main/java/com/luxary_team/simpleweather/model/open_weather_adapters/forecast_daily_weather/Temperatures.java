package com.luxary_team.simpleweather.model.open_weather_adapters.forecast_daily_weather;

public class Temperatures {

    private float day;
    private float min;
    private float max;
    private float night;
    private float eve;
    private float morn;

    public float getDay() {
        return day;
    }

    public float getMin() {
        return min;
    }

    public float getMax() {
        return max;
    }

    public float getNight() {
        return night;
    }

    public float getEve() {
        return eve;
    }

    public float getMorn() {
        return morn;
    }

    public float getAverage() {
        return (day + night + eve + morn) / 4.0f;
    }

    @Override
    public String toString() {
        return "Temperatures{" +
                "day=" + day +
                ", min=" + min +
                ", max=" + max +
                ", night=" + night +
                ", eve=" + eve +
                ", morn=" + morn +
                '}';
    }
}
