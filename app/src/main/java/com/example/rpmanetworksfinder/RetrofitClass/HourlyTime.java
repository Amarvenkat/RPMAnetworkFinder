package com.example.rpmanetworksfinder.RetrofitClass;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HourlyTime {

    @SerializedName("time")
    private List<String> hourlyTimeArrayList;
    @SerializedName("temperature_2m")
    private List<String> temperature;

    public HourlyTime(List<String> hourlyTimeArrayList, List<String> temperature) {
        this.hourlyTimeArrayList = hourlyTimeArrayList;
        this.temperature = temperature;
    }

    public List<String> getHourlyTimeArrayList() {
        return hourlyTimeArrayList;
    }

    public void setHourlyTimeArrayList(List<String> hourlyTimeArrayList) {
        this.hourlyTimeArrayList = hourlyTimeArrayList;
    }

    public List<String> getTemperature() {
        return temperature;
    }

    public void setTemperature(List<String> temperature) {
        this.temperature = temperature;
    }
}
