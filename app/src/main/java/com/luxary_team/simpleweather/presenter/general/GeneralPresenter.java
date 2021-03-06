package com.luxary_team.simpleweather.presenter.general;

import android.util.Log;

import com.luxary_team.simpleweather.controller.network_threads.NetworkRequest;
import com.luxary_team.simpleweather.model.OpenWeatherApi;
import com.luxary_team.simpleweather.model.open_weather_adapters.current_weather.CurrentCityWeather;
import com.luxary_team.simpleweather.model.open_weather_adapters.forecast_daily_weather.ForecastDailyWeather;
import com.luxary_team.simpleweather.model.open_weather_adapters.forecast_daily_weather.Weathers;
import com.luxary_team.simpleweather.model.open_weather_adapters.forecast_hourly_weather.ForecastHourlyWeather;
import com.luxary_team.simpleweather.model.support_obj.WeatherFor3Hour;
import com.luxary_team.simpleweather.model.support_obj.WeatherFor3HourComparator;
import com.luxary_team.simpleweather.model.support_obj.WeatherForDay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

import static com.luxary_team.simpleweather.App.DEBUG_TAG;

public class GeneralPresenter implements GeneralContract.Presenter {

    private String cityName = "Moscow";
    private CompositeSubscription mCompositeSubscription;

    private GeneralContract.View mFragment;
    private OpenWeatherApi weatherApi;

    @Inject
    public GeneralPresenter(GeneralContract.View fragment, OpenWeatherApi weatherApi) {
        Log.d(DEBUG_TAG, "GeneralPresenter Constructor");
//        App.getComponent().inject(this);
        mFragment = fragment;
        this.weatherApi = weatherApi;
        mCompositeSubscription = new CompositeSubscription();
    }

    public GeneralContract.View getView() {
        return mFragment;
    }

    public void loadData(String cityName) {
        loadDefaultCity(cityName);
        loadForecastDaily();
        loadForecastHourly();
    }

    public void loadDefaultCity(String cityName) {
        setCityName(cityName);

        Subscription getCurrentWeatherRequest =
                NetworkRequest.asyncRequest(weatherApi.loadCityRx(cityName),
                        data -> {
                            setCurrentViewData(data);
                            Log.d(DEBUG_TAG, "descr: " + data.getWeather().getDescription());
                        },
                        error -> Log.d(DEBUG_TAG, "Error: " + error));

        mCompositeSubscription.add(getCurrentWeatherRequest);
    }

    public void loadForecastDaily() {
        Subscription getForecastDaily =
                NetworkRequest.asyncRequest(weatherApi.loadDailyForecastRx(cityName),
                        data -> {
                            setForecastDaily(data);
                        },
                        error -> Log.d(DEBUG_TAG, "Error: " + error));

        mCompositeSubscription.add(getForecastDaily);
    }

    public void loadForecastHourly() {
        Subscription getForecastHourly =
                NetworkRequest.asyncRequest(weatherApi.loadForecastRx(cityName),
                        data -> setForecastHourly(data),
                        error -> Log.d(DEBUG_TAG, "Error: " + error));

        mCompositeSubscription.add(getForecastHourly);
    }

    public void setForecastDaily(final ForecastDailyWeather forecastDailyWeather) {
        List<WeatherForDay> newList = new ArrayList<>();

        for (Weathers weather : forecastDailyWeather.getWeathers()) {
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
        //i = 8. Design need 8 first hourly items from 16 or 32
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

    public void unsubscribe() {
        Log.d(DEBUG_TAG, "clear subscribers");
        mCompositeSubscription.unsubscribe();
        mCompositeSubscription.clear();
    }
}
