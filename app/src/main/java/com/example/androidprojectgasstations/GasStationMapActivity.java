package com.example.androidprojectgasstations;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.zip.Inflater;

public class GasStationMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    View view = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_station_map);

        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.map_widget, mapFragment)
                .commit();


    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        Log.e("MAPS_DEBUG", "--Map displayed");



    }
}
