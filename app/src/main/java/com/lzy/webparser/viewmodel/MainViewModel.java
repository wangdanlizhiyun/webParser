package com.lzy.webparser.viewmodel;

import android.content.Context;
import android.databinding.Bindable;
import android.databinding.InverseBindingAdapter;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.lzy.webparser.Action;
import com.lzy.webparser.BR;
import com.lzy.webparser.annotation.AntiShake;
import com.lzy.webparser.model.beans.MainModel;
import com.lzy.webparser.model.source.ImageUrlParse;
import com.lzy.webparser.model.source.ImageUrlParseImpl;

/**
 * Created by lizhiyun on 2018/4/16.
 */

public class MainViewModel extends BaseViewModel {
    private MainModel mMainModel;
    private Context mContext;
    ImageUrlParse mImageUrlParse;
    public MainViewModel(MainModel mainModel, Context context) {
        this.mMainModel = mainModel;
        this.mContext = context;
        mImageUrlParse = ImageUrlParseImpl.getInstance();
    }

    public String getWeburl() {
        return mMainModel == null ? "" : mMainModel.getWeburl();
    }

    @Bindable
    public String getImageurl() {
        return mMainModel == null ? "" : mMainModel.getImageurl();
    }

    @Bindable
    public void setWeburl(String weburl) {
        if (mMainModel != null) {
            mMainModel.setWeburl(weburl);
        }
    }

    public void setImageurl(String imageurl) {
        if (mMainModel != null) {
            mMainModel.setImageurl(imageurl);
            notifyPropertyChanged(BR.imageurl);
        }
    }

    public View.OnClickListener onClickParse() {
        return new View.OnClickListener() {

            @AntiShake(intervalTime = 400)
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(mMainModel.getWeburl())) {
                    setImageurl("");
                    mImageUrlParse.parse(mContext, mMainModel, new Action<String>() {
                        @Override
                        public void onAction(String s) {
                            if (TextUtils.isEmpty(s)) {
                                Toast.makeText(mContext, "没有匹配图片", Toast.LENGTH_SHORT).show();
                                setImageurl("");
                            } else {
                                String imgUrl = s;
                                if (!imgUrl.startsWith("http")) {
                                    imgUrl = "http:" + imgUrl;
                                }
                                setImageurl(imgUrl);
                            }
                        }
                    });
                } else {
                    Toast.makeText(mContext, "请输入有效地址", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    @Override
    public void destory() {
        super.destory();
        mImageUrlParse.destory();
    }
}
