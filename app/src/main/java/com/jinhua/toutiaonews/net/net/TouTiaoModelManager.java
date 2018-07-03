package com.jinhua.toutiaonews.net.net;

import com.jinhua.toutiaonews.mvp.base.BaseModel;

import io.reactivex.Observable;

public class TouTiaoModelManager extends BaseModel<ITouTiaoServer> {

    private static TouTiaoModelManager sInstance;

    private TouTiaoModelManager(){
        super(ITouTiaoServer.class);
    }

    public static TouTiaoModelManager getInstance(){
        if(sInstance == null){
            synchronized (TouTiaoModelManager.class){
                if(sInstance == null){
                    sInstance = new TouTiaoModelManager();
                }
            }
        }
        return sInstance;
    }

    /**
     * 获取测试数据
     */
    public void getTestData(ProgressSubscriber progressSubscriber){
        Observable mObservable = mapiService.getTestData();
        iNetContract.onRequest(mObservable,progressSubscriber);
    }

}
