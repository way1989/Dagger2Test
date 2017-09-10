package com.ape.dagger2;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by way on 2017/9/10.
 */
@Module //实现一个类，标注为 Module
public class MainModule {
    private Context mApplicationContext;
    private Context mActivityContext;

    public MainModule(Context context, Context activityContext) {
        mApplicationContext = context;
        mActivityContext = activityContext;
    }

    @Provides //实现一些提供方法，供外部使用
    public Tinno provideTinno(@ApplicationQualifier Context context, Gson gson, CameraTeam cameraTeam) {
        return new Tinno(context, gson, cameraTeam);
    }

    @ApplicationQualifier
    @Provides
    public Context provideApplicationContext() {
        return mApplicationContext;
    }

    @ActivityQualifier
    @Provides
    public Context provideActivityContext() {
        return mActivityContext;
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
