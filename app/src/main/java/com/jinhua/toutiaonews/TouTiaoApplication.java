package com.jinhua.toutiaonews;

import android.app.Application;
import android.content.Context;

public class TouTiaoApplication extends Application{

    private static Context sContext;
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        sContext = base;
    }
}

