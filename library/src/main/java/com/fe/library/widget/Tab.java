package com.fe.library.widget;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fe.library.listener.OnTabSelectedListener;

/**
 * Created by chenpengfei on 2017/3/21.
 */
public class Tab {

    private Context context;
    private int index;
    //是否被选中
    private boolean isSelected;

    /**
     *  文本信息
     */
    private String text;
    private int textColor;
    private int selectedTextColor;
    private int textSize;

    /**
     *  icon信息
     */
    private int iconImage;
    private int selectedIconImage;

    /**
     *  Tab布局信息
     */
    private LinearLayout rootView;
    private ImageView iconImageView;
    private TextView textTextView;

    /**
     *  tab选中监听
     */
    private OnTabSelectedListener onTabSelectedListener;

    public Tab(Context context, String text, int textSize, int textColor, int selectedTextColor, int iconImage, int selectedIconImage, int index) {
        this.context = context;
        this.text = text;
        this.textSize = textSize;
        this.textColor = textColor;
        this.selectedTextColor = selectedTextColor;

        this.iconImage = iconImage;
        this.selectedIconImage = selectedIconImage;
        this.index = index;

        init();
    }

    private void init() {
        initView();

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabSelected();
            }
        });
    }

    private void initView() {
        rootView = new LinearLayout(context);
        rootView.setOrientation(LinearLayout.VERTICAL);
        rootView.setGravity(Gravity.CENTER_HORIZONTAL);
        rootView.setPadding(0, 25, 0, 0);
        LinearLayout.LayoutParams rootViewLp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rootViewLp.weight = 1;

        rootView.setLayoutParams(rootViewLp);

        /**
         *  icon view
         */
        iconImageView = new ImageView(context);
        iconImageView.setImageResource(iconImage);
        iconImageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        rootView.addView(iconImageView);

        /**
         *  text view
         */
        textTextView = new TextView(context);
        textTextView.setText(text);
        textTextView.setTextColor(textColor);
        textTextView.setTextSize(textSize);
        textTextView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        rootView.addView(textTextView);
    }

    /**
     * 选中Tab
     */
    private void tabSelected() {
        if (onTabSelectedListener != null) onTabSelectedListener.onTabSelected(this);
    }

    /**
     * 得到rootView
     */
    public LinearLayout getRootView() {
        return rootView;
    }

    public int getIndex() {
        return index;
    }

    public String getText() {
        return text;
    }

    public void setTabIsSelected(boolean isSelected) {
        if (this.isSelected == isSelected) return;

        iconImageView.setImageResource(isSelected ? selectedIconImage : iconImage);
        textTextView.setTextColor(isSelected ? selectedTextColor : textColor);
        this.isSelected = isSelected;
    }

    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.onTabSelectedListener = onTabSelectedListener;
    }

}
