package com.lzy.webparser.model.source;

import android.content.Context;

import com.lzy.webparser.Action;
import com.lzy.webparser.DestoryInterface;
import com.lzy.webparser.model.beans.MainModel;

/**
 * Created by lizhiyun on 2018/4/16.
 */

public interface ImageUrlParse extends DestoryInterface {
    void parse(Context context,MainModel mainModel, Action<String> action);
}
