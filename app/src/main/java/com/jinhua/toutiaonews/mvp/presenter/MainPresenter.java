package com.jinhua.toutiaonews.mvp.presenter;

import com.jinhua.toutiaonews.mvp.base.BasePresenter;
import com.jinhua.toutiaonews.mvp.contract.MainContract;
import com.jinhua.toutiaonews.mvp.model.RequestAction;
import com.jinhua.toutiaonews.mvp.model.TouTiaoModelManager;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter{

//    private MainModel model;
//    public MainPresenter(){
//        this.model = new MainModel();
//    }

    private final TouTiaoModelManager mToutiaoModelManager;

    public MainPresenter(MainContract.View view) {
        mToutiaoModelManager = TouTiaoModelManager.getInstance();
    }

    @Override
    public void getMainNetData() {
//        model.getMainNetData(new MainModel.NetRequestCallBack() {
//            @Override
//            public void getNetData(TestBean mainTestBean) {
//                if(getView() != null){
//                    getView().getMainNetData(mainTestBean);
//                }
//            }
//        });

    }

    @Override
    public void rxjavaTestData() {
        mToutiaoModelManager.getTestData(createProgressSubscriber(RequestAction.RXJAVA_TEST,getView()));
    }


}
