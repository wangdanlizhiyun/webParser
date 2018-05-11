package com.lzy.webparser.viewmodel;

import android.app.Activity;
import android.app.Fragment;
import android.databinding.BaseObservable;

import com.lzy.webparser.DestoryInterface;

import lzy.com.life_library.listener.LifeCycleListener;
import lzy.com.life_library.utils.LifeUtil;

/**
 * Created by lizhiyun on 2018/4/16.
 */

public class BaseViewModel extends BaseObservable implements DestoryInterface {

    Object host;
    public void with(Activity activity){
        host = activity;
        LifeUtil.addLifeCycle(activity, new LifeCycleListener() {
            @Override
            public void onStart() {

            }

            @Override
            public void onResume() {

            }

            @Override
            public void onPause() {

            }

            @Override
            public void onStop() {

            }

            @Override
            public void onDestory() {
                destory();
            }
        });
    }
    public void with(Fragment fragment){
        host = fragment;
        LifeUtil.addLifeCycle(fragment, new LifeCycleListener() {
            @Override
            public void onStart() {

            }

            @Override
            public void onResume() {

            }

            @Override
            public void onPause() {

            }

            @Override
            public void onStop() {

            }

            @Override
            public void onDestory() {
                destory();
            }
        });
    }

    //其它context需要自行处理
    @Override
    public void destory() {

    }
}
