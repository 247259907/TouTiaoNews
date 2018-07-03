package com.jinhua.toutiaonews.mvp.base;

public interface BaseContract {

    interface BaseView<A,P>{
        void onSuccess(A var1, Object var2);

        void onError(A var1, int var2, String var3);

        void onStartUp(A var1);

        void onCompleted(A var1);

        void showLoading(boolean var1);

    }

    interface BasePresenter<V extends BaseView>{
        void attachView(V view);
        void detachView();
    }

    interface BaseModel{

    }

}
