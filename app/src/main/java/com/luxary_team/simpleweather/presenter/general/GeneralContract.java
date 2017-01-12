package com.luxary_team.simpleweather.presenter.general;

import com.luxary_team.simpleweather.model.open_weather_adapters.current_weather.CurrentCityWeather;
import com.luxary_team.simpleweather.model.support_obj.WeatherFor3Hour;
import com.luxary_team.simpleweather.model.support_obj.WeatherForDay;

import java.util.List;

public interface GeneralContract {

    interface View {

        void showMessage(final int messageId);

        void setListWeathersForDaysForBottom(final List<WeatherForDay> newList);

        void setListWeathersFor3HourForRiht(List<WeatherFor3Hour> listWeather3Hour);

        void setCurrentWeatherView(final CurrentCityWeather weather);
    }

    interface Presenter {
        View getView();

        void loadDefaultCity(final String cityName);

        void loadForecastDaily();

        void loadForecastHourly();
    }
}
