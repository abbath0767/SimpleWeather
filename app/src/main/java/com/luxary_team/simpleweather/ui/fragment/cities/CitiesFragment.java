package com.luxary_team.simpleweather.ui.fragment.cities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luxary_team.simpleweather.R;
import com.luxary_team.simpleweather.presenter.cities.CitiesPresenter;

import butterknife.ButterKnife;


public class CitiesFragment extends Fragment {

    private static CitiesPresenter mPresenter;

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

        return rootView;
    }

    private void manageMenu() {
        setHasOptionsMenu(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
    }
}
