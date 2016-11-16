package com.luxary_team.simpleweather.ui.fragment.general;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.luxary_team.simpleweather.R;
import com.luxary_team.simpleweather.controller.adapters.general.BottomWeatherAdapter;
import com.luxary_team.simpleweather.model.open_weather_adapters.current_weather.CurrentCityWeather;
import com.luxary_team.simpleweather.model.support_obj.WeatherForDay;
import com.luxary_team.simpleweather.presenter.general.GeneralPresenter;
import com.luxary_team.simpleweather.ui.view.CurrentWeatherView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GeneralFragment extends Fragment {

    private static GeneralPresenter mPresenter;

    private List<WeatherForDay> mWeatherForDays;

    @BindView(R.id.current_weather_view)
    CurrentWeatherView mCurrentWeatherView;
    @BindView(R.id.recycler_view_general_fragment)
    RecyclerView mRecyclerView;

    public static GeneralFragment newInstance() {
        GeneralFragment fragment = new GeneralFragment();
        mPresenter = GeneralPresenter.getInstance(fragment);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.general_fragment, container, false);

        ButterKnife.bind(this, rootView);

        String cityName = "Moscow";
        if(!hasConnection(getContext())) {
            showMessage(R.string.internet_error);
        } else {
            getPresenter().loadDefaultCity(cityName);
            getPresenter().loadForecastDaily();
        }

        return rootView;
    }

    private GeneralPresenter getPresenter() {
        return mPresenter;
    }

    public static boolean hasConnection(final Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiInfo != null && wifiInfo.isConnected()) {
            return true;
        }
        wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifiInfo != null && wifiInfo.isConnected()) {
            return true;
        }
        wifiInfo = cm.getActiveNetworkInfo();
        if (wifiInfo != null && wifiInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public void showMessage(final int messageId) {
        Toast.makeText(getActivity(), messageId, Toast.LENGTH_SHORT).show();
    }

    public void setCurrentWeatherView(final CurrentCityWeather weather) {
        //setCityName and DataTextView
        mCurrentWeatherView.setCityName(getPresenter().getCityName());

        if (weather != null)
            mCurrentWeatherView.setDateTextView(weather.getDt() * 1000L);

        //setIcon not works!
        mCurrentWeatherView.setWeatherIcon(weather.getWeather().getIcon());

        //setTemperature
        mCurrentWeatherView.setTemperature(weather.getMain().getTemp());

        //setDecr
        mCurrentWeatherView.setDescription(weather.getWeather().getDescription());

        //setRain
        if (weather.getRain() != null)
            mCurrentWeatherView.setRain(weather.getRain().getRainValue());

        //setWind
        mCurrentWeatherView.setWind(weather.getWind().getWindMS());
    }

    public void setListWeathersForDaysForBottom(final List<WeatherForDay> newList) {
        mWeatherForDays = newList;
        initBottomRecyclerView();
    }

    private void initBottomRecyclerView() {
        BottomWeatherAdapter adapter = new BottomWeatherAdapter(mWeatherForDays, getContext());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }
}
