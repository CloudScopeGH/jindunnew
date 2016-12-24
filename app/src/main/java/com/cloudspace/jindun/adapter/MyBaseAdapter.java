package com.cloudspace.jindun.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Cloud(32325596@qq.com)
 * Date: 2016-12-23
 * Time: 14:54
 * project: jindunaaa
 * Describe
 */
public abstract class MyBaseAdapter<T> extends BaseAdapter {
    private List<T> mData;
    private LayoutInflater mInflater;
    private Context mContext;

    public Context getContext() {
        return mContext;
    }

    public MyBaseAdapter(Context context) {
        mData = new ArrayList<>();
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }
    public LayoutInflater getInflater() {
        return mInflater;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    /**
     * 添加集合
     */
    public void addAll(List<T> data) {
        mData.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * 清除集合
     */
    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }

}
