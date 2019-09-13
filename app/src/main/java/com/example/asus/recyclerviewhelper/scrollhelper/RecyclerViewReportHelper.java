package com.example.asus.recyclerviewhelper.scrollhelper;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

/**
 * create by hanking on 2019/9/13
 * <p>
 * recyclerView 滑动帮助类，监听recyclerView的滑动事件，可以作为数据上报类
 */
public abstract class RecyclerViewReportHelper {
    private OnScrollListener mOnScrollListener;
    private DataObserver mDataObserver;

    public RecyclerViewReportHelper() {
        this.mOnScrollListener = new OnScrollListener();
        this.mDataObserver = new DataObserver();
    }

    public void addOnScrollListener(RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(mOnScrollListener);

    }

    public void addAdapterDataObserver(RecyclerView.Adapter adapter) {
        adapter.registerAdapterDataObserver(mDataObserver);
    }

    class OnScrollListener extends RecyclerView.OnScrollListener {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            tryReport();
        }
    }

    class DataObserver extends RecyclerView.AdapterDataObserver {
        @Override
        public void onChanged() {
            super.onChanged();
            tryReport();
        }
    }

    /**
     * 尝试上报
     */
    private void tryReport() {
        onReport();
    }

    public abstract void onReport();
}
