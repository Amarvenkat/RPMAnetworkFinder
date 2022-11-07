package com.example.rpmanetworksfinder.RetrofitClass;

import com.google.gson.annotations.SerializedName;

public class GetForcast {

    @SerializedName("hourly")
    private HourlyTime hourlyTime;

    public GetForcast(HourlyTime hourlyTime) {
        this.hourlyTime = hourlyTime;
    }

    public HourlyTime getHourlyTime() {
        return hourlyTime;
    }

    public void setHourlyTime(HourlyTime hourlyTime) {
        this.hourlyTime = hourlyTime;
    }
}
