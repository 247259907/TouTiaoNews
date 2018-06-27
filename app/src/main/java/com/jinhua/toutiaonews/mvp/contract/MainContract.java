package com.jinhua.toutiaonews.mvp.contract;

import com.jinhua.toutiaonews.mvp.base.BaseContract;
import com.jinhua.toutiaonews.mvp.model.MainModel;
import com.jinhua.toutiaonews.mvp.model.bean.MainTestBean;

public interface MainContract {
    interface View extends BaseContract.BaseView{
        void getMainNetData(MainTestBean mainTestBean);
    }

    interface Presenter {
        void getMainNetData();
    }

    interface Model {
        void getMainNetData(MainModel.NetRequestCallBack callBack);
    }
}
