package com.example.homeworkweek6day2;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    //Marker Options
    MarkerOptions markerOptionsHome;
    MarkerOptions markerOptionsUser;

    //Location Request
    //LocationRequest locationRequest;


    private GoogleMap mMap;
    TextView latitude;
    TextView longitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        latitude = findViewById(R.id.tvLatitude);
        longitude = findViewById(R.id.tvLongitude);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng homeLocation = new LatLng(34.032913, -84.4410288);
        markerOptionsHome = new MarkerOptions().position(homeLocation).title("Marker is home");
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        mMap.addMarker(markerOptionsHome);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(homeLocation));
    }

    public void onClick(View view) {
        mMap.clear(); //remove all markers
        if (latitude != null && longitude != null){
            double lat =  Double.parseDouble(latitude.getText().toString());
            double lng =  Double.parseDouble(longitude.getText().toString());

            LatLng enterLocation = new LatLng(lat, -lng);
            //create new marker on map
            markerOptionsUser = new MarkerOptions()
                    .position(enterLocation)
                    .title("User entered location");

            //Add the marker to the map
            mMap.addMarker(markerOptionsUser);

            //move to the latlng
            mMap.moveCamera(CameraUpdateFactory.newLatLng(markerOptionsUser.getPosition()));

            //Set the Zoom level (0 - 20)
            mMap.setMinZoomPreference(18.0f);

        }






    }


}
