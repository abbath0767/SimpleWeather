package com.luxary_team.simpleweather.controller.adapters.general;


import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.luxary_team.simpleweather.R;
import com.luxary_team.simpleweather.model.support_obj.WeatherFor3Hour;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.luxary_team.simpleweather.App.DEBUG_TAG;

public class RightWeatherAdapter extends RecyclerView.Adapter<RightWeatherAdapter.ViewHolder> {

    private List<WeatherFor3Hour> mWeatherList;
    private Context mContext;

    public RightWeatherAdapter(final List<WeatherFor3Hour> weatherList) {
        mWeatherList = weatherList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);

        View itemElementRightView = inflater.inflate(R.layout.list_item_right_recycler, parent, false);

        return new ViewHolder(itemElementRightView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WeatherFor3Hour weather = mWeatherList.get(position);

        holder.mIconView.setImageResource(R.drawable.testicon1);
        holder.mTempTextView.setText(weather.getTmp());
        holder.mDayTextView.setText(weather.getDay());
    }

    @Override
    public int getItemCount() {
        return mWeatherList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.icon_image_view_list_item_right)
        AppCompatImageView mIconView;
        @BindView(R.id.temperature_text_view_list_item_right)
        TextView mTempTextView;
        @BindView(R.id.day_text_view_list_item_right)
        TextView mDayTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
