package com.app.announcement.api;

import com.app.announcement.model.NewsInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by nitheesh on 24/4/18
 */

public interface ApiService {
    @GET
    Call<List<NewsInfo>> getAnnouncements(@Url String url);
}
