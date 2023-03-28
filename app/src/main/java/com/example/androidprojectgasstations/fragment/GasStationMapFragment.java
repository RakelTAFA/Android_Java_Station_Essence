package com.example.androidprojectgasstations.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidprojectgasstations.R;
import com.example.androidprojectgasstations.manager.CacheManager;
import com.example.androidprojectgasstations.model.GasStation;
import com.example.androidprojectgasstations.model.GasStationFields;
import com.example.androidprojectgasstations.model.GasStationGeometry;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import java.math.BigDecimal;
import java.util.ArrayList;

public class GasStationMapFragment extends Fragment {

    View view;
    GasStation gasStation = null;
    private GoogleMap gMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_gas_station_map, container, false);

        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.map_widget, mapFragment);
        fragmentTransaction.commit();

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                gMap = googleMap;
                // ...
            }
        });

        ArrayList<GasStationGeometry> gasStationGeometry = new ArrayList<GasStationGeometry>();

        if (CacheManager.getInstance().getGasStation() != null)
        {
            for (int i = 0; i < CacheManager.getInstance().getGasStation().getRecords().size(); i++)
            {
                gasStationGeometry.add(CacheManager.getInstance().getGasStation().getRecords().get(i).getGeometry());
            }
        }

        return view;
    }
}