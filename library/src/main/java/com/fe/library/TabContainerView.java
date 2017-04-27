package com.fe.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.fe.library.adapter.BaseAdapter;
import com.fe.library.adapter.TabViewPagerAdapter;
import com.fe.library.listener.OnTabSelectedListener;
import com.fe.library.widget.AbsTab;
import com.fe.library.widget.TabHost;
import fe.library.R;

/**
 * Created by chenpengfei on 2017/3/21.
 */
public class TabContainerView extends RelativeLayout {

    /**
     *  中间ViewPager
     */
    private ViewPager mContentViewPager;

    /**
     *  分割线
     */
    private int mDivideLineColor;
    private int mDivideLineHeight;

    /**
     *  底部TabLayout
     */
    private TabHost mTabHost;

    /**
     *  选中监听
     */
    private OnTabSelectedListener mOnTabSelectedListener;


    public TabContainerView(Context context) {
        super(context);
    }

    public TabContainerView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs);
    }

    public TabContainerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TabContainerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(context, attrs);
    }

    /**
     *  初始化UI
     * @param context
     * @param attrs
     */
    private void init(Context context, AttributeSet attrs) {
        initStyle(context, attrs);
        initTabHost(context);
        initDivideLine(context);
        initViewPager(context);

        mTabHost.setContentViewPager(mContentViewPager);
    }

    private void initStyle(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TabContainerViewStyle);
        mDivideLineColor = typedArray.getColor(R.styleable.TabContainerViewStyle_divideLineColor, Color.BLACK);
        mDivideLineHeight = typedArray.getInt(R.styleable.TabContainerViewStyle_divideLineHeight, 2);

        typedArray.recycle();
    }


    private void initTabHost(Context context) {
        mTabHost = new TabHost(context);
        addView(mTabHost.getRootView());
    }

    private void initDivideLine(Context context) {
        View divideLine = new View(context);
        divideLine.setId(R.id.divide_tab);
        divideLine.setBackgroundColor(mDivideLineColor);

        LayoutParams lineLp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mDivideLineHeight);
        lineLp.addRule(RelativeLayout.ABOVE, R.id.linearlayout_tab);
        divideLine.setLayoutParams(lineLp);

        addView(divideLine);
    }

    private void initViewPager(Context context) {
        mContentViewPager = new ViewPager(context);

        LayoutParams contentVpLp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        contentVpLp.addRule(RelativeLayout.ABOVE, R.id.divide_tab);
        mContentViewPager.setLayoutParams(contentVpLp);
        mContentViewPager.setId(R.id.viewpager_tab);

        mContentViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mTabHost.changeTabHostStatus(position);

                AbsTab selectedTab = mTabHost.getTabForIndex(position);
                if (mOnTabSelectedListener != null && selectedTab != null) mOnTabSelectedListener.onTabSelected(selectedTab);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        addView(mContentViewPager);
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        setAdapter(baseAdapter, 0);
    }

    public void setAdapter(BaseAdapter baseAdapter, int index) {
        if (baseAdapter == null) return;

        mTabHost.addTabs(baseAdapter);
        mContentViewPager.setAdapter(new TabViewPagerAdapter(baseAdapter.getFragmentManager(), baseAdapter.getFragmentArray()));

        setCurrentItem(index);
    }

    /**
     *  设置当前选中的tab
     * @param index
     */
    public void setCurrentItem(int index) {
        mTabHost.changeTabHostStatus(index);
        mContentViewPager.setCurrentItem(index);
    }

    /**
     *  显示消息提示
     * @param index
     */
    public void setCurrentMessageItem(int index) {
        setCurrentMessageItem(index, -1);
    }

    /**
     *  设置消息提示数量
     * @param index
     */
    public void setCurrentMessageItem(int index, int count) {
        AbsTab tab = mTabHost.getTabForIndex(index);
        tab.showMessageTip(true, count);
    }

    public void setOffscreenPageLimit(int limit) {
        mContentViewPager.setOffscreenPageLimit(limit);
    }

    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.mOnTabSelectedListener = onTabSelectedListener;
    }


}
