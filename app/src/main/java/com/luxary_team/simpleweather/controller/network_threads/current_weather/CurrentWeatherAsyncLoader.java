package com.luxary_team.simpleweather.controller.network_threads.current_weather;

import android.util.Log;

import com.luxary_team.simpleweather.controller.network_threads.BaseAsyncLoader;
import com.luxary_team.simpleweather.model.open_weather_adapters.current_weather.CurrentCityWeather;
import com.luxary_team.simpleweather.presenter.general.GeneralPresenter;

import java.io.IOException;

import retrofit2.Call;

public class CurrentWeatherAsyncLoader extends BaseAsyncLoader<CurrentCityWeather> {

    private GeneralPresenter mGeneralPresenter;

    public CurrentWeatherAsyncLoader(final GeneralPresenter presenter) {
        super();
        mGeneralPresenter = presenter;
    }

    @Override
    protected CurrentCityWeather doInBackground(final String... params) {
        //logic
        String cityName = params[0];

        Call<CurrentCityWeather> call = getApi().loadCity(cityName);
        CurrentCityWeather response = null;
        try {
            response = call.execute().body();
        } catch (IOException e) {
            Log.d("TAG", "try/cath doInBack: " + e.toString());
            e.printStackTrace();
        }

        if (response != null)
            setResult(response);
        else
            Log.d("TAG", "response = null");

        return getResult();
    }

    @Override
    protected void onPostExecute(final CurrentCityWeather currentCityWeather) {
        super.onPostExecute(currentCityWeather);
        mGeneralPresenter.setCurrentViewData(currentCityWeather);
    }
}
