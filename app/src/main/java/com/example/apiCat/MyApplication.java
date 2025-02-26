package com.example.apiCat;

import android.app.Application;

public class MyApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();

    }
    public AppComponent getAppComponent(){
        return appComponent;
    }
}
