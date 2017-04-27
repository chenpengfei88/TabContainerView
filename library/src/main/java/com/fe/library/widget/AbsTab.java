package com.fe.library.widget;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import com.fe.library.listener.OnTabSelectedListener;

/**
 * Created by chenpengfei on 2017/4/27.
 */
public abstract class AbsTab {

    /**
     *  tab选中监听
     */
    OnTabSelectedListener onTabSelectedListener;

    protected Context mContext;
    private int mIndex;
    private View mRootView;
    protected boolean mIsSelected;

    public AbsTab(Context context, int index) {
        mContext = context;
        mIndex = index;
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
     * 是否选中tab
     * @param isSelected
     */
    protected abstract void tabSelected(boolean isSelected);

    /**
     *  显示消息提示
     * @param show 是否显示
     * @param count 显示数量
     */
    public abstract void showMessageTip(boolean show, int count);

    protected abstract void initView(View rootView);

    /**
     *  初始化view
     * @param tab
     * @param layoutResId
     * @return
     */
    protected void inflaterView(final AbsTab tab, @LayoutRes int layoutResId) {
        mRootView = LayoutInflater.from(mContext).inflate(layoutResId, null);
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
}
