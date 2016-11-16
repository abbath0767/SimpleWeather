package com.luxary_team.simpleweather.model.open_weather_adapters.current_weather;

public class Weather {
    private int id;
    private String description;
    private String icon;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {return icon;}

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
