package com.ape.dagger2;

import android.content.Context;

import com.google.gson.Gson;

/**
 * Created by way on 2017/9/10.
 */

public class Tinno {
    private Context mContext;
    private Gson mGson;
    private CameraTeam mCameraTeam;

    public Tinno(Context context, Gson gson, CameraTeam cameraTeam) {
        mContext = context;
        mGson = gson;
        mCameraTeam = cameraTeam;
    }
}
