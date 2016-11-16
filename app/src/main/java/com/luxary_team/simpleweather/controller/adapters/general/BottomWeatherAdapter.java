package com.luxary_team.simpleweather.controller.adapters.general;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.luxary_team.simpleweather.R;
import com.luxary_team.simpleweather.model.support_obj.WeatherForDay;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BottomWeatherAdapter extends RecyclerView.Adapter<BottomWeatherAdapter.ViewHolder>{

    private List<WeatherForDay> mWeathersList;
    private Context mContext;

    public BottomWeatherAdapter(final List<WeatherForDay> weathers, final Context context) {
        mWeathersList = weathers;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent,final int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);

        View itemElementBottomView = inflater.inflate(R.layout.list_item_bottom_recycler, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemElementBottomView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position) {
        WeatherForDay weather = mWeathersList.get(position);

        holder.mDayTextView.setText(weather.getDay());
        //todo update iconManager
        //need icon manager, with input -> String, output ->(R.drawable.icon) int
        holder.mIconImageView.setImageResource(R.drawable.testicon1);
        holder.mTempTextView.setText(weather.getTmp());
    }

    @Override
    public int getItemCount() {
        return mWeathersList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.day_text_view_list_item_bottom) TextView mDayTextView;
        @BindView(R.id.icon_image_view_list_item_bottom) AppCompatImageView mIconImageView;
        @BindView(R.id.temperature_text_view_list_item_bottom) TextView mTempTextView;

        public ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
