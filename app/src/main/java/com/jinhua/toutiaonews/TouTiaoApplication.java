package com.jinhua.toutiaonews;

import android.app.Application;
import android.content.Context;

import com.jinhua.toutiaonews.net.retrofit.HttpMethods;
import com.jinhua.toutiaonews.net.retrofit.HttpRetrofit;
import com.jinhua.toutiaonews.net.retrofit.RetrofitConfig;
import com.jinhua.toutiaonews.net.retrofit.RetrofitManager;

public class TouTiaoApplication extends Application{

    private static Context sContext;
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        sContext = base;

        RetrofitManager.getInstance().init(sContext, new RetrofitConfig.Builder()
                .setBaseUrl("http://fy.iciba.com/").build());
        HttpRetrofit.getInstance(sContext).startUp();
    }
}

