package com.nhancv.training.main;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.nhancv.training.Screens;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

/**
 * Created by nhancao on 5/29/17.
 */

public class MainPresenter extends MvpBasePresenter<MainView> {

    private NavigatorHolder navigatorHolder;
    private Router router;
    private EventBus bus;

    @Inject
    public MainPresenter(NavigatorHolder navigatorHolder, Router router, EventBus bus) {
        this.navigatorHolder = navigatorHolder;
        this.router = router;
        this.bus = bus;
    }

    @Override
    public void attachView(MainView view) {
        super.attachView(view);
        bus.register(this);
        navigatorHolder.setNavigator(view.getNavigator());
    }

    @Override
    public void detachView(boolean retainInstance) {
        navigatorHolder.removeNavigator();
        bus.unregister(this);
        super.detachView(retainInstance);
    }

    @Subscribe
    public void subScribeBus(ObjectBus objectBus) {
        if (isViewAttached()) {
            getView().updateText(objectBus.getPanel(), objectBus.getMsg());
        }
    }

    public void nextScreen() {
        router.navigateTo(Screens.NEXT_SCREEN);
    }

    public void backScreen() {
        router.exit();
    }

    public void showMessage(int panel, String msg) {
        bus.post(new ObjectBus(panel, msg));
    }

}
