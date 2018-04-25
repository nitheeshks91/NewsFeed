package com.app.announcement.adapter;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.app.announcement.R;
import com.app.announcement.customview.AnimatedCircleLoadingView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

/**
 * Custom binding adapter class used to define binding fields
 *
 * Created by nitheesh on 25/4/18
 */

public class CustomBindingAdapter {

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String url) {
        url = url.replace("HTTP", "http");
        Glide.with(view.getContext())
                .load(url)
                .asBitmap()
                .override(1000, 800)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.no_image)
                .into(new BitmapImageViewTarget(view) {
                    @Override
                    public void onResourceReady(Bitmap drawable, GlideAnimation anim) {
                        super.onResourceReady(drawable, anim);
                    }
                });
    }

    @BindingAdapter({"loadHtml"})
    public static void loadHtml(WebView view, String htmlContent) {
        view.loadData(htmlContent, "text/html; charset=utf-8", "UTF-8");
    }

    @BindingAdapter({"toggleVisibility"})
    public static void hideView(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter({"setProgress"})
    public static void setProgressState(AnimatedCircleLoadingView view, int value) {
        switch (value) {
            case 1:
                view.setVisibility(View.VISIBLE);
                view.restartDeterminate();
                break;
            case 2:
                view.stopFailure();
                break;
            case 3:
                view.stopOk();
                view.setVisibility(View.GONE);
                break;
            case 4:
                view.setVisibility(View.VISIBLE);
                view.restartDeterminate();
                break;
        }
    }
}
