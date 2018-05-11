package com.lzy.webparser.view;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.bumptech.glide.Glide;

/**
 * Created by lizhiyun on 2018/4/16.
 */
public class BindImageView extends android.support.v7.widget.AppCompatImageView {
    public BindImageView(Context context) {
        super(context);
    }

    public BindImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BindImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @BindingAdapter(value = {"url"})
    public static void setUrl(BindImageView bindImageView,String url){
        Glide.with(bindImageView.getContext()).load(url).into(bindImageView);
    }
}
