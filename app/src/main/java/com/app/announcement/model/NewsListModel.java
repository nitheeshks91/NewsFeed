package com.app.announcement.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.app.announcement.BR;

/**
 * Created by nitheesh on 25/4/18.
 */

public class NewsListModel extends BaseObservable {
    private boolean hideInitialContentView = true;
    private int loadingstate = 1;

    @Bindable
    public int getLoadingstate() {
        return loadingstate;
    }

    public void setLoadingstate(int loadingstate) {
        this.loadingstate = loadingstate;
        notifyPropertyChanged(BR.loadingstate);
    }

    @Bindable
    public boolean getHideInitialContentView() {
        return hideInitialContentView;
    }

    public void setHideInitialContentView(boolean hideInitialContentView) {
        this.hideInitialContentView = hideInitialContentView;
        notifyPropertyChanged(BR.hideInitialContentView);
    }
}
