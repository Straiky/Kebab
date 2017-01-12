package com.ejemplos.kebab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by adminportatil on 12/01/2017.
 */

public class FirstMapActivity extends AppCompatActivity implements OnMapReadyCallback{

    private FirstMapFragment mFirstMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_map);

        mFirstMapFragment = FirstMapFragment.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.map_container, mFirstMapFragment).commit();

        mFirstMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng cali = new LatLng(43.304735, -2.016757);
        googleMap.addMarker(new MarkerOptions()
                .position(cali)
                .title("Cali la Sucursal del cielo"));

        CameraPosition cameraPosition = CameraPosition.builder()
                .target(cali)
                .zoom(10)
                .build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}