package com.ikamaru.dtse.map_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ikamaru.dtse.map_proj.map.IMap;
import com.ikamaru.dtse.map_proj.map.Map;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IMap map= Map.build(getSupportFragmentManager(),this);
        map.loadMap();
    }
}