package com.example.day03xrecycleview.view;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by 因为有个你i on 2018/5/11.
 */

public class MyApp extends Application{
    private static MyApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
        Fresco.initialize(this);


    }
    public static MyApp getInstance(){
        return mInstance;
    };
}
