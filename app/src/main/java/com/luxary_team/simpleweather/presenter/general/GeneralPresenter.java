package com.luxary_team.simpleweather.presenter.general;

import android.support.v4.app.Fragment;

import com.luxary_team.simpleweather.presenter.Presenter;
import com.luxary_team.simpleweather.ui.fragment.general.GeneralFragment;

public class GeneralPresenter implements Presenter {

    private static GeneralPresenter instance;

    private Fragment mFragment;

    public static GeneralPresenter getInstance(final GeneralFragment fragment) {
        if (fragment == null)
            instance = new GeneralPresenter(fragment);

        return instance;
    }

    private GeneralPresenter(final GeneralFragment fragment) {
        mFragment = fragment;
    }


    @Override
    public Fragment getView() {
        return mFragment;
    }
}
