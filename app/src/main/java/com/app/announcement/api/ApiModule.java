package com.app.announcement.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nitheesh on 24/4/18
 */


class ApiModule {

    static Retrofit getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .addInterceptor(interceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://94.56.199.34")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        return retrofit;
    }
}
