package com.example.androidprojectgasstations.manager;

import com.example.androidprojectgasstations.service.GasStationService;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    final static String BASE_URL = "https://data.economie.gouv.fr/api/records/1.0/search/";

    private GasStationService gasStationService = null;

    private static ApiManager instance;

    public GasStationService getGasStationService() {
        return gasStationService;
    }

    public static ApiManager getInstance() {
        if (instance == null) {
            instance = new ApiManager();
        }

        return instance;
    }

    private ApiManager() {
        createRetrofitGasStation();
    }

    private void createRetrofitGasStation() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        Retrofit retrofitClock = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        gasStationService = retrofitClock.create(GasStationService.class);
    }

}
