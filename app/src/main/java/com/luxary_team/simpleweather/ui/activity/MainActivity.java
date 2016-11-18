package com.luxary_team.simpleweather.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.luxary_team.simpleweather.R;
import com.luxary_team.simpleweather.ui.fragment.cities.CitiesFragment;
import com.luxary_team.simpleweather.ui.fragment.general.GeneralFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = CitiesFragment.class.getName();

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

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.open_cities_menu:
                loadFragment(CitiesFragment.newInstance());
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
            return;
        }

        super.onBackPressed();
    }

    private void loadFragment(final Fragment fragment) {
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.content, fragment);
        transaction.addToBackStack(fragment.getClass().getName());
        transaction.commit();
    }
}
