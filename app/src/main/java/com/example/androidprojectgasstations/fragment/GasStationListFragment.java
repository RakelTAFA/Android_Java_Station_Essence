package com.example.androidprojectgasstations.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.androidprojectgasstations.R;
import com.example.androidprojectgasstations.adapter.GasStationAdapter;
import com.example.androidprojectgasstations.manager.CacheManager;
import com.example.androidprojectgasstations.model.GasStation;
import com.example.androidprojectgasstations.model.GasStationFields;
import com.example.androidprojectgasstations.model.GasStationRecords;

import java.util.ArrayList;


public class GasStationListFragment extends Fragment {

    View view;
    GasStation gasStation = null;

    private String[] spinnerChoiceList = { "Prix" , "Date" };
    private String[] spinnerSortList = { "Croissant" , "Décroissant" };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_gas_station_list, container, false);

        Spinner spinnerChoice = (Spinner) view.findViewById(R.id.request_choice_spinner);
        Spinner spinnerSort = (Spinner) view.findViewById(R.id.request_sort_spinner);

        ArrayAdapter<String> spinnerChoiceAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, spinnerChoiceList);
        ArrayAdapter<String> spinnerSortAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, spinnerSortList);

        spinnerChoice.setAdapter(spinnerChoiceAdapter);
        spinnerSort.setAdapter(spinnerSortAdapter);

        ListView gasStationListView = view.findViewById(R.id.gas_station_list_view);

        // ici se passe l'envoi mais il faut les données et pas une array vide comme là
        // Il me faut ArrayList<>(GasStationFields)
        ArrayList<GasStationFields> gasStationFields = new ArrayList<GasStationFields>();

        // Il faudra modifier le get(0) par l'objet lui-même plus tard
        gasStationFields.add(CacheManager.getInstance().getGasStation().getRecords().get(0).getFields());

        // Avec ce qu'il y a juste au dessus, modifier le constructeur, remplacer ArrayList par simple objet !
        GasStationAdapter gasStationAdapter = new GasStationAdapter(getActivity(), gasStationFields);
        ListView listView = (ListView) view.findViewById(R.id.gas_station_list_view);
        listView.setAdapter(gasStationAdapter);

        return view;
    }
}