package com.nhancv.training.main;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.nhancv.training.MyApp;
import com.nhancv.training.R;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EActivity;

import javax.inject.Inject;

@EActivity(R.layout.activity_main)
public class MainActivity extends MvpActivity<MainView, MainPresenter> implements MainView {

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

        presenter.showHello();

    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return presenter;
    }

    @Override
    public void showHello() {
        Toast.makeText(this, "Hello mvp", Toast.LENGTH_SHORT).show();
    }
}
