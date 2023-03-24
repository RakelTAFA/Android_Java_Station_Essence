package com.example.androidprojectgasstations.manager;

import android.util.Log;

import com.example.androidprojectgasstations.model.GasStation;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GasStationsActivityController {

    private final ApiManager apiManager;

    public GasStationsActivityController() {
        apiManager = ApiManager.getInstance();
    }

    public void getGasStations(IGasStationDataManagerCallBack callBack)
    {
        Call<GasStation> callAllGasStations = apiManager.getGasStationService().getGasStations();
        callAllGasStations.enqueue(new Callback<GasStation>() {
            @Override
            public void onResponse(Call<GasStation> call, Response<GasStation> response) {
                if (response.isSuccessful())
                {
                    GasStation gs = response.body();
                    Log.e("onResponse", "Successful_response_api : " + gs.getRecords().toString());
                    CacheManager.getInstance().setGasStation(gs);
                    callBack.getGasStationsResponseSuccess(gs);
                }
                else
                {
                    Log.e("onResponse", "Not_successful_response");
                    callBack.getGasStationsResponseError("Erreur status server : " + response.code());
                }
            }

            @Override
            public void onFailure(Call<GasStation> call, Throwable t) {
                Log.e("onFailure", t.getLocalizedMessage());
                callBack.getGasStationsResponseError("Erreur lors de la requete : " + t.getLocalizedMessage());
            }
        });
    }
}
