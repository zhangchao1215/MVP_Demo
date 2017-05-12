package com.example.xingge.mvp_demo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.androidkun.PullToRefreshRecyclerView;
import com.example.xingge.mvp_demo.App;
import com.example.xingge.mvp_demo.NewsAdapter;
import com.example.xingge.mvp_demo.R;
import com.example.xingge.mvp_demo.model.entity.NewsListBean;
import com.example.xingge.mvp_demo.prsenter.INewsPresenter;
import com.example.xingge.mvp_demo.prsenter.NewsPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements INewsView {


    @BindView(R.id.mNewsRecyclerView)
    PullToRefreshRecyclerView mNewsRecyclerView;

    private NewsAdapter adapter;
    private INewsPresenter newsPresenter;
    private int pageIndex = 0;
    private List<NewsListBean.NewsBean> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.activity = this;
        ButterKnife.bind(this);
        init();
        loadData();
    }

    private void init(){
        datas = new ArrayList<>();
        newsPresenter = new NewsPresenter(this);
        adapter = new NewsAdapter(this,datas);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mNewsRecyclerView.setLayoutManager(manager);

        mNewsRecyclerView.setAdapter(adapter);
    }

    private void loadData(){
        newsPresenter.loadList(pageIndex);
    }

    @Override
    public void onRefresh(List<NewsListBean.NewsBean> news) {

    }

    @Override
    public void onLoadMore(List<NewsListBean.NewsBean> news) {

    }

    @Override
    public void showListData(List<NewsListBean.NewsBean> news) {

        datas.addAll(news);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showTitleBar(List<Object> titles) {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void dismiss() {

    }

    @Override
    public void showMessage(String msg) {

    }
}
