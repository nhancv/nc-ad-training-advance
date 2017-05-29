package com.nhancv.training.main;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

/**
 * Created by nhancao on 5/29/17.
 */

public class MainPresenter extends MvpBasePresenter<MainView> {

    public void showHello() {

        if (isViewAttached()) {
            getView().showHello();
        }

    }


}
