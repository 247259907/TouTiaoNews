package com.jinhua.toutiaonews.net;

import com.jinhua.toutiaonews.mvp.model.bean.TestBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiHelper {

    @GET("ajax.php?a=fy&f=auto&t=auto&w=hi%20login")
    Observable<TestBean> onResult();

}
