package com.jinhua.toutiaonews.net;


import com.jinhua.toutiaonews.mvp.model.bean.TestBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 以前不用的
 */
public class NetHelper {


    public static void getNetData(final MainDataCallBack callBack){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiHelper apiHelper = retrofit.create(ApiHelper.class);

        Observable<TestBean> observable = apiHelper.onResult();

        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<TestBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TestBean mainTestBean) {
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
        void mainData(TestBean mainTestBean);
     }
}
