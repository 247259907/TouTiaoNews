package com.jinhua.toutiaonews.net.net;

import com.jinhua.toutiaonews.mvp.base.BaseContract;

public class BZCallback<A,P extends BaseContract.BaseView> implements SubscriberOnNextListener{

    private A action;
    private P view;

    public BZCallback(A action, P view) {
        this.action = action;
        this.view = view;
    }

    @Override
    public void onSuccess(Object var1) {
        if(view != null){
            view.onSuccess(action,var1);
        }
    }

    @Override
    public void onError(int var1, String var2) {
        if (view != null){
            view.onError(action,var1,var2);
        }
    }

    @Override
    public void onStartUp() {

    }

    @Override
    public void onCompleted() {
        if (view != null){
            view.onCompleted(action);
        }
    }

    @Override
    public void onLoading(boolean var1) {

    }
}
