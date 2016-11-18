package com.luxary_team.simpleweather.ui.fragment.general;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.luxary_team.simpleweather.R;
import com.luxary_team.simpleweather.controller.adapters.general.BottomWeatherAdapter;
import com.luxary_team.simpleweather.controller.adapters.general.RightWeatherAdapter;
import com.luxary_team.simpleweather.model.open_weather_adapters.current_weather.CurrentCityWeather;
import com.luxary_team.simpleweather.model.support_obj.WeatherFor3Hour;
import com.luxary_team.simpleweather.model.support_obj.WeatherForDay;
import com.luxary_team.simpleweather.presenter.general.GeneralPresenter;
import com.luxary_team.simpleweather.ui.view.CurrentWeatherView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GeneralFragment extends Fragment {

    private static GeneralPresenter mPresenter;

    private List<WeatherForDay> mWeatherForDays;
    private List<WeatherFor3Hour> mWeatherForHour;

    @BindView(R.id.current_weather_view)
    CurrentWeatherView mCurrentWeatherView;
    @BindView(R.id.recycler_view_general_fragment)
    RecyclerView mRecyclerView;
    @BindView(R.id.recycler_view_general_fragment_right)
    RecyclerView mRecyclerViewRight;

    public static GeneralFragment newInstance() {
        GeneralFragment fragment = new GeneralFragment();
        mPresenter = GeneralPresenter.getInstance(fragment);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.general_fragment, container, false);

        ButterKnife.bind(this, rootView);

        manageMenu();

        String cityName = "Moscow";

        loadData(cityName);

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_general, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void manageMenu() {
        setHasOptionsMenu(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(false);
    }

    private GeneralPresenter getPresenter() {
        return mPresenter;
    }

    private void loadData(String cityName) {
        if (!hasConnection(getContext())) {
            showMessage(R.string.internet_error);
        } else {
            getPresenter().loadDefaultCity(cityName);
            getPresenter().loadForecastDaily();
            getPresenter().loadForecastHourly();
        }
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

        if (weather != null) {
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
        } else {
            Toast.makeText(getContext(), getContext().getText(R.string.internet_error), Toast.LENGTH_LONG).show();
        }
    }

    public void setListWeathersForDaysForBottom(final List<WeatherForDay> newList) {
        mWeatherForDays = newList;
        initBottomRecyclerView();
    }

    public void setListWeathersFor3HourForRiht(List<WeatherFor3Hour> listWeather3Hour) {
        mWeatherForHour = listWeather3Hour;
        initRightRecyclerView();
    }

    private void initBottomRecyclerView() {
        //mb delete last constructor param - context?
        BottomWeatherAdapter adapter = new BottomWeatherAdapter(mWeatherForDays, getContext());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    private void initRightRecyclerView() {
        RightWeatherAdapter adapter = new RightWeatherAdapter(mWeatherForHour);
        mRecyclerViewRight.setAdapter(adapter);
        mRecyclerViewRight.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
