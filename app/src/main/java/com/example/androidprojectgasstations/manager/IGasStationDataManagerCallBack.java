package com.example.androidprojectgasstations.manager;


import com.example.androidprojectgasstations.model.GasStation;

public interface IGasStationDataManagerCallBack {

    void getGasStationsResponseSuccess(GasStation gasStation);
    void getGasStationsResponseError(String message);

}
