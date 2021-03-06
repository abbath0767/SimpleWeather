package com.luxary_team.simpleweather.ui.fragment.cities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luxary_team.simpleweather.App;
import com.luxary_team.simpleweather.R;
import com.luxary_team.simpleweather.controller.adapters.cities.CitiesAdapter;
import com.luxary_team.simpleweather.presenter.cities.CitiesContract;
import com.luxary_team.simpleweather.presenter.cities.CitiesModule;
import com.luxary_team.simpleweather.presenter.cities.CitiesPresenter;
import com.luxary_team.simpleweather.presenter.cities.DaggerCitiesComponent;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CitiesFragment extends Fragment implements CitiesContract.View {

    @BindView(R.id.recycler_view_cities)
    RecyclerView mRecycler;

    private static final String CITY_LIST = "city_list";
    private List<String> mCitiesList;

    @Inject
    CitiesPresenter mPresenter;

    public static CitiesFragment newInstance() {
        CitiesFragment fragment = new CitiesFragment();

        return fragment;
    }

    private CitiesPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cities_fragment, container, false);

        ButterKnife.bind(this, rootView);

        DaggerCitiesComponent.builder()
                .dataComponent(App.getComponent())
                .citiesModule(new CitiesModule(this))
                .build().inject(this);

        manageMenu();

        getPresenter().loadData();

        return rootView;
    }

    public void showData(final List<String> citiesList) {
        mCitiesList = citiesList;
        initRecycler();
    }

    private void initRecycler() {
        CitiesAdapter adapter = new CitiesAdapter(mCitiesList, getContext());
        mRecycler.setAdapter(adapter);
        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

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
