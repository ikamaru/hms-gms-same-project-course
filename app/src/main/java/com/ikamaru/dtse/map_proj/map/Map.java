package com.ikamaru.dtse.map_proj.map;

import android.content.Context;

import androidx.fragment.app.FragmentManager;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.SupportMapFragment;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.ikamaru.dtse.map_proj.map.gms.GmsMap;
import com.ikamaru.dtse.map_proj.map.hms.HmsMap;

public class Map {
    public static IMap build(FragmentManager fragmentManager, Context context){
        //if hms is available
        if(HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(context)== com.huawei.hms.api.ConnectionResult.SUCCESS) {
            //return the hms map
            return new HmsMap(fragmentManager);
        } else {
            if(GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context)== com.google.android.gms.common.ConnectionResult.SUCCESS) {
                //return the gms map
                return new GmsMap(fragmentManager);
            }
        }
        return null;
    }
}
