package com.chan.rize.generalcode.utils.map.overlayutil;

import android.os.Bundle;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.poi.PoiResult;
import com.chan.rize.generalcode.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2018/1/29.
 */

public class CarParkOverlayManager extends OverlayManager {

    private static final int MAX_POI_SIZE = 10;

    private PoiResult poiResult = null;

    public CarParkOverlayManager(BaiduMap baiduMap) {
        super(baiduMap);
    }

    public void setData(PoiResult poiResult) {
        this.poiResult = poiResult;
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (!mOverlayList.contains(marker)) {
            return false;
        }
        if (marker.getExtraInfo() != null) {
            int index = marker.getExtraInfo().getInt("index");
            PoiInfo poiInfo = poiResult.getAllPoi().get(index);
            onPoiClick(poiInfo);
            return true;
        }
        return false;
    }

    protected void onPoiClick(PoiInfo poiInfo) {
    }


    @Override
    public List<OverlayOptions> getOverlayOptions() {
        if (poiResult == null || poiResult.getAllPoi() == null) {
            return null;
        }
        List<OverlayOptions> markerList = new ArrayList<OverlayOptions>();
        int markerSize = 0;
        for (int i = 0; i < poiResult.getAllPoi().size()
                && markerSize < MAX_POI_SIZE; i++) {
            if (poiResult.getAllPoi().get(i).location == null) {
                continue;
            }
            markerSize++;
            Bundle bundle = new Bundle();
            bundle.putInt("index", i);
            markerList.add(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher_background))
                    .extraInfo(bundle)
                    .position(poiResult.getAllPoi().get(i).location));

        }
        return markerList;
    }


    @Override
    public boolean onPolylineClick(Polyline polyline) {
        return false;
    }


}
