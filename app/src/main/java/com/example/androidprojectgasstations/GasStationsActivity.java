package com.example.androidprojectgasstations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.androidprojectgasstations.manager.IGasStationDataManagerCallBack;
import com.example.androidprojectgasstations.manager.MainActivityController;
import com.example.androidprojectgasstations.model.GasStation;


public class GasStationsActivity extends AppCompatActivity implements IGasStationDataManagerCallBack {

    GasStation gasStation = null;
    private MainActivityController mainActivityController = new MainActivityController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_stations);
        // displayGasStation();
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


    private void displayGasStation()
    {

    }

}