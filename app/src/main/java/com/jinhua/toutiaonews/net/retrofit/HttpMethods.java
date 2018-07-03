package com.jinhua.toutiaonews.net.retrofit;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.jinhua.toutiaonews.net.net.ProgressSubscriber;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HttpMethods {

    private static volatile HttpMethods sInstance;
    private Context mContext;

    private HttpMethods(){

    }

    public static HttpMethods getInstance(){
        if (sInstance == null) {
            synchronized (HttpMethods.class) {
                sInstance = new HttpMethods();
            }
        }
        return sInstance;
    }

    public void init(Context context){
        this.mContext = context;
    }


    /**
     * 判断是否有网络连接
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager
                    .getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    public <T> void onSub(Observable<T> observable, final ProgressSubscriber<T> progress) {
        if (!isNetworkConnected(mContext)) {
            progress.onError(new APIException(-2,"网络不通，请检查一下网络吧！"));
            progress.onComplete();
            return;
        }
        observable.subscribeOn(Schedulers.io())
                /**
                 * 统一进行以下操作
                 * 在子类使用Observable中的compose操作符，调用，
                 * 完成Observable发布的事件和当前的组件绑定，实现生命周期同步。
                 * 从而实现当前组件生命周期结束时，自动取消对Observable订阅
                 * @auth jiangjiawen
                 * created at
                 */

                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(progress);
    }
}
