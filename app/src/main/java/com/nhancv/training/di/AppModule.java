package com.nhancv.training.di;

import com.nhancv.training.MyApp;

import org.greenrobot.eventbus.EventBus;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nhancao on 5/29/17.
 */

@Module
public class AppModule {
    private MyApp app;

    public AppModule(MyApp app) {
        this.app = app;
    }

    @AppScope
    @Provides
    public EventBus provideEventBus() {
        return new EventBus();
    }

}
