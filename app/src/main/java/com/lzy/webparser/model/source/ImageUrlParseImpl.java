package com.lzy.webparser.model.source;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.lzy.webparser.Action;
import com.lzy.webparser.DestoryInterface;
import com.lzy.webparser.Util;
import com.lzy.webparser.model.beans.MainModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;

/**
 * Created by lizhiyun on 2018/4/16.
 */

public class ImageUrlParseImpl implements ImageUrlParse {
    private static volatile ImageUrlParseImpl sInstance;
    RequestCall call = null;
    private ImageUrlParseImpl() {
    }

    public static ImageUrlParse getInstance() {
        if (sInstance == null) {
            synchronized (ImageUrlParseImpl.class) {
                if (sInstance == null) {
                    sInstance = new ImageUrlParseImpl();
                }
            }
        }
        return sInstance;
    }


    @Override
    public void parse(final Context context, MainModel mainModel, final Action<String> action) {
        if (call != null){
            call.cancel();
        }
        call = OkHttpUtils
                .get()
                .addHeader("Mozilla/5.0", "iPhone; CPU iPhone OS 10_3 like Mac OS X")
                .addHeader("AppleWebKit/603.1.30", "KHTML, like Gecko")
                .addHeader("Version", "10.3")
                .addHeader("Mobile", "14E277")
                .addHeader("Safari", "603.1.30")
                .url(mainModel.getWeburl())
                .build();
                call.execute(new StringCallback() {
                    @Override
                    public void onError(okhttp3.Call call, Exception e, int id) {
                        Toast.makeText(context, "请求失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        final String icon = Util.parserIcon(response);
                        action.onAction(icon);
                    }

                });
    }

    @Override
    public void destory() {
        if (call != null){
            call.cancel();
        }
    }
}
