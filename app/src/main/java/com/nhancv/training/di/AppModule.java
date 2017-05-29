package com.nhancv.training.di;

import com.nhancv.training.MyApp;

import dagger.Module;

/**
 * Created by nhancao on 5/29/17.
 */

@Module
public class AppModule {
    private MyApp app;

    public AppModule(MyApp app) {
        this.app = app;
    }

}
