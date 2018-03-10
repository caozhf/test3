package com.caozhf.gittest2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MapView mapView = null;
    private Button satellite, original, traffic;
    private BaiduMap baiduMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        BMapManager.init();
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        satellite = (Button) findViewById(R.id.satellite);
        original = (Button) findViewById(R.id.original);
        traffic = (Button) findViewById(R.id.traffic);
        mapView = (MapView) findViewById(R.id.bmapView);
        baiduMap = mapView.getMap();
        MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(15.0f);
        baiduMap.setMapStatus(msu);

        satellite.setOnClickListener(this);
        original.setOnClickListener(this);
        traffic.setOnClickListener(this);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.satellite:
                baiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.original:
                baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                break;
            case R.id.traffic:
                if (baiduMap.isTrafficEnabled()) {
                    baiduMap.setTrafficEnabled(false);

                } else {
                    baiduMap.setTrafficEnabled(true);
                }
                break;
        }
    }
}
