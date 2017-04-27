package com.fe.library.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
    private LinearLayout mRootView;
    //tab集合
    private List<AbsTab> tabList = new ArrayList<>();
    private ViewPager contentViewPager;


    public TabHost(Context context) {
        this.mContext = context;

        initView();
    }

    /**
     *  初始化View
     */
    private void initView() {
        mRootView = new LinearLayout(mContext);
        mRootView.setOrientation(LinearLayout.HORIZONTAL);
        mRootView.setId(R.id.linearlayout_tab);

        RelativeLayout.LayoutParams rootViewLp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rootViewLp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        mRootView.setLayoutParams(rootViewLp);
    }

    private void addTab(AbsTab tab) {
        if (tab == null) return;
        tabList.add(tab);

        View tabRootView = tab.getTabRootView();
        mRootView.addView(tabRootView);

        addTabChangeListener(tab);
    }

    /**
     *  得到index位置的tab
     * @param index
     * @return
     */
    public AbsTab getTabForIndex(int index) {
        if (tabList.size() <= index) {
            return null;
        }
        return tabList.get(index);
    }

    public void addTabs(BaseAdapter baseAdapter) {
        int count = baseAdapter.getCount();

        if (count == 0) return;

        for (int i = 0; i < count; i++) {
            addTab(baseAdapter.getTab(i));
        }
    }

    public void setContentViewPager(ViewPager contentViewPager) {
        this.contentViewPager = contentViewPager;
    }

    public LinearLayout getRootView() {
        return mRootView;
    }

    private void addTabChangeListener(AbsTab tab) {
        tab.setOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(AbsTab tab) {
                contentViewPager.setCurrentItem(tab.getTabIndex(), false);
            }
        });
    }

    /**
     *  改变tabHost状态
     */
    public void onChangeTabHostStatus(int index) {
        for (int i = 0, size = tabList.size(); i < size; i++) {
            AbsTab tab = tabList.get(i);
            tab.tabSelected(index == i ? true : false);
        }
    }



}
