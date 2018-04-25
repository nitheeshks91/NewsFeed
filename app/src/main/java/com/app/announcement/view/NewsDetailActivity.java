package com.app.announcement.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.app.announcement.R;
import com.app.announcement.common.Constants;
import com.app.announcement.databinding.ActivityNewsDetailsBinding;
import com.app.announcement.model.NewsDetailsModel;
import com.app.announcement.model.NewsInfo;

/**
 * Created by nitheesh on 24/4/18
 */

public class NewsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNewsDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_news_details);
        NewsInfo newsInfo = (NewsInfo) getIntent().getSerializableExtra(Constants.NEWS_INFO);
        binding.setNewsdetailsmodel(new NewsDetailsModel(newsInfo.getAnnouncementHtml().getValue()));
    }
}
