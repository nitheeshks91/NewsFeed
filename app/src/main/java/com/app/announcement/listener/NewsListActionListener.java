package com.app.announcement.listener;

import com.app.announcement.model.NewsInfo;

import java.util.List;

/**
 * Created by nitheesh on 25/4/18.
 */

public interface NewsListActionListener {

    void onClick(NewsInfo newsInfo);

    void onResponse(List<NewsInfo> newsInfos);

    void onFailure();

    void showProgress();

    void hideProgress();
}
