package com.luxary_team.simpleweather.model;


import com.luxary_team.simpleweather.model.open_weather_adapters.current_weather.CurrentCityWeather;
import com.luxary_team.simpleweather.model.open_weather_adapters.forecast_daily_weather.ForecastDailyWeather;
import com.luxary_team.simpleweather.model.open_weather_adapters.forecast_hourly_weather.ForecastHourlyWeather;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface OpenWeatherApi {

    String ENDPOINT = "http://api.openweathermap.org/";
    String APPID = "95e06110104b73a88ebfde2014e98977";

    //http://api.openweathermap.org/data/2.5/weather?units=metric&lang=ru&appid=95e06110104b73a88ebfde2014e98977&q=Moscow

    @GET("/data/2.5/weather?units=metric&lang=ru&appid=" + APPID)
    Observable<CurrentCityWeather> loadCityRx(@Query("q") String cityName);

    //new
    @GET("/data/2.5/forecast?units=metric&lang=ru&appid=" + APPID)
    Observable<ForecastHourlyWeather> loadForecastRx(@Query("q") String cityName);

    @GET("/data/2.5/forecast/daily?units=metric&cnt=16&lang=ru&appid=" + APPID)
    Observable<ForecastDailyWeather> loadDailyForecastRx(@Query("q") String cityName);

}
