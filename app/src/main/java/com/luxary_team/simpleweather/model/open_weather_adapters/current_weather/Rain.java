package com.luxary_team.simpleweather.model.open_weather_adapters.current_weather;

import com.google.gson.annotations.SerializedName;

public class Rain {

    @SerializedName("3h")
    private float rain;

    public float getRainValue() {
        return rain;
    }
}
