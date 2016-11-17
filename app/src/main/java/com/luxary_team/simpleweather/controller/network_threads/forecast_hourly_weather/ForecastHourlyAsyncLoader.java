package com.luxary_team.simpleweather.controller.network_threads.forecast_hourly_weather;

import android.util.Log;

import com.luxary_team.simpleweather.controller.network_threads.BaseAsyncLoader;
import com.luxary_team.simpleweather.model.open_weather_adapters.forecast_hourly_weather.ForecastHourlyWeather;
import com.luxary_team.simpleweather.presenter.general.GeneralPresenter;

import java.io.IOException;

import retrofit2.Call;

import static com.luxary_team.simpleweather.App.DEBUG_TAG;


public class ForecastHourlyAsyncLoader extends BaseAsyncLoader<ForecastHourlyWeather> {

    private GeneralPresenter mGeneralPresenter;

    public ForecastHourlyAsyncLoader(final GeneralPresenter generalPresenter) {
        super();
        mGeneralPresenter = generalPresenter;
    }

    @Override
    protected ForecastHourlyWeather doInBackground(final String... params) {

        final String cityName = params[0];

        Call<ForecastHourlyWeather> call = getApi().loadForecats(cityName);
        ForecastHourlyWeather response = null;

        try {
            response = call.execute().body();
        } catch (IOException e) {
            Log.d("TAG", "try/cath doInBack: " + e.toString());
            e.printStackTrace();
        }

        if (response != null)
            setResult(response);
        else
            Log.d("TAG", "response for forecast_hourly_weather = null");

        return getResult();
    }

    @Override
    protected void onPostExecute(final ForecastHourlyWeather forecastHourlyWeather) {
        super.onPostExecute(forecastHourlyWeather);

        mGeneralPresenter.setForecastHourly(forecastHourlyWeather);

        Log.d(DEBUG_TAG, "onPostExecute! getResult = " + getResult().toString());
    }
}
