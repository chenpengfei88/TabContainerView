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
     *  tab index 位置
     */
    private int mIndex;
    private View mRootView;
    /**
     *  table 当前是否选中
     */
    protected boolean mIsSelected;

    /**
     *  tab选中监听
     */
    private OnTabSelectedListener onTabSelectedListener;

    public AbsTab(Context context, int index) {
        mContext = context;
        mIndex = index;
    }

    /**
     *  初始化view
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
     *  得到Tab 的rootView
     * @return  View
     */
    public View getTabRootView() {
        return mRootView;
    }

    /**
     *  得到tab index
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
     * 是否选中tab
     * @param isSelected
     */
    protected abstract void tabSelected(boolean isSelected);



    protected abstract void initView(View rootView);


}
