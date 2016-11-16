package com.luxary_team.simpleweather.controller.network_threads.forecast_daily_weather;

import android.util.Log;

import com.luxary_team.simpleweather.controller.network_threads.BaseAsyncLoader;
import com.luxary_team.simpleweather.model.open_weather_adapters.forecast_daily_weather.ForecastDailyWeather;
import com.luxary_team.simpleweather.presenter.general.GeneralPresenter;

import java.io.IOException;

import retrofit2.Call;

public class ForecastDailyAsyncLoader extends BaseAsyncLoader<ForecastDailyWeather> {

    private GeneralPresenter mGeneralPresenter;

    public ForecastDailyAsyncLoader(final GeneralPresenter presenter) {
        super();
        mGeneralPresenter = presenter;
    }


    @Override
    protected ForecastDailyWeather doInBackground(final String... params) {

        final String cityName = params[0];

        Call<ForecastDailyWeather> call = getApi().loadDailyForecast(cityName);
        ForecastDailyWeather response = null;

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
    protected void onPostExecute(final ForecastDailyWeather forecastDailyWeather) {
        super.onPostExecute(forecastDailyWeather);
        mGeneralPresenter.setForecastDaily(forecastDailyWeather);
        mGeneralPresenter.saveCityToHistory(forecastDailyWeather.getWeathers());
    }
}
