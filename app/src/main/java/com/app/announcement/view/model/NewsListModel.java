package com.app.announcement.view.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.app.announcement.BR;

/**
 * Model class which provides data to News List Activity.
 *
 * Created by nitheesh on 25/4/18
 */

public class NewsListModel extends BaseObservable {
    private boolean hideInitialContentView = true;
    private int loadingstate = 1;
    private boolean networkError = false;
    private boolean internalError = false;
    private String errorMessage;

    private boolean errorview;

    @Bindable
    public boolean isErrorview() {
        return errorview;
    }

    public void setErrorview(boolean errorview) {
        this.errorview = errorview;
        notifyPropertyChanged(BR.errorview);
    }

    @Bindable
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        notifyPropertyChanged(BR.errorMessage);
    }


    @Bindable
    public boolean isInternalError() {
        return internalError;
    }

    public void setInternalError(boolean internalError) {
        this.internalError = internalError;
        notifyPropertyChanged(BR.internalError);
    }

    @Bindable
    public boolean isNetworkError() {
        return networkError;
    }

    public void setNetworkError(boolean networkError) {
        this.networkError = networkError;
        notifyPropertyChanged(BR.networkError);
    }

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
