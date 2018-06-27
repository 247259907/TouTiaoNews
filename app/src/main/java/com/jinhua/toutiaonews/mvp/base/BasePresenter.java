package com.jinhua.toutiaonews.mvp.base;

public  abstract class BasePresenter<V extends BaseContract.BaseView> implements BaseContract.BasePresenter<V>{

    private V view;

    private V getView(){
        return view;
    }

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
