package com.ape.dagger2;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

import dagger.Module;
import dagger.Provides;

/**
 * Created by way on 2017/9/10.
 */
@Module //实现一个类，标注为 Module
public class MainModule {
    private Context mContext;

    public MainModule(Context context) {
        mContext = context;
    }

    @Provides //实现一些提供方法，供外部使用
    public Tinno provideTinno(Gson gson, CameraTeam cameraTeam) {
        return new Tinno(mContext, gson, cameraTeam);
    }

    @Provides
    public Gson provideGson() {
        return new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.PROTECTED)//忽略protected字段
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

    }

//    @Provides
//    public CameraTeam provideCameraTeam() {
//        return new CameraTeam();
//    }
}
