package com.jinhua.toutiaonews.net.retrofit;

import android.content.Context;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class HttpRetrofit {
    private static volatile HttpRetrofit mHttpRetrofit;
    private GsonConverterFactory gsonConverterFactory;
    private RxJava2CallAdapterFactory rxJava2CallAdapterFactory;
    private static final int CONNECT_TIME = 6_1000; // ms
    private static final int READ_TIME_OUT = 6_1000; // ms
    private static final int WRITE_TIME_OUT = 6_1000; // ms
    private String mBaseUrl;
    private Context context;
    private boolean mInit;
    private int mConnectTimeout;
    private int mReadTimeOut;
    private int mWriteTimeOut;
    private Retrofit retrofit;
    private OkHttpClient mOkHttpClient;
    private ArrayList<Interceptor> mInterceptor = new ArrayList<>();
    private ArrayList<Interceptor> mNetworkInterceptor = new ArrayList<>();

    private final AtomicBoolean mStarted = new AtomicBoolean(false);

    public HttpRetrofit(Context context) {
        this.context = context;
    }

    public static HttpRetrofit getInstance(Context context){
        if(mHttpRetrofit == null){
            synchronized (HttpRetrofit.class){
                if(mHttpRetrofit == null){
                    mHttpRetrofit = new HttpRetrofit(context);
                }
            }
        }
        return mHttpRetrofit;
    }

    public HttpRetrofit initConfig(RetrofitConfig retrofitConfig){
        if(retrofitConfig == null){
            return this;
        }
        synchronized (this){
            if(mInit){
                return this;
            }
        }
        mInit = true;
        mBaseUrl = retrofitConfig.getBaseUrl();
        mConnectTimeout = retrofitConfig.getConnectionTimeout();
        mReadTimeOut = retrofitConfig.getReadTimeout();
        mWriteTimeOut = retrofitConfig.getWriteTimeout();
        return this;
    }


    /**
     * 添加app拦截器
     */
    public HttpRetrofit addInterceptor(Interceptor interceptor){
        mInterceptor.add(interceptor);
        return this;
    }

    /**
     * 添加网络拦截器
     */
    public HttpRetrofit addNetworkInterceptor(Interceptor interceptor){
        mNetworkInterceptor.add(interceptor);
        return this;
    }

    /**
     * application初始化网络组件
     */
    public void startUp() {
        gsonConverterFactory = GsonConverterFactory.create();
        rxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create();
//        if (mStarted.compareAndSet(false, true)) {
            //创建一个Retrofit对象，并且指定api的域名：
        mOkHttpClient = getDefaultHttpClient();
            retrofit = new Retrofit.Builder()
                    .client(mOkHttpClient)
                    .baseUrl(mBaseUrl)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
//        }
    }

    private OkHttpClient getDefaultHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        for (Interceptor interceptor : mInterceptor) {
            builder.addInterceptor(interceptor);
        }
        for (Interceptor interceptor : mNetworkInterceptor) {
            builder.addNetworkInterceptor(interceptor);
        }
        builder.retryOnConnectionFailure(true);
        //time out
        builder.connectTimeout(mConnectTimeout == 0 ? CONNECT_TIME : mConnectTimeout, TimeUnit.MILLISECONDS);
        builder.readTimeout(mReadTimeOut == 0 ? READ_TIME_OUT : mReadTimeOut, TimeUnit.MILLISECONDS);
        builder.writeTimeout(mWriteTimeOut == 0 ? WRITE_TIME_OUT : mWriteTimeOut, TimeUnit.MILLISECONDS);
        return builder.build();
    }

    public <T>T getObj(Class<T> t){
        if(retrofit != null){
            return retrofit.create(t);
        }
        return null;
    }

}
