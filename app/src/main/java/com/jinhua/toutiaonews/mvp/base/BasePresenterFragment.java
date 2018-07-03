package com.jinhua.toutiaonews.mvp.base;


import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class BasePresenterFragment<V extends BaseContract.BaseView, P extends BasePresenter<V>> extends BaseFragment{

    private P mPresenter;
    public abstract P createPresenter();

    public P getPresenter(){
        return mPresenter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V)this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
