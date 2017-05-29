package com.nhancv.training.main;

import com.nhancv.training.di.AppComponent;
import com.nhancv.training.di.NavigationModule;
import com.nhancv.training.di.ViewScope;

import dagger.Component;

/**
 * Created by nhancao on 5/29/17.
 */

@ViewScope
@Component(dependencies = AppComponent.class,
           modules = NavigationModule.class)
public interface MainComponent {
    MainPresenter presenter();

    void inject(MainActivity activity);
}
