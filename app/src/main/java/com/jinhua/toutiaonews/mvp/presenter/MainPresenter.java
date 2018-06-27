package com.jinhua.toutiaonews.mvp.presenter;

import android.util.Log;

import com.jinhua.toutiaonews.mvp.base.BasePresenter;
import com.jinhua.toutiaonews.mvp.contract.MainContract;
import com.jinhua.toutiaonews.mvp.model.MainModel;
import com.jinhua.toutiaonews.mvp.model.bean.MainTestBean;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter{

    private MainModel model;

    public MainPresenter(){
        this.model = new MainModel();
    }

    @Override
    public void getMainNetData() {
        model.getMainNetData(new MainModel.NetRequestCallBack() {
            @Override
            public void getNetData(String mainTestBean) {
                if(getView() != null){
                    Log.e("main--->presenter",mainTestBean.toString());

                    getView().getMainNetData(mainTestBean);
                }
            }
        });

    }
}
