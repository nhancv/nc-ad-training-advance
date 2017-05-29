package com.nhancv.training;

import android.support.multidex.MultiDexApplication;

import com.nhancv.training.di.AppComponent;
import com.nhancv.training.di.AppModule;
import com.nhancv.training.di.DaggerAppComponent;

import org.androidannotations.annotations.EApplication;

/**
 * Created by nhancao on 5/29/17.
 */

@EApplication
public class MyApp extends MultiDexApplication {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setAppComponent();
    }

    public void setAppComponent() {
        this.appComponent = DaggerAppComponent.builder()
                                              .appModule(new AppModule(this))
                                              .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
