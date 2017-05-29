package com.nhancv.training.main;

import com.hannesdorfmann.mosby.mvp.MvpView;

import ru.terrakok.cicerone.Navigator;

/**
 * Created by nhancao on 5/29/17.
 */

public interface MainView extends MvpView {
    Navigator getNavigator();
    void updateText(int panel, String msg);
}
