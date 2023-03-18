package com.example.androidprojectgasstations.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.androidprojectgasstations.R;
import com.example.androidprojectgasstations.model.GasStationFields;

import java.util.ArrayList;

public class GasStationAdapter extends BaseAdapter {

    ArrayList<GasStationFields> fieldList = null;

    @Override
    public int getCount()
    {
        return 0;
    }

    @Override
    public Object getItem(int i)
    {
        return 0; // contactList.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        ConstraintLayout gasStationLayout;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        if (view == null)
        {
            gasStationLayout = (ConstraintLayout) inflater.inflate(R.layout.activity_adapter_gas_station, viewGroup, false);
        }
        else
        {
            gasStationLayout = (ConstraintLayout) view;
        }



        return null;
    }

}
