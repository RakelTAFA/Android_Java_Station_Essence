package com.example.androidprojectgasstations;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidprojectgasstations.manager.CacheManager;
import com.example.androidprojectgasstations.model.GasStation;
import com.example.androidprojectgasstations.model.GasStationFields;
import com.example.androidprojectgasstations.model.GasStationGeometry;
import com.example.androidprojectgasstations.model.GasStationRecords;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class GasStationMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    GasStation gasStation = null;
    ArrayList<GasStationFields> gasStationFieldsList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_station_map);

        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.map_widget, mapFragment)
                .commit();
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        Log.d("MAPS_DEBUG", "--Map displayed");

        gasStation = CacheManager.getInstance().getGasStation();

        if (gasStation != null)
        {
            gasStationFieldsList = new ArrayList<GasStationFields>();
            for (int i = 0; i < gasStation.getRecords().size(); i++)
            {
                gasStationFieldsList.add(gasStation.getRecords().get(i).getFields());
            }
        }

        int i = 0;

        if (gasStation != null) {
            for (GasStationFields field : gasStationFieldsList)
            {
                if (field.getPrixNom() == null)
                {
                    Log.e("ITERATION_DEBUG", ">>> Passage CONTINUE");
                    continue;
                }
                LatLng lat = new LatLng(field.getGeom().get(0), field.getGeom().get(1));
                if (field.getPrixNom().equals("Gazole"))
                {
                    googleMap.addMarker(new MarkerOptions()
                            .position(lat)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                            .title("Gazole " + field.getVille()));
                }
                else if (field.getPrixNom().equals("SP98"))
                {
                    googleMap.addMarker(new MarkerOptions()
                            .position(lat)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                            .title("SP98 " + field.getVille()));
                }
                else if (field.getPrixNom().equals("SP95"))
                {
                    googleMap.addMarker(new MarkerOptions()
                            .position(lat)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                            .title("SP95 " + field.getVille()));
                }
                else
                {
                    googleMap.addMarker(new MarkerOptions()
                            .position(lat)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                            .title("" + field.getPrixNom() + " " + field.getVille()));
                }
                i++;
                Log.e("ITERATION_DEBUG", "Iteration " + i + " !");
            }
        }

    }
}
