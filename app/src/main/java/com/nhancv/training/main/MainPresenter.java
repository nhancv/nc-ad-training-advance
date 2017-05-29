package com.nhancv.training.main;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

/**
 * Created by nhancao on 5/29/17.
 */

public class MainPresenter extends MvpBasePresenter<MainView> {

    @Inject
    protected EventBus bus;

    @Inject
    public MainPresenter() {
    }

    @Override
    public void attachView(MainView view) {
        super.attachView(view);
        bus.register(this);
    }

    @Override
    public void detachView(boolean retainInstance) {
        bus.unregister(this);
        super.detachView(retainInstance);
    }

    @Subscribe
    public void subScribeBus(ObjectBus objectBus) {
        if (isViewAttached()) {
            getView().updateText(objectBus.panel, objectBus.msg);
        }
    }

    public void showMessage(int panel, String msg) {
        bus.post(new ObjectBus(panel, msg));
    }

    private class ObjectBus {
        int panel;
        String msg;

        ObjectBus(int panel, String msg) {
            this.panel = panel;
            this.msg = msg;
        }
    }

}
