package com.jinhua.toutiaonews.mvp.contract;

import com.jinhua.toutiaonews.mvp.base.BaseContract;
import com.jinhua.toutiaonews.mvp.model.MainModel;
import com.jinhua.toutiaonews.mvp.model.bean.TestBean;

public interface MainContract {
    interface View extends BaseContract.BaseView{
        void getMainNetData(TestBean mainTestBean);
    }

    interface Presenter {
        void getMainNetData();
        void rxjavaTestData();
    }

    interface Model {
        void getMainNetData(MainModel.NetRequestCallBack callBack);

    }
}
