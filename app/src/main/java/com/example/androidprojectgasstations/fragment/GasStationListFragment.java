package com.example.androidprojectgasstations.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.androidprojectgasstations.R;


public class GasStationListFragment extends Fragment {

    View view;

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

        return view;
    }
}