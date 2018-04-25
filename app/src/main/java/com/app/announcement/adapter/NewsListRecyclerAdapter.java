package com.app.announcement.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.announcement.BR;
import com.app.announcement.R;
import com.app.announcement.listener.NewsListActionListener;
import com.app.announcement.model.NewsInfo;

import java.util.List;

/**
 * Adapter class to bind the news list.
 *
 * Created by nitheesh on 24/4/18
 */

public class NewsListRecyclerAdapter extends RecyclerView.Adapter<NewsListRecyclerAdapter.BindingHolder> {

    private final List<NewsInfo> newsInfos;
    private final NewsListActionListener actionListener;

    public NewsListRecyclerAdapter(List<NewsInfo> newsInfos, NewsListActionListener actionListener) {
        this.newsInfos = newsInfos;
        this.actionListener = actionListener;
    }

    static class BindingHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        BindingHolder(View v) {
            super(v);
            binding = DataBindingUtil.bind(v);
        }

        ViewDataBinding getBinding() {
            return binding;
        }
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.announcement_list_item, parent, false);
        return new BindingHolder(v);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        final NewsInfo newsInfo = newsInfos.get(position);
        holder.getBinding().setVariable(BR.newsInfo, newsInfo);
        holder.getBinding().setVariable(BR.actionListener, actionListener);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return this.newsInfos != null ? this.newsInfos.size() : 0;
    }

}
