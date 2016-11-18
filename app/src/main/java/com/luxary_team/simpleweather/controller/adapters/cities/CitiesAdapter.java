package com.luxary_team.simpleweather.controller.adapters.cities;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.luxary_team.simpleweather.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.ViewHolder> {

    private final int STANDART_ITEM = 0;
    private final int BIND_ITEM = 1;

    private List<String> mCities;
    private static Context mContext;
    private static boolean isFirstBind = true;

    public CitiesAdapter(final List<String> list, final Context context) {
        mCities = list;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent,final int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);

        View element = null;

        switch (viewType) {
            case STANDART_ITEM:
                element = inflater.inflate(R.layout.list_item_cities_recycler, parent, false);
                break;
            case BIND_ITEM:
                element = inflater.inflate(R.layout.list_item_cities_recycler, parent, false);
                break;
        }

        return new ViewHolder(element);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position) {
        String city = mCities.get(position);

        int type = getItemViewType(position);

        holder.mCityName.setText(city);
        //todo need make
        holder.mTempTextView.setText("idea?");

        if (type == BIND_ITEM) {
            if (isFirstBind) {
                holder.setNewColor();
                isFirstBind = false;
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? 1 : 0;
    }

    @Override
    public int getItemCount() {
        return mCities.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.city_name_cities)
        TextView mCityName;
        @BindView(R.id.icon_image_view_list_item_bottom)
        AppCompatImageView mIconImageView;
        @BindView(R.id.temperature_text_view_list_item_bottom)
        TextView mTempTextView;
        @BindView(R.id.rounded_linear_layout)
        LinearLayout mRoundLayout;

        ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setNewColor() {
            //todo remake this for Round
            mRoundLayout.setBackgroundColor(mContext.getResources().getColor(R.color.weryDark));
        }
    }
}
