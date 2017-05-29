package com.nhancv.training.main;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.nhancv.training.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends MvpActivity<MainView, MainPresenter> implements MainView {

    @AfterViews
    protected void init() {

        presenter.showHello();

    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void showHello() {
        Toast.makeText(this, "Hello mvp", Toast.LENGTH_SHORT).show();
    }
}
