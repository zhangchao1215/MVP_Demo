package com.example.xingge.mvp_demo.model.biz;

import com.example.xingge.mvp_demo.model.callback.NetWorkCallBack;

/**
 * Created by xingge on 2017/4/19.
 */

public interface INewsModel {

    void getNewsList(int pageIndex, NetWorkCallBack callBack);

}
