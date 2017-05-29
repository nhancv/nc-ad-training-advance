package com.nhancv.training.main;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import javax.inject.Inject;

/**
 * Created by nhancao on 5/29/17.
 */

public class MainPresenter extends MvpBasePresenter<MainView> {

    @Inject
    public MainPresenter() {
    }

    public void showHello() {

        if (isViewAttached()) {
            getView().showHello();
        }

    }


}
