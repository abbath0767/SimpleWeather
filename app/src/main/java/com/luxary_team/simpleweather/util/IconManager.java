package com.luxary_team.simpleweather.util;

import android.content.Context;
import android.util.Log;

import com.luxary_team.simpleweather.R;


public class IconManager {
    private static IconManager instance;
    private Context mContext;

    public static IconManager getInstance(final Context context) {
        if (instance == null) {
            instance = new IconManager(context);
        }
        return instance;
    }

    private IconManager(Context context) {
        mContext = context;
    }

    public int getIcon(final String iconName) {
        int resourceId;

        if (iconName.length() < 2) {
            //todo make ErrorHandler
            Log.d("TAG", "bad icon name (length < 2)");
            return R.drawable.testicon1;
        }

        int number = Integer.valueOf(iconName.substring(0, 2));
        boolean isDay = iconName.contains("d");


        //...
        //resourceId = ... id;

        resourceId = R.drawable.testicon1;

        //...

        return resourceId;
    }
}
