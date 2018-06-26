package com.jinhua.toutiaonews.ui.activity;

import android.os.Bundle;

import com.jinhua.toutiaonews.R;
import com.jinhua.toutiaonews.mvp.base.BasePresenterActivity;
import com.jinhua.toutiaonews.mvp.contract.MainContract;
import com.jinhua.toutiaonews.mvp.presenter.MainPresenter;

public class MainActivity extends BasePresenterActivity<MainContract.MainView,MainPresenter> implements MainContract.MainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
