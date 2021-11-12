package com.ikamaru.dtse.map_proj.map;


import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ikamaru.dtse.map_proj.R;
import com.ikamaru.dtse.map_proj.map.IMap;

public class Map implements IMap {
    SupportMapFragment supportMapFragment;

    public Map(FragmentManager fragmentManager){
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.map,new SupportMapFragment());
        fragmentTransaction.commitNow();
        supportMapFragment = (SupportMapFragment) fragmentManager
                .findFragmentById(R.id.map);
    }
    @Override
    public void loadMap() {
        this.supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                // Add a marker in Sydney and move the camera
                LatLng sydney = new LatLng(-34, 151);
                googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            }
        });
    }

}
