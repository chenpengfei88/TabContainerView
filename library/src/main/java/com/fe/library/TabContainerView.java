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
import com.fe.library.widget.TabHost;
import fe.library.R;

/**
 * Created by chenpengfei on 2017/3/21.
 */
public class TabContainerView extends RelativeLayout {


    /**
     *  底部TabLayout
     */
    private TabHost tabHost;
    /**
     *  中间ViewPager
     */
    private ViewPager contentViewPager;

    /**
     *  文本属性
     */
    private int textSize;
    private int textColor;
    private int selectedTextColor;

    private OnTabSelectedListener onTabSelectedListener;


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

    private void init(Context context, AttributeSet attrs) {
        initStyle(context, attrs);
        initTabHost(context);
        initDivideLine(context);
        initViewPager(context);

        tabHost.setContentViewPager(contentViewPager);
    }

    private void initStyle(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TabContainerViewStyle);
        textColor = typedArray.getColor(R.styleable.TabContainerViewStyle_textColor, Color.BLACK);
        selectedTextColor = typedArray.getColor(R.styleable.TabContainerViewStyle_selectedTextColor, Color.RED);
        textSize = typedArray.getDimensionPixelSize(R.styleable.TabContainerViewStyle_textSize, 14);
    }


    private void initTabHost(Context context) {
        tabHost = new TabHost(context);
        addView(tabHost.getRootView());
    }

    private void initDivideLine(Context context) {
        View divideLine = new View(context);
        divideLine.setId(R.id.divide_tab);
        divideLine.setBackgroundColor(Color.CYAN);
        LayoutParams lineLp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 2);
        lineLp.addRule(RelativeLayout.ABOVE, R.id.linearlayout_tab);
        divideLine.setLayoutParams(lineLp);
        addView(divideLine);
    }

    private void initViewPager(Context context) {
        contentViewPager = new ViewPager(context);
        LayoutParams contentVpLp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        contentVpLp.addRule(RelativeLayout.ABOVE, R.id.divide_tab);
        contentViewPager.setLayoutParams(contentVpLp);
        contentViewPager.setId(R.id.viewpager_tab);

        contentViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                tabHost.onChangeTabHostStatus(position);

                if (onTabSelectedListener != null) onTabSelectedListener.onTabSelected(tabHost.getTabForIndex(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        addView(contentViewPager);
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        tabHost.addTabs(baseAdapter, textSize, textColor, selectedTextColor);

        contentViewPager.setAdapter(new TabViewPagerAdapter(baseAdapter.getFragmentManager(), baseAdapter.getFragmentArray()));
    }

    public void setCurrentItem(int index) {
        tabHost.onChangeTabHostStatus(index);
    }

    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.onTabSelectedListener = onTabSelectedListener;
    }


}
