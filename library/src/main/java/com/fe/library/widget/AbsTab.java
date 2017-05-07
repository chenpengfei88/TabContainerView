package com.fe.library.widget;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.fe.library.listener.OnTabSelectedListener;

/**
 * Created by chenpengfei on 2017/4/27.
 */
public abstract class AbsTab {

    protected Context mContext;
    /**
     *  Tab在TabHost中的位置，属于第mIndex个
     */
    private int mIndex;

    /**
     *  Tab类的资源View布局
     */
    private View mRootView;

    /**
     *  当前Tab是否选中
     */
    protected boolean mIsSelected;

    /**
     *  Tab选中监听
     */
    private OnTabSelectedListener onTabSelectedListener;

    public AbsTab(Context context, int index) {
        mContext = context;
        mIndex = index;
    }

    /**
     *  初始化View资源，得到RootView，并添加响应事件
     * @param tab
     * @param layoutResId
     * @return
     */
    protected void inflaterView(final AbsTab tab, @LayoutRes int layoutResId) {
        mRootView = LayoutInflater.from(mContext).inflate(layoutResId, null);
        LinearLayout.LayoutParams rootViewLp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rootViewLp.weight = 1;
        mRootView.setLayoutParams(rootViewLp);

        initView(mRootView);
        mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTabSelectedListener != null) {
                    onTabSelectedListener.onTabSelected(tab);
                }
            }
        });
    }

    /**
     *  设置选中监听
     * @param onTabSelectedListener
     */
    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.onTabSelectedListener = onTabSelectedListener;
    }



    /**
     *  得到Tab 的RootView
     * @return  View
     */
    public View getTabRootView() {
        return mRootView;
    }

    /**
     *  得到Tab Index
     * @return int
     */
    public int getTabIndex() {
        return  mIndex;
    }

    /**
     *  显示消息提示
     * @param show 是否显示
     * @param count 显示数量
     */
    public void showMessageTip(boolean show, int count) {};

    /**
     * 是否选中该Tab
     * @param isSelected
     */
    protected abstract void tabSelected(boolean isSelected);

    /**
     *  初始化RootView里的布局
     * @param rootView
     */
    protected abstract void initView(View rootView);
}
