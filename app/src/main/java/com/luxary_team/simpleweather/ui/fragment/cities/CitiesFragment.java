package com.luxary_team.simpleweather.ui.fragment.cities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luxary_team.simpleweather.R;
import com.luxary_team.simpleweather.controller.data_controllers.CityListSPController;
import com.luxary_team.simpleweather.presenter.cities.CitiesPresenter;

import java.util.Set;

import butterknife.ButterKnife;


public class CitiesFragment extends Fragment {

    private static final String CITY_LIST = "city_list";
    private static CitiesPresenter mPresenter;
    private Set<String> mCitiesList;

    public static CitiesFragment newInstance() {
        CitiesFragment fragment = new CitiesFragment();
        mPresenter = CitiesPresenter.getInstance(fragment);

        return fragment;
    }

    public static CitiesPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cities_fragment, container, false);

        ButterKnife.bind(this, rootView);

        manageMenu();

        loadCityList();

        return rootView;
    }

    private void loadCityList() {
        mCitiesList = CityListSPController.getInstatnce(getContext()).getCitiesFromSP();
    }

    //        Log.d(DEBUG_TAG, "sp list size = " + mCitiesList.size());
//        mCitiesList = getCitiesFromSP();
//    private void loadCityList() {
//        for (String city: mCitiesList)
//            Log.d(DEBUG_TAG, "city = " + city);
//    }
//
//    public void addCityToSP(String cityName) {
//        Set<String> list = getCitiesFromSP();
//        list.add(cityName);
//        saveCitiesToSP(list);
//    }
//
//    private void saveCitiesToSP(Set<String> list) {
//        getActivity().getPreferences(Context.MODE_PRIVATE).edit().putStringSet(CITY_LIST, list);
//    }
//
//    private Set<String> getCitiesFromSP() {
//        return getActivity().getPreferences(Context.MODE_PRIVATE).getStringSet(CITY_LIST, null);
//    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.cities_menu, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    private void manageMenu() {
        setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getContext().getString(R.string.back));
    }
}
