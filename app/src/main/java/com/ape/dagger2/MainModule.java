package com.ape.dagger2;

import dagger.Module;
import dagger.Provides;

/**
 * Created by way on 2017/9/10.
 */
@Module //实现一个类，标注为 Module
public class MainModule {

    @Provides //实现一些提供方法，供外部使用
    public Tinno provideTinno(){
        return new Tinno();
    }
}
