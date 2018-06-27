package com.jinhua.toutiaonews.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.jinhua.toutiaonews.R;
import com.jinhua.toutiaonews.mvp.base.BasePresenterActivity;
import com.jinhua.toutiaonews.mvp.contract.MainContract;
import com.jinhua.toutiaonews.mvp.model.bean.MainTestBean;
import com.jinhua.toutiaonews.mvp.presenter.MainPresenter;

public class MainActivity extends BasePresenterActivity<MainContract.View,MainPresenter> implements MainContract.View {

    private TextView mMainTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("main--->view","12345");

        getData();
        initView();
    }


    public void getData(){
        getPresenter().getMainNetData();
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }


    public void initView(){
        mMainTv = findViewById(R.id.main_tv);
    }

    @Override
    public void getMainNetData(String mainTestBean) {
        mMainTv.setText(mainTestBean);
    }
}


