package com.example.xingge.mvp_demo.model.biz;

import com.example.xingge.mvp_demo.Utils.OkHttpUtils;
import com.example.xingge.mvp_demo.Utils.Urls;
import com.example.xingge.mvp_demo.model.callback.NetWorkCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xingge on 2017/4/19.
 */

public class NewsModelImpl implements INewsModel {

    @Override
    public void getNewsList(int pageIndex, NetWorkCallBack callBack) {

        Map<String,String> params = new HashMap<>();
        params.put("catalog","1");
        params.put("pageIndex",String.valueOf(pageIndex));
        params.put("pageSize","20");
        OkHttpUtils.getInstance().get(Urls.NEWSLIST,params,callBack);

    }
}
