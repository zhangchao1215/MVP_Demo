package com.example.xingge.mvp_demo.prsenter;

import com.example.xingge.mvp_demo.model.biz.INewsModel;
import com.example.xingge.mvp_demo.model.biz.NewsModelImpl;
import com.example.xingge.mvp_demo.model.callback.NetWorkCallBack;
import com.example.xingge.mvp_demo.model.entity.NewsListBean;
import com.example.xingge.mvp_demo.view.INewsView;
import com.thoughtworks.xstream.XStream;

/**
 * Created by xingge on 2017/4/19.
 */

public class NewsPresenter implements INewsPresenter {


    private INewsModel newsModel;

    private INewsView newsView;
    public NewsPresenter(INewsView newsView){
        newsModel = new NewsModelImpl();
        this.newsView = newsView;
    }

    @Override
    public void loadList(int pageIndex) {

        newsModel.getNewsList(pageIndex, new NetWorkCallBack() {
            @Override
            public void onSuccess(String xmlData) {
                XStream xStream = new XStream();
                xStream.alias("oschina", NewsListBean.class);
                xStream.alias("news", NewsListBean.NewsBean.class);
                NewsListBean newsListBean = (NewsListBean) xStream.fromXML(xmlData);
                newsView.showListData(newsListBean.getNewslist());
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}
