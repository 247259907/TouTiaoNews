package com.jinhua.toutiaonews.ui.activity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.jinhua.toutiaonews.R;
import com.jinhua.toutiaonews.mvp.base.BasePresenterActivity;
import com.jinhua.toutiaonews.mvp.contract.MainContract;
import com.jinhua.toutiaonews.mvp.model.bean.TestBean;
import com.jinhua.toutiaonews.mvp.presenter.MainPresenter;
import com.jinhua.toutiaonews.mvp.model.RequestAction;

public class MainActivity extends BasePresenterActivity<MainContract.View,MainPresenter> implements MainContract.View {

    private TextView mMainTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        initView();
    }


    public void getData(){
        getPresenter().rxjavaTestData();
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter(this);
    }


    public void initView(){
        mMainTv = findViewById(R.id.main_tv);
    }

    @Override
    public void getMainNetData(TestBean mainTestBean) {
//        mMainTv.setText(mainTestBean.getContent().getFrom());
    }

    @Override
    public void onSuccess(Object var1, Object var2) {
        if(var1 == RequestAction.RXJAVA_TEST){
            mMainTv.setText(((TestBean) var2).getContent().getFrom());
        }
    }

    @Override
    public void onError(Object var1, int var2, String var3) {
        if (var1 == RequestAction.RXJAVA_TEST){
            Toast.makeText(this,var2+var3,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStartUp(Object var1) {

    }

    @Override
    public void onCompleted(Object var1) {

    }

    @Override
    public void showLoading(boolean var1) {

    }
}


