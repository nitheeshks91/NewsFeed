package com.app.announcement.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.app.announcement.BR;
import com.app.announcement.R;
import com.app.announcement.adapter.NewsListRecyclerAdapter;
import com.app.announcement.model.DataManager;
import com.app.announcement.common.Constants;
import com.app.announcement.databinding.ActivityNewsListBinding;
import com.app.announcement.view.listener.NewsListActionListener;
import com.app.announcement.model.NewsInfo;
import com.app.announcement.view.model.NewsListModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * News List Activity which display lists of announcements
 * <p>
 * Created by nitheesh on 24/4/18
 */

public class NewsListActivity extends AppCompatActivity implements NewsListActionListener {

    @BindView(R.id.rv_news)
    RecyclerView newsRv;

    private NewsListModel newsListModel;
    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNewsListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_news_list);
        newsListModel = new NewsListModel();
        ButterKnife.bind(this);
        binding.setNewslistmodel(newsListModel);
        binding.setVariable(BR.listener, this);

        dataManager = new DataManager();
        requestData();
    }

    private void requestData() {
        dataManager.loadData(getString(R.string.news_url), this);
    }

    @Override
    public void onResponse(List<NewsInfo> newsInfos) {
        newsRv.setLayoutManager(new GridLayoutManager(this, 2));
        NewsListRecyclerAdapter adapter = new NewsListRecyclerAdapter(newsInfos, this);
        newsRv.setAdapter(adapter);
    }

    @Override
    public void onFailure(String cause) {
        newsListModel.setLoadingstate(Constants.FAILURE_PROGRESS);
        newsListModel.setHideInitialContentView(false);
        newsListModel.setErrorview(true);
        if (cause.contains(getString(R.string.retrofit_network_error))) {
            newsListModel.setNetworkError(true);
            newsListModel.setErrorMessage(getString(R.string.network_error_message));
        } else {
            newsListModel.setInternalError(true);
            newsListModel.setErrorMessage(getString(R.string.internal_error_message));
        }
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

    @Override
    public void onErrorActionClick(NewsListModel newsListModel) {
        if (newsListModel.isInternalError()) {
            this.finish();
        } else {
            newsListModel.setErrorview(false);
            requestData();
        }
    }


}
