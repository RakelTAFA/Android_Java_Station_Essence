package com.example.androidprojectgasstations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.androidprojectgasstations.fragment.GasStationListFragment;
import com.example.androidprojectgasstations.model.GasStationFields;

public class GasStationDetailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_station_detailed);

        Intent intent = getIntent();
        GasStationFields infoFromIntent = (GasStationFields) intent.getSerializableExtra(GasStationListFragment.KEY_DETAILED_INTENT);

    }

}