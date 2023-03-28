package com.example.androidprojectgasstations.service;

import com.example.androidprojectgasstations.model.GasStation;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GasStationService {

    @GET("?dataset=prix-carburants-fichier-instantane-test-ods-copie&rows=40")
    Call<GasStation> getGasStations();

}
