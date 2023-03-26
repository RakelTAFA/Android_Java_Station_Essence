package com.example.androidprojectgasstations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.androidprojectgasstations.fragment.GasStationListFragment;
import com.example.androidprojectgasstations.model.GasStationFields;

public class GasStationDetailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_station_detailed);

        Intent intent = getIntent();
        GasStationFields infoFromIntent = (GasStationFields) intent.getSerializableExtra(GasStationListFragment.KEY_DETAILED_INTENT);

        TextView contentAddress, contentCity, contentCode, contentGasType, contentValue, contentUpdate, contentService, contentHours;

        contentAddress = (TextView) findViewById(R.id.address_content);
        contentAddress.setText(infoFromIntent.getAdresse());

        contentCity = (TextView) findViewById(R.id.city_content);
        contentCity.setText(infoFromIntent.getVille());

        contentCode = (TextView) findViewById(R.id.code_content);
        contentCode.setText(infoFromIntent.getComCode());

        contentGasType = (TextView) findViewById(R.id.gas_type_content);
        contentGasType.setText(infoFromIntent.getPrixNom());

        contentValue = (TextView) findViewById(R.id.price_value_content);
        String concatPriceInString = "" + infoFromIntent.getPrixValeur();
        contentValue.setText(concatPriceInString);

        contentUpdate = (TextView) findViewById(R.id.update_price_content);
        contentUpdate.setText(infoFromIntent.getPrixMaj());

        contentService = (TextView) findViewById(R.id.service_content);
        contentService.setText(infoFromIntent.getServicesService());

        contentHours = (TextView) findViewById(R.id.availability_hours_content);
        contentHours.setText(infoFromIntent.getHorairesAutomate2424());

    }

}