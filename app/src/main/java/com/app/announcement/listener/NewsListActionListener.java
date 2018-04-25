package com.app.announcement.listener;

import com.app.announcement.model.NewsInfo;
import com.app.announcement.model.NewsListModel;

import java.util.List;

/**
 * Listener which communicates between view and model
 *
 * Created by nitheesh on 25/4/18
 */

public interface NewsListActionListener {

    void onClick(NewsInfo newsInfo);

    void onResponse(List<NewsInfo> newsInfos);

    void onFailure(String cause);

    void showProgress();

    void hideProgress();

    void onErrorActionClick(NewsListModel newsListModel);
}
