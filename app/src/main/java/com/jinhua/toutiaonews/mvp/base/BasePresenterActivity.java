package com.jinhua.toutiaonews.mvp.base;

import android.support.v4.app.FragmentActivity;

public abstract class BasePresenterActivity<V,T extends BasePresenter<V>> extends FragmentActivity implements BaseContract.BaseView {

}
