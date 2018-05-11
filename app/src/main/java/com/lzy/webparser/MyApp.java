package com.lzy.webparser;

import android.app.Application;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import lzy.com.life_library.utils.LifeUtil;
import okhttp3.OkHttpClient;

/**
 * Created by lizhiyun on 2018/4/16.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LifeUtil.init(this);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }
}
