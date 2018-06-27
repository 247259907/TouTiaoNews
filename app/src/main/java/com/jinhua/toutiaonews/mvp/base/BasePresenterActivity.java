package com.jinhua.toutiaonews.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;


public abstract class BasePresenterActivity<V extends BaseContract.BaseView,T extends BasePresenter<V>> extends FragmentActivity implements BaseContract.BaseView {

    private V view;
    private T presenter;

    public T getPresenter(){
        return presenter;
    }

    public abstract T createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(view == null){
            this.view = (V)this;
        }
        if(presenter == null){
            this.presenter = createPresenter();
        }
        if(view != null && presenter != null){
            this.presenter.attachView(this.view);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.presenter.detachView();
    }
}
