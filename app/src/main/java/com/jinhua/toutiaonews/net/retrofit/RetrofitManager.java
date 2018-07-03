package com.jinhua.toutiaonews.net.retrofit;

import android.content.Context;

import com.jinhua.toutiaonews.net.net.INetContract;
import com.jinhua.toutiaonews.net.net.ProgressSubscriber;

import io.reactivex.Observable;

public class RetrofitManager implements INetContract {

    private  static volatile RetrofitManager instance;
    private HttpRetrofit mHttpRetrofit;
    private HttpMethods mHttpMethods;

    private RetrofitManager(){}

    public static RetrofitManager getInstance(){
        if(instance == null){
            synchronized (RetrofitManager.class){
                if(instance == null){
                    instance = new RetrofitManager();
                }
            }
        }
        return instance;
    }

    public void init(Context context,RetrofitConfig retrofitConfig){
        HttpRetrofit.getInstance(context).initConfig(retrofitConfig);
        HttpMethods.getInstance().init(context);
        mHttpRetrofit = HttpRetrofit.getInstance(context);
        mHttpMethods = HttpMethods.getInstance();
    }

    @Override
    public <T> T getNetService(Class<T> var1) {
        return mHttpRetrofit.getObj(var1);
    }

    @Override
    public void onRequest(Observable var1, ProgressSubscriber progressSubscriber) {
        mHttpMethods.onSub(var1,progressSubscriber);
    }
}
