package com.luxary_team.simpleweather.ui.view;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.luxary_team.simpleweather.R;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrentWeatherView extends LinearLayout {

    @BindView(R.id.city_text_view_current_weather_view)
    TextView mCityNameTextView;
    @BindView(R.id.date_text_view_current_weather_view)
    TextView mDateTextView;
    @BindView(R.id.temperature_text_view_current_weather_view)
    TextView mTemperatureTextView;
    @BindView(R.id.description_text_view_current_weather_view)
    TextView mDescriptionTextView;
    @BindView(R.id.rain_text_view_current_weather_view)
    TextView mRainTextView;
    @BindView(R.id.wind_text_view_current_weather_view)
    TextView mWindTextView;
    @BindView(R.id.icon_image_view_current_weather_view)
    AppCompatImageView mIconImageView;

    public CurrentWeatherView(final Context context) {
        super(context);
        init(context);
    }

    public CurrentWeatherView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(final Context context) {
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.view_current_weather, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void setCityName(final String cityName) {
        mCityNameTextView.setText(cityName);
    }

    public void setDateTextView(final long dateLong) {
        DateTime dateTime = new DateTime(dateLong, DateTimeZone.getDefault());
        DateTimeFormatter dtf = DateTimeFormat.forPattern("EE, dd MMMM yyyy, HH:mm");

        mDateTextView.setText(dtf.print(dateTime));
    }

    public void setWeatherIcon(final String value) {
        //todo need make iconManager
//        int iconRValue;
//        switch (Integer.valueOf(value)) {
//            case 1:
//                iconRValue = R.drawable.testicon;
//                break;
//            case 2 ...
//        }
//        mIconImageView.setImageDrawable(getResources().getDrawable(result));
    }

    public void setTemperature(final float temperature) {
        String tmpStr = String.format(Locale.getDefault(), "%.0f°C", temperature);
        mTemperatureTextView.setText(tmpStr);
    }

    public void setDescription(String description) {
        String result = description.substring(0, 1).toUpperCase() + description.substring(1);
        mDescriptionTextView.setText(result);
    }

    public void setRain(final float mm) {
        String value;

        if (mm == 0)
            value = getResources().getString(R.string.zero_rain);
        else
            value = String.valueOf(mm);

        String resultText = getResources().getString(R.string.rain_info) + value;
        mRainTextView.setText(resultText);
    }

    public void setWind(final float ms) {
        String resultText = String.format(getResources().getString(R.string.wind_info), String.valueOf(ms));
        mWindTextView.setText(resultText);
    }
}
