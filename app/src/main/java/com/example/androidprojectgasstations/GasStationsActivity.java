package com.example.androidprojectgasstations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.androidprojectgasstations.adapter.GasStationAdapter;
import com.example.androidprojectgasstations.fragment.GasStationListFragment;
import com.example.androidprojectgasstations.manager.IGasStationDataManagerCallBack;
import com.example.androidprojectgasstations.manager.GasStationsActivityController;
import com.example.androidprojectgasstations.model.GasStation;
import com.example.androidprojectgasstations.model.GasStationFields;
import com.example.androidprojectgasstations.model.GasStationRecords;

import java.util.ArrayList;
import java.util.List;


public class GasStationsActivity extends AppCompatActivity implements IGasStationDataManagerCallBack {

    private GasStationsActivityController gasStationsActivityController = new GasStationsActivityController();
    GasStationAdapter gasStationAdapter = null;

    ArrayList<GasStationFields> listGasStations = new ArrayList<>();

    // Activity elements
    Button listFragmentButton, mapFragmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_stations);
        getStations();
        replaceFragment(new GasStationListFragment());

        listFragmentButton = findViewById(R.id.list_button_fragment);
        mapFragmentButton = findViewById(R.id.map_button_fragment);

        listFragmentButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                replaceFragment(new GasStationListFragment());
            }
        });

        mapFragmentButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent toMap = new Intent(getApplicationContext(), GasStationMapActivity.class);
                startActivity(toMap);
            }
        });
    }


    private void getStations()
    {
        gasStationsActivityController.getGasStations(new IGasStationDataManagerCallBack() {
            @Override
            public void getGasStationsResponseSuccess(GasStation gasStation) {
                List<GasStationRecords> listRecords = gasStation.getRecords();
                for (GasStationRecords gsRecords : listRecords)
                {
                    Log.d("RECORDS_ID", "" + gsRecords.getRecordid());
                    Log.d("RECORDS_ADDRESS", "" + gsRecords.getFields().getAdresse());
                    Log.d("RECORDS_TYPE", "" + gsRecords.getFields().getPrixNom());
                    Log.d("RECORDS_PRICE", "" + gsRecords.getFields().getPrixValeur());
                }
            }

            @Override
            public void getGasStationsResponseError(String message) {

            }
        });
    }


    @Override
    public void getGasStationsResponseSuccess(GasStation gs) {
        Log.e("SUCCESS main activity", "SUCCESS main activity");

    }


    @Override
    public void getGasStationsResponseError(String message) {
        Log.e("ERROR main activity", "Response Error " + message);

    }

    // Fragments

    private void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout, fragment);
        fragmentTransaction.commit();
    }

}