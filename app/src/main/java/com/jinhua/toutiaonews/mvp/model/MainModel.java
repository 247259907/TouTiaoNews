package com.jinhua.toutiaonews.mvp.model;

import com.jinhua.toutiaonews.mvp.contract.MainContract;
import com.jinhua.toutiaonews.mvp.model.bean.TestBean;
import com.jinhua.toutiaonews.net.NetHelper;

public class MainModel implements MainContract.Model {

    public MainModel(){

    }

    @Override
    public void getMainNetData(final NetRequestCallBack callBack) {
        NetHelper.getNetData(new NetHelper.MainDataCallBack() {
            @Override
            public void mainData(TestBean mainTestBean) {
                callBack.getNetData(mainTestBean);
            }
        });
    }



    public interface  NetRequestCallBack{
        void getNetData(TestBean mainTestBean);
    }
}
