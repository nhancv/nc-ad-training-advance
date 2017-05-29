package com.nhancv.training.main;

import android.support.annotation.NonNull;
import android.widget.Button;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.nhancv.training.MyApp;
import com.nhancv.training.R;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

@EActivity(R.layout.activity_main)
public class MainActivity extends MvpActivity<MainView, MainPresenter> implements MainView {

    @ViewById(R.id.button1)
    protected Button button1;
    @ViewById(R.id.button2)
    protected Button button2;

    @App
    protected MyApp app;
    @Inject
    protected MainPresenter presenter;

    @AfterInject
    protected void inject() {
        DaggerMainComponent
                .builder()
                .appComponent(app.getAppComponent())
                .build()
                .inject(this);
    }

    @AfterViews
    protected void init() {
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return presenter;
    }

    @Click(R.id.button1)
    protected void button1Click() {
        presenter.showMessage(2, "button1Clicked: " + System.currentTimeMillis());
    }

    @Click(R.id.button2)
    protected void button2Click() {
        presenter.showMessage(1, "button2Clicked: " + System.currentTimeMillis());
    }

    @Override
    public void updateText(int panel, String msg) {
        switch (panel) {
            case 1:
                button1.setText(msg);
                break;
            case 2:
                button2.setText(msg);
                break;
        }
    }
}
