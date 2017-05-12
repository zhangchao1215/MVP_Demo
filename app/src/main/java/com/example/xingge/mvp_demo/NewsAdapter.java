package com.example.xingge.mvp_demo;

import android.content.Context;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.example.xingge.mvp_demo.model.entity.NewsListBean;

import java.util.List;

/**
 * Created by xingge on 2017/4/19.
 */

public class NewsAdapter extends BaseAdapter<NewsListBean.NewsBean> {

    public NewsAdapter(Context context, List<NewsListBean.NewsBean> datas) {
        super(context, R.layout.news_listview_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, NewsListBean.NewsBean newsBean) {

        holder.setText(R.id.newsTitleTv,newsBean.getTitle());
    }
}
