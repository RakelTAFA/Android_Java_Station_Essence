package com.example.androidprojectgasstations.adapter;

import android.content.Context;
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
    Context context;

    public GasStationAdapter(Context context, ArrayList<GasStationFields> fieldList)
    {
        this.context = context;
        this.fieldList = fieldList;
    }

    @Override
    public int getCount()
    {
        return fieldList.size();
    }

    @Override
    public Object getItem(int i)
    {
        return fieldList.get(i);
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

        GasStationFields gasStationFields = fieldList.get(i);
        TextView gasPrice, gasCity, gasAddress, gasPostalCode, gasType;

        gasPrice = (TextView) gasStationLayout.findViewById(R.id.gas_price);
        gasCity = (TextView) gasStationLayout.findViewById(R.id.gas_city);
        gasAddress = (TextView) gasStationLayout.findViewById(R.id.gas_address);
        gasPostalCode = (TextView) gasStationLayout.findViewById(R.id.gas_postal_code);
        gasType = (TextView) gasStationLayout.findViewById(R.id.gas_type);

        Float gasPriceString = gasStationFields.getPrixValeur();

        gasPrice.setText(gasPriceString.toString());
        gasCity.setText(gasStationFields.getComName());
        gasAddress.setText(gasStationFields.getAdresse());
        gasPostalCode.setText(gasStationFields.getComCode());
        gasType.setText(gasStationFields.getPrixNom());

        return gasStationLayout;
    }
}
