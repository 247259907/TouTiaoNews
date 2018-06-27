package com.jinhua.toutiaonews.mvp.presenter;

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
            public void getNetData(MainTestBean mainTestBean) {
                if(getView() != null){
                    getView().getMainNetData(mainTestBean);
                }
            }
        });

    }
}
