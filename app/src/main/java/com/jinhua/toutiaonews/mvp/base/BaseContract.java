package com.jinhua.toutiaonews.mvp.base;

public interface BaseContract {

    interface BaseView{

    }

    interface BasePresenter<V extends BaseView>{
        void attachView(V view);
        void detachView();
    }

    interface BaseModel{

    }

}
