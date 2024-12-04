package com.example.javademos.dagger2;

import android.app.Application;

import com.example.javademos.dagger2.network.AppComponent;
import com.example.javademos.dagger2.network.DaggerAppComponent;
import com.example.javademos.dagger2.network.NetworkModule;

public class MyApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .networkModule(new NetworkModule("http://demo8912703.mockable.io/"))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
