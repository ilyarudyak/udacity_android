package com.ilyarudyak.android.simplemaps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity3 extends AppCompatActivity
        implements OnMapReadyCallback {

    private GoogleMap mMap;
    private boolean mMapReady = false;

    private static final CameraPosition SEATTLE = CameraPosition.builder()
            .target(new LatLng(47.6204,-122.3491))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();
    private static final CameraPosition DUBLIN = CameraPosition.builder()
            .target(new LatLng(53.3478,-6.2597))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();
    private static final CameraPosition TOKYO = CameraPosition.builder()
            .target(new LatLng(35.6895,139.6917))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ButterKnife.bind(this);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @OnClick({ R.id.btn_seattle, R.id.btn_tokyo, R.id.btn_dublin })
    public void onBtnClicked(View v) {
        if (mMapReady) {
            switch (v.getId()) {
                case R.id.btn_seattle:
                    flyTo(SEATTLE);
                    break;
                case R.id.btn_tokyo:
                    flyTo(TOKYO);
                    break;
                case R.id.btn_dublin:
                    flyTo(DUBLIN);
                    break;
                default:
                    throw new IllegalArgumentException("illegal id");
            }
        }
    }

    // helper function
    private void flyTo(CameraPosition target) {
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMapReady = true;
        mMap = googleMap;
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(SEATTLE));
    }
}



















