package com.jinhua.toutiaonews.mvp.base;

import com.jinhua.toutiaonews.net.net.INetContract;
import com.jinhua.toutiaonews.net.retrofit.RetrofitManager;

public class BaseModel<T> {

    protected INetContract iNetContract = RetrofitManager.getInstance();
    protected T mapiService;

    protected BaseModel(Class<T> clazz){
        this.mapiService = this.iNetContract.getNetService(clazz);
    }
}
