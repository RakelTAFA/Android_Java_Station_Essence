package com.example.androidprojectgasstations.manager;

import com.example.androidprojectgasstations.model.GasStation;
import com.example.androidprojectgasstations.model.GasStationFields;

import java.util.ArrayList;

public class CacheManager {

    private static CacheManager instance = null;
    private ArrayList<GasStationFields> listGasStations = new ArrayList<>();
    GasStation gasStation;
    private CacheManager()
    {
        //apiManager = ApiManager.getInstance();
    }

    public GasStation getGasStation() {
        return gasStation;
    }

    public void setGasStation(GasStation gasStation) {
        this.gasStation = gasStation;
    }

    public ArrayList<GasStationFields> getListGasStations() {
        return listGasStations;
    }

    public void setListGasStations(ArrayList<GasStationFields> listGasStations) {
        this.listGasStations = listGasStations;
    }

    public static CacheManager getInstance()
    {
        if (instance == null)
        {
            instance = new CacheManager();
        }
        return instance;
    }




}
