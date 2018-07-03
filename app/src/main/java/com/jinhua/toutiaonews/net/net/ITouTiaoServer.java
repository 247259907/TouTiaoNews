package com.jinhua.toutiaonews.net.net;

import com.jinhua.toutiaonews.mvp.model.bean.TestBean;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ITouTiaoServer {

    /**
     * 获取测试数据
     * @return
     */
    @GET("http://fy.iciba.com/ajax.php?a=fy&f=auto&t=auto&w=hi%20login")
    Observable<TestBean> getTestData();
}
