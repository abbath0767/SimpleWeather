package com.luxary_team.simpleweather.presenter.general;

import com.luxary_team.simpleweather.controller.network_threads.current_weather.CurrentWeatherAsyncLoader;
import com.luxary_team.simpleweather.controller.network_threads.forecast_daily_weather.ForecastDailyAsyncLoader;
import com.luxary_team.simpleweather.controller.network_threads.forecast_hourly_weather.ForecastHourlyAsyncLoader;
import com.luxary_team.simpleweather.model.open_weather_adapters.current_weather.CurrentCityWeather;
import com.luxary_team.simpleweather.model.open_weather_adapters.forecast_daily_weather.ForecastDailyWeather;
import com.luxary_team.simpleweather.model.open_weather_adapters.forecast_daily_weather.Weathers;
import com.luxary_team.simpleweather.model.open_weather_adapters.forecast_hourly_weather.ForecastHourlyWeather;
import com.luxary_team.simpleweather.model.support_obj.WeatherFor3Hour;
import com.luxary_team.simpleweather.model.support_obj.WeatherFor3HourComparator;
import com.luxary_team.simpleweather.model.support_obj.WeatherForDay;
import com.luxary_team.simpleweather.presenter.Presenter;
import com.luxary_team.simpleweather.ui.fragment.general.GeneralFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneralPresenter implements Presenter {

    private static GeneralPresenter instance;

    private GeneralFragment mFragment;
    private String cityName = "Moscow";

    public static GeneralPresenter getInstance(final GeneralFragment fragment) {
        if (instance == null)
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

    public void loadForecastHourly() {
        ForecastHourlyAsyncLoader async = new ForecastHourlyAsyncLoader(this);
        async.execute(cityName);
    }

    public void setForecastDaily(final ForecastDailyWeather forecastDailyWeather) {
        List<WeatherForDay> newList = new ArrayList<>();

        for (Weathers weather: forecastDailyWeather.getWeathers()) {
            newList.add(WeatherForDay.valueOf(weather));
        }

        getView().setListWeathersForDaysForBottom(newList);
    }

    public void setForecastHourly(final ForecastHourlyWeather forecastHourly) {
        List<WeatherFor3Hour> list = getListFromAdapter(forecastHourly);

        sortListWeathers(list);

        getView().setListWeathersFor3HourForRiht(list);
    }

    private List<WeatherFor3Hour> getListFromAdapter(final ForecastHourlyWeather forecastHourly) {
        List<WeatherFor3Hour> list = new ArrayList<>();
        //i = 8. Design need 8 first hourly items
        for (int i = 0; i < 8; i++) {
            list.add(WeatherFor3Hour.valueOf(forecastHourly.getList().get(i)));
        }
        return list;
    }

    private void sortListWeathers(List<WeatherFor3Hour> list) {
        Collections.sort(list, new WeatherFor3HourComparator());
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
}
