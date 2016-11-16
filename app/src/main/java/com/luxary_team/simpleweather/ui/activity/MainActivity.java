package com.luxary_team.simpleweather.ui.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.luxary_team.simpleweather.R;
import com.luxary_team.simpleweather.ui.fragment.general.GeneralFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setGeneralFragment(GeneralFragment.newInstance());
    }

    public void setGeneralFragment(final GeneralFragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.content, fragment);
        transaction.commit();
    }
}
