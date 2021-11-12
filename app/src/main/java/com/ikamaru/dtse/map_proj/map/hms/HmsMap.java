package com.ikamaru.dtse.map_proj.map.hms;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.huawei.hms.maps.CameraUpdateFactory;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.OnMapReadyCallback;
import com.huawei.hms.maps.SupportMapFragment;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.MarkerOptions;
import com.ikamaru.dtse.map_proj.R;
import com.ikamaru.dtse.map_proj.map.IMap;

public class HmsMap implements IMap {
    SupportMapFragment supportMapFragment;

    public HmsMap(FragmentManager fragmentManager){
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
            public void onMapReady(HuaweiMap huaweiMap) {

                // Add a marker in Sydney and move the camera
                LatLng sydney = new LatLng(-34, 151);
                huaweiMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
                huaweiMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            }
        });
    }

}
