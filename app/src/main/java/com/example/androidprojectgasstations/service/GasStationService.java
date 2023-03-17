package com.example.androidprojectgasstations.service;

import com.example.androidprojectgasstations.model.GasStation;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GasStationService {

    @GET("*")
    Call<GasStation> getGasStations();

}
