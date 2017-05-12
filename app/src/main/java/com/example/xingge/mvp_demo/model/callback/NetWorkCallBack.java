package com.example.xingge.mvp_demo.model.callback;

/**
 * Created by xingge on 2017/4/19.
 */

public interface NetWorkCallBack {

    void onSuccess(String xmlData);

    void onError(String errorMsg);
}
