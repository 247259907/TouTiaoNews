package com.jinhua.toutiaonews.net.net;

import android.content.Context;

import com.jinhua.toutiaonews.net.retrofit.RetrofitConfig;

import io.reactivex.Observable;

public interface INetContract {

    void init(Context var1, RetrofitConfig var2);

    <T> T getNetService(Class<T> var1);

    void onRequest(Observable var1,ProgressSubscriber progressSubscriber);

//    void onRequest(RequestEntry var1);
}
