package com.jinhua.toutiaonews.net.net;

public interface SubscriberOnNextListener<T> {

    void onSuccess(T var1);

    void onError(int var1, String var2);

    void onStartUp();

    void onCompleted();

    void onLoading(boolean var1);

}
