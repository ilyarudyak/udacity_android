package com.ilyarudyak.android.simplemaps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity2 extends AppCompatActivity
    implements OnMapReadyCallback {

    private GoogleMap mMap;
    private boolean mMapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMapReady = true;
        mMap = googleMap;
        LatLng newYork = new LatLng(40.7484,-73.9857);
        CameraPosition target = CameraPosition.builder().target(newYork).zoom(14).build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}













