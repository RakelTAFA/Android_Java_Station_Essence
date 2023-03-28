package com.example.androidprojectgasstations.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidprojectgasstations.R;
import com.example.androidprojectgasstations.manager.CacheManager;
import com.example.androidprojectgasstations.model.GasStation;
import com.example.androidprojectgasstations.model.GasStationFields;
import com.example.androidprojectgasstations.model.GasStationGeometry;

import java.math.BigDecimal;
import java.util.ArrayList;

public class GasStationMapFragment extends Fragment {

    View view;
    GasStation gasStation = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_gas_station_map, container, false);



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