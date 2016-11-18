package com.luxary_team.simpleweather.model.support_obj;

import java.util.Comparator;


public class WeatherFor3HourComparator implements Comparator<WeatherFor3Hour> {
    @Override
    public int compare(WeatherFor3Hour o1, WeatherFor3Hour o2) {
        Integer first = Integer.valueOf(o1.getDay().split(":")[0]);
        Integer second = Integer.valueOf(o2.getDay().split(":")[0]);
        return first.compareTo(second);
    }
}
