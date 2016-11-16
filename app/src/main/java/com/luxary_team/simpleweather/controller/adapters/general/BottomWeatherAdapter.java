package com.luxary_team.simpleweather.controller.adapters.general;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.luxary_team.simpleweather.R;
import com.luxary_team.simpleweather.model.support_obj.WeatherForDay;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.luxary_team.simpleweather.App.DEBUG_TAG;

public class BottomWeatherAdapter extends RecyclerView.Adapter<BottomWeatherAdapter.ViewHolder> {

    private List<WeatherForDay> mWeathersList;
    private static Context mContext;
    private static boolean isFirstBind = true;

    public BottomWeatherAdapter(final List<WeatherForDay> weathers, final Context context) {
        mWeathersList = weathers;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);

        View itemElementBottomView = inflater.inflate(R.layout.list_item_bottom_recycler, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemElementBottomView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        WeatherForDay weather = mWeathersList.get(position);

        holder.mDayTextView.setText(weather.getDay());
        //todo update iconManager
        //need icon manager, with input -> String, output ->(R.drawable.icon) int
        holder.mIconImageView.setImageResource(R.drawable.testicon1);
        holder.mTempTextView.setText(weather.getTmp());

        if (position == 0) {
            if (isFirstBind) {
                Log.d(DEBUG_TAG, "is first bind and first position");
                holder.setBig();
                isFirstBind = false;
            }
        }
    }

    @Override
    public int getItemCount() {
        return mWeathersList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.day_text_view_list_item_bottom)
        TextView mDayTextView;
        @BindView(R.id.icon_image_view_list_item_bottom)
        AppCompatImageView mIconImageView;
        @BindView(R.id.temperature_text_view_list_item_bottom)
        TextView mTempTextView;
        @BindView(R.id.rounded_linear_layout)
        LinearLayout mRoundLayout;

        public ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setBig() {
            LinearLayout.LayoutParams param = (LinearLayout.LayoutParams) mRoundLayout.getLayoutParams();
            int newHeight = (int) (param.height * 1.2f);
            int newWidth = (int) (param.height * 1.2f);
            param.height = newHeight;
            param.width = newWidth;
            mRoundLayout.setLayoutParams(param);
            mRoundLayout.setBackgroundDrawable(createBigShape(newHeight));
        }

        private Drawable createBigShape(int newHW) {
            GradientDrawable shape = new GradientDrawable();
            shape.setShape(GradientDrawable.RECTANGLE);
            shape.setCornerRadii(new float[]{newHW, newHW, newHW, newHW, newHW, newHW, newHW, newHW});
            shape.setColor(mContext.getResources().getColor(R.color.weryDark));
            shape.setStroke(1, mContext.getResources().getColor(R.color.weryDark));
            return shape;
        }
    }
}
