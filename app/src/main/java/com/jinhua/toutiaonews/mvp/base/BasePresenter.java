package com.jinhua.toutiaonews.mvp.base;

import com.jinhua.toutiaonews.net.net.BZCallback;
import com.jinhua.toutiaonews.net.net.ProgressSubscriber;

public  abstract class BasePresenter<V extends BaseContract.BaseView> implements BaseContract.BasePresenter<V>{

    private V view;

    public V getView(){
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

    protected ProgressSubscriber createProgressSubscriber(Enum action, BaseContract.BaseView view){
        return new ProgressSubscriber(new BZCallback(action,view));
    }
}
