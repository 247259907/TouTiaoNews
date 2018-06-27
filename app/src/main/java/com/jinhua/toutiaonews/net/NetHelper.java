package com.jinhua.toutiaonews.net;


import android.util.Log;

import com.jinhua.toutiaonews.mvp.model.bean.MainTestBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetHelper {


    public static void getNetData(final MainDataCallBack callBack){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiHelper apiHelper = retrofit.create(ApiHelper.class);

        Observable<MainTestBean> observable = apiHelper.onResult();

        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<MainTestBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MainTestBean mainTestBean) {
                callBack.mainData(mainTestBean);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
     }




     public interface MainDataCallBack{
        void mainData(MainTestBean mainTestBean);
     }
}
