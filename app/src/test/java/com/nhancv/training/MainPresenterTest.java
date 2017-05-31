package com.nhancv.training;

import com.nhancv.training.main.MainPresenter;
import com.nhancv.training.main.MainView;
import com.nhancv.training.main.ObjectBus;

import org.greenrobot.eventbus.EventBus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.commands.Forward;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by nhancao on 5/29/17.
 */

public class MainPresenterTest {
    private MainView view;
    private MainPresenter presenter;
    private Navigator navigator;

    @Before
    public void setup() {
        //setup
        view = mock(MainView.class);
        //setup cicerone
        Cicerone<Router> cicerone = Cicerone.create();
        NavigatorHolder navigatorHolder = cicerone.getNavigatorHolder();
        Router router = cicerone.getRouter();
        navigator = mock(Navigator.class);
        EventBus bus = mock(EventBus.class);

        when(view.getNavigator()).thenReturn(navigator);

        presenter = new MainPresenter(navigatorHolder, router, bus);
        presenter.attachView(view);

        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            ObjectBus objectBus = (ObjectBus) args[0];
            presenter.subScribeBus(objectBus);
            return invocation;
        }).when(bus).post(any());

    }

    @Test
    public void button1Click() {

        //test case button 1 click;
        presenter.showMessage(2, "button1Clicked");
        //assert
        verify(view, times(1)).updateText(2, "button1Clicked");

    }

    @Test
    public void button2Click() {

        //test case button 2 click;
        presenter.showMessage(1, "button2Clicked");
        //assert
        verify(view, times(1)).updateText(1, "button2Clicked");

    }

    @Test
    public void button4Click() {
        presenter.nextScreen();

        //verify screen key
        ArgumentCaptor<Forward> argumentCommand = ArgumentCaptor.forClass(Forward.class);
        verify(navigator, times(1)).applyCommand(argumentCommand.capture());
        Assert.assertEquals("NEXT_SCREEN", argumentCommand.getValue().getScreenKey());
    }
}
