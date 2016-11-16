package com.luxary_team.simpleweather.ui.fragment.general;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luxary_team.simpleweather.R;
import com.luxary_team.simpleweather.presenter.Presenter;
import com.luxary_team.simpleweather.presenter.general.GeneralPresenter;

public class GeneralFragment extends Fragment {

    private static Presenter mPresenter;

    public static GeneralFragment newInstance() {
        GeneralFragment fragment = new GeneralFragment();
        mPresenter = GeneralPresenter.getInstance(fragment);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.general_fragment, container, false);



        return rootView;
    }

    private Presenter getPresenter() {
        return mPresenter;
    }
}
