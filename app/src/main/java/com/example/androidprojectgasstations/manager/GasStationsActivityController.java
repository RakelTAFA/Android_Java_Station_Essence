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

    /*  Pas utile ici
    public void getGasStationThread(IGasStationDataManagerCallBack callBack)
    {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try
                {
                    Response<GasStation> response = apiManager.getGasStationService().getGasStations().execute();
                    if (response.isSuccessful())
                    {
                        GasStation gs = response.body();
                        Log.e("onResponse", "Runnable Successful" + gs.getRecords().toString());
                        callBack.getGasStationsResponseSuccess(gs);
                    }
                    else
                    {
                        Log.e("onResponse", "Runnable Not Successful" + response.code());
                        callBack.getGasStationsResponseError("Runnable Erreur Server status : " + response.code());
                    }
                }
                catch (IOException e)
                {
                    Log.e("onResponse", "Try runnable not successful : " + e.getLocalizedMessage());
                    callBack.getGasStationsResponseError("Erreur lors de la requete : " + e.getLocalizedMessage());
                }
            }
        };
        new Thread(r).start();
    }
    */
    // Deuxième méthode mais pas utile ici
}
