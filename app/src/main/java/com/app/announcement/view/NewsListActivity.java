package com.app.announcement.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.app.announcement.R;
import com.app.announcement.adapter.NewsListRecyclerAdapter;
import com.app.announcement.api.DataManager;
import com.app.announcement.common.Constants;
import com.app.announcement.databinding.ActivityNewsListBinding;
import com.app.announcement.listener.NewsListActionListener;
import com.app.announcement.model.NewsInfo;
import com.app.announcement.model.NewsListModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nitheesh on 24/4/18
 */

public class NewsListActivity extends AppCompatActivity implements NewsListActionListener {

    @BindView(R.id.rv_news)
    RecyclerView newsRv;

    private NewsListModel newsListModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNewsListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_news_list);
        newsListModel = new NewsListModel();
        ButterKnife.bind(this);
        binding.setNewslistmodel(newsListModel);

        DataManager dataManager = new DataManager();
        dataManager.loadData(getString(R.string.news_url), this);
    }

    @Override
    public void onResponse(List<NewsInfo> newsInfos) {
        newsRv.setLayoutManager(new LinearLayoutManager(this));
        NewsListRecyclerAdapter adapter = new NewsListRecyclerAdapter(newsInfos, this);
        newsRv.setAdapter(adapter);
    }

    @Override
    public void onFailure() {
        newsListModel.setLoadingstate(Constants.FAILURE_PROGRESS);
        newsListModel.setHideInitialContentView(false);
    }

    @Override
    public void onClick(NewsInfo newsInfo) {
        Intent intent = new Intent(this, NewsDetailActivity.class);
        intent.putExtra(Constants.NEWS_INFO, newsInfo);
        startActivity(intent);
    }

    @Override
    public void showProgress() {
        newsListModel.setLoadingstate(Constants.START_PROGRESS);
    }

    @Override
    public void hideProgress() {
        newsListModel.setLoadingstate(Constants.STOP_PROGRESS);
        newsListModel.setHideInitialContentView(false);
    }
}
