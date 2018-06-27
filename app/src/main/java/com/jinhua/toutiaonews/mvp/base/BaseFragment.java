package com.jinhua.toutiaonews.mvp.base;

import android.content.Context;
import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment {

    private BasePresenterActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (BasePresenterActivity)context;
    }
}
