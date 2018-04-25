package com.app.announcement.api;

import com.app.announcement.listener.NewsListActionListener;
import com.app.announcement.model.NewsInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nitheesh on 24/4/18
 */

public class DataManager {
    public void loadData(String url, final NewsListActionListener listener) {
        listener.showProgress();
        ApiService retrofit = ApiModule.getClient().create(ApiService.class);
        Call<List<NewsInfo>> call = retrofit.getAnnouncements(url);
        call.enqueue(new Callback<List<NewsInfo>>() {
            @Override
            public void onResponse(Call<List<NewsInfo>> call, Response<List<NewsInfo>> response) {
                listener.onResponse(response.body());
                listener.hideProgress();
            }

            @Override
            public void onFailure(Call<List<NewsInfo>> call, Throwable t) {
                listener.onFailure();
            }
        });
    }
}
