package com.jinhua.toutiaonews.net;



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

    public static MainTestBean mainTestBean1;

    public static void getNetData(final MainDataCallBack callBack) {

        makeFakeData();

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
                //TODO 有错误，出不来结果
                callBack.mainData("hahahahahhha");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


    public static void makeFakeData(){
        mainTestBean1 = new MainTestBean();
        mainTestBean1.setStatus(1);
        MainTestBean.ContentBean contentBean = new MainTestBean.ContentBean();
        contentBean.setFrom("hahahhahahah");
        contentBean.setOut("lalalallalala");
        mainTestBean1.setContent(contentBean);
    }

     public interface MainDataCallBack{
        void mainData(String mainTestBean);
     }
}
