package com.example.xingge.mvp_demo.view;

import com.example.xingge.mvp_demo.model.entity.NewsListBean;

import java.util.List;

/**
 * Created by xingge on 2017/4/19.
 */

public interface INewsView {

    /**
     * 下拉刷新
     * @param news
     */
    void onRefresh(List<NewsListBean.NewsBean> news);

    /**
     * 加载更多
     */
    void onLoadMore(List<NewsListBean.NewsBean> news);

    /**
     * 初始化ListView的数据
     */
    void showListData(List<NewsListBean.NewsBean> news);

    /**
     * 显示标题
     * @param titles
     */
    void showTitleBar(List<Object> titles);

    /**
     * 显示进度条
     */
    void showProgressBar();

    /**
     * 关闭等待框
     */
    void dismiss();

    /**
     * Toast显示信息
     * @param msg
     */
    void showMessage(String msg);


}
