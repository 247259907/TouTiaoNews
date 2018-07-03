package com.jinhua.toutiaonews.net.net;

import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.jinhua.toutiaonews.net.retrofit.APIException;
import com.jinhua.toutiaonews.net.retrofit.Constants;

import java.io.EOFException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ProgressSubscriber<T> implements Observer<T> {

    private SubscriberOnNextListener mSubscriberOnNextListener;
    private static final int NO_LOGIN = 5;

    public ProgressSubscriber(SubscriberOnNextListener subscriberOnNextListener){
        this.mSubscriberOnNextListener = subscriberOnNextListener;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(Object o) {
        mSubscriberOnNextListener.onSuccess(o);
    }

    @Override
    public void onError(Throwable e) {
        //LogUtils.e(e != null ? ("onError:" + e.getLocalizedMessage()) + "/" + e.getClass().toString() : "onError");
        if (e instanceof SocketTimeoutException) {
            if (mSubscriberOnNextListener != null) {
                mSubscriberOnNextListener.onError(Constants.NET_TIMEOUT, Constants.getMessage(Constants.NET_TIMEOUT));
            }
        } else if (e instanceof ConnectException) {
            if (mSubscriberOnNextListener != null) {
                mSubscriberOnNextListener.onError(Constants.NET_CONNECT_ERROR, Constants.getMessage(Constants.NET_CONNECT_ERROR));
            }
        } else if (e instanceof APIException) {
            if (mSubscriberOnNextListener != null) {
                APIException apiException = (APIException) e;
                int code = apiException.getCode();
                if (code == NO_LOGIN) {
                    return;
                }
                mSubscriberOnNextListener.onError(code, apiException.getMsg());
            }
        } else if (e instanceof JsonSyntaxException) {
            if (mSubscriberOnNextListener != null) {
                mSubscriberOnNextListener.onError(Constants.JSON_SYNTAX_EXCEPTION, Constants.getMessage(Constants.JSON_SYNTAX_EXCEPTION));
            }
        } else if (e instanceof JsonParseException) {
            if (mSubscriberOnNextListener != null) {
                mSubscriberOnNextListener.onError(Constants.JSON_PARSE_EXCEPTION, Constants.getMessage(Constants.JSON_PARSE_EXCEPTION));
            }
        } else if (e instanceof NullPointerException) {
            if (mSubscriberOnNextListener != null) {
                mSubscriberOnNextListener.onError(Constants.OBJECT_NULL, Constants.getMessage(Constants.OBJECT_NULL));
            }
        } else if (e instanceof IllegalArgumentException) {
            if (mSubscriberOnNextListener != null) {
                mSubscriberOnNextListener.onError(Constants.ILLEGAL_PARAMS, Constants.getMessage(Constants.ILLEGAL_PARAMS));
            }
        } else if (e instanceof EOFException) {
            if (mSubscriberOnNextListener != null) {
                mSubscriberOnNextListener.onError(Constants.UNKNOWN, e.getLocalizedMessage());
            }
        } else if (e instanceof IOException) {
            if (mSubscriberOnNextListener != null) {
                mSubscriberOnNextListener.onError(Constants.UNKNOWN, e.getLocalizedMessage());
            }
        } else {
            if (mSubscriberOnNextListener != null) {
                mSubscriberOnNextListener.onError(Constants.UNKNOWN, Constants.getMessage(Constants.UNKNOWN));
            }
        }
    }

    @Override
    public void onComplete() {

    }
}
