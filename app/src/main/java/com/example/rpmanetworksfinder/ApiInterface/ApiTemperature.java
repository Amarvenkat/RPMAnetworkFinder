package com.example.rpmanetworksfinder.ApiInterface;

import com.example.rpmanetworksfinder.RetrofitClass.GetForcast;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiTemperature {

    @GET("forecast?latitude=25.34&longitude=55.39&hourly=temperature_2m")
    Call<GetForcast> getReport();
}
