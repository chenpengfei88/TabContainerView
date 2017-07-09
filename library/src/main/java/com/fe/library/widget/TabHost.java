package com.fe.library.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.fe.library.TabContainerView;
import com.fe.library.adapter.BaseAdapter;
import com.fe.library.listener.OnTabSelectedListener;
import java.util.ArrayList;
import java.util.List;
import fe.library.R;

/**
 * Created by chenpengfei on 2017/3/21.
 */
public class TabHost {

    private Context mContext;

    /**
     *  Host是否在顶部
     */
    private boolean mHostTop;

    /**
     *  Host Layout
     */
    private LinearLayout mHostView;

    /**
     * tab集合
     */
    private List<AbsTab> mTabList = new ArrayList<>();

    /**
     *  content viewPager
     */
    private ViewPager mContentViewPager;

    /**
     *  Top Host 布局类
     */
    private TabHostTopLayout mTopHostLayout;


    public TabHost(Context context, boolean hostTop) {
        this.mContext = context;
        this.mHostTop = hostTop;

        //Tab在顶部
        if (mHostTop) {
            initTopView();
        } else {
            initBottomView();
        }
    }

    /**
     *  初始化底部View
     */
    private void initBottomView() {
        mHostView = new LinearLayout(mContext);
        mHostView.setOrientation(LinearLayout.HORIZONTAL);
        mHostView.setId(R.id.linearlayout_tab);

        RelativeLayout.LayoutParams rootViewLp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rootViewLp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        mHostView.setLayoutParams(rootViewLp);
    }

    /**
     *  初始化顶部View
     */
    private void initTopView() {
        mTopHostLayout = new TabHostTopLayout(mContext);
        mTopHostLayout.setHorizontalScrollBarEnabled(false);
        mTopHostLayout.setFillViewport(true);
        mTopHostLayout.setId(R.id.linearlayout_tab);

        RelativeLayout.LayoutParams rootViewLp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mTopHostLayout.setLayoutParams(rootViewLp);

        mHostView = mTopHostLayout.getHostView();
    }

    public void setContentViewPager(ViewPager contentViewPager) {
        this.mContentViewPager = contentViewPager;
    }

    public View getRootLayout() {
        if (mHostTop) {
            return mTopHostLayout;
        }
        return mHostView;
    }

    public void addTabs(BaseAdapter baseAdapter) {
        int count = baseAdapter.getCount();
        if (count == 0) return;

        mTabList.clear();
        mHostView.removeAllViews();

        for (int i = 0; i < count; i++) {
            addTab(baseAdapter.getTab(i));
        }
    }

    /**
     *  tabHost 添加tab
     * @param tab
     */
    private void addTab(AbsTab tab) {
        if (tab == null) return;

        mTabList.add(tab);
        mHostView.addView(tab.getTabRootView());
        tabAddSelectedListener(tab);
    }

    private void tabAddSelectedListener(AbsTab tab) {
        tab.setOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(AbsTab tab) {
                mContentViewPager.setCurrentItem(tab.getTabIndex(), false);
            }
        });
    }

    /**
     *  得到index位置的tab
     * @param index
     * @return
     */
    public AbsTab getTabForIndex(int index) {
        if (mTabList.size() <= index) {
            return null;
        }
        return mTabList.get(index);
    }

    /**
     *  改变tabHost状态
     */
    public void changeTabHostStatus(int index) {
        for (int i = 0, size = mTabList.size(); i < size; i++) {
            AbsTab tab = mTabList.get(i);
            tab.tabSelected(index == i ? true : false);
        }
    }

    /**
     *  Tab 设置背景颜色
     * @param bgColor
     */
    public void setTabBgColor(int bgColor) {
        for (int i = 0, size = mTabList.size(); i < size; i++) {
            AbsTab tab = mTabList.get(i);
            tab.getTabRootView().setBackgroundColor(bgColor);
        }
    }


    public boolean isTop() {
        return mHostTop;
    }

    public int getTabWidth() {
        if (mHostView == null) return 0;

        return mHostView.getChildAt(0).getMeasuredWidth();
    }

}
