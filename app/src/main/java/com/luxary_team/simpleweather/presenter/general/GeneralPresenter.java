package com.luxary_team.simpleweather.presenter.general;

import com.luxary_team.simpleweather.controller.network_threads.current_weather.CurrentWeatherAsyncLoader;
import com.luxary_team.simpleweather.controller.network_threads.forecast_daily_weather.ForecastDailyAsyncLoader;
import com.luxary_team.simpleweather.model.open_weather_adapters.current_weather.CurrentCityWeather;
import com.luxary_team.simpleweather.model.open_weather_adapters.forecast_daily_weather.ForecastDailyWeather;
import com.luxary_team.simpleweather.model.open_weather_adapters.forecast_daily_weather.Weathers;
import com.luxary_team.simpleweather.model.support_obj.WeatherForDay;
import com.luxary_team.simpleweather.presenter.Presenter;
import com.luxary_team.simpleweather.ui.fragment.general.GeneralFragment;

import java.util.ArrayList;
import java.util.List;

public class GeneralPresenter implements Presenter {

    private static GeneralPresenter instance;

    private GeneralFragment mFragment;
    private String cityName = "Moscow";

    public static GeneralPresenter getInstance(final GeneralFragment fragment) {
        if (fragment == null)
            instance = new GeneralPresenter(fragment);

        return instance;
    }

    private GeneralPresenter(final GeneralFragment fragment) {
        mFragment = fragment;
    }

    public GeneralFragment getView() {
        return mFragment;
    }

    public void loadDefaultCity(String cityName) {
        CurrentWeatherAsyncLoader async = new CurrentWeatherAsyncLoader(this);
        setCityName(cityName);
        async.execute(cityName);
    }

    public void loadForecastDaily() {
        ForecastDailyAsyncLoader async = new ForecastDailyAsyncLoader(this);
        async.execute(cityName);
    }

    public void setForecastDaily(final ForecastDailyWeather forecastDailyWeather) {
        List<WeatherForDay> newList = new ArrayList<>();

        for (Weathers weather: forecastDailyWeather.getWeathers()) {
            newList.add(WeatherForDay.valueOf(weather));
        }

        getView().setListWeathersForDaysForBottom(newList);
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCurrentViewData(CurrentCityWeather weather) {
        getView().setCurrentWeatherView(weather);
    }

    public void saveCityToHistory(ArrayList<Weathers> weather) {}
}
