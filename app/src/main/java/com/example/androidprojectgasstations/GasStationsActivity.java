package com.example.androidprojectgasstations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.androidprojectgasstations.fragment.GasStationListFragment;
import com.example.androidprojectgasstations.fragment.GasStationMapFragment;
import com.example.androidprojectgasstations.manager.IGasStationDataManagerCallBack;
import com.example.androidprojectgasstations.manager.GasStationsActivityController;
import com.example.androidprojectgasstations.model.GasStation;
import com.example.androidprojectgasstations.model.GasStationFields;
import com.example.androidprojectgasstations.model.GasStationRecords;

import java.util.ArrayList;
import java.util.List;


public class GasStationsActivity extends AppCompatActivity implements IGasStationDataManagerCallBack {

    GasStation gasStation = null;
    private GasStationsActivityController gasStationsActivityController = new GasStationsActivityController();

    List<GasStationFields> listGasStations = new ArrayList<>();

    // Activity elements
    Button listFragmentButton, mapFragmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_stations);
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
                replaceFragment(new GasStationMapFragment());
            }
        });




        getStations();
    }


    private void getStations()
    {
        gasStationsActivityController.getGasStations(new IGasStationDataManagerCallBack() {
            @Override
            public void getGasStationsResponseSuccess(GasStation gasStation) {
                List<GasStationRecords> listRecords = gasStation.getRecords();
                for (GasStationRecords gsRecords : listRecords)
                {
                    Log.d("RECORDS", gsRecords.getRecordid());
                    Log.d("RECORDS_FIELD", gsRecords.getFields().getAdresse());
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
        /*
        TextView t = findViewById(R.id.tv_hello);
        t.setText(clock.getDatetime());
         */
    }


    @Override
    public void getGasStationsResponseError(String message) {
        Log.e("ERROR main activity", "Response Error " + message);
        /*
        AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
        alert.setTitle("Erreur").setMessage("une erreur est apparue lors de la recherche de données");
        alert.setCancelable(false);
        alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alert.setIcon(R.drawable.ic_launcher_background);
        alert.create().show();

         */
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