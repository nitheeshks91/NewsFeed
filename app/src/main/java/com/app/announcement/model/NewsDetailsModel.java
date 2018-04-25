package com.app.announcement.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.app.announcement.BR;

/**
 * Created by nitheesh on 25/4/18
 */

public class NewsDetailsModel extends BaseObservable {

    private String newsContent;

    public NewsDetailsModel(String newsContent) {
        setNewsContent(newsContent);
    }

    @Bindable
    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
        notifyPropertyChanged(BR.newsContent);
    }
}
