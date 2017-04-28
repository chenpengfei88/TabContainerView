package com.fe.library.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import fe.library.R;

/**
 * Created by chenpengfei on 2017/4/27.
 */
public class DefaultTab extends AbsTab {

    /**
     *  tab布局信息
     */
    private ImageView mIvIcon;
    private TextView mTvText;
    private MessageCircle mMessageCircleTip;

    /**
     *  tab 文本颜色和图片切换资源
     */
    private int mTextColor;
    private int mSelectedTextColor;
    private int mIconImage;
    private int mSelectedIconImage;

    public DefaultTab(Context context, int index) {
       super(context, index);

        inflaterView(this, R.layout.tab_default);
    }

    @Override
    public void tabSelected(boolean isSelected) {
        if (this.mIsSelected == isSelected) return;

        mIvIcon.setImageResource(isSelected ? mSelectedIconImage : mIconImage);
        mTvText.setTextColor(isSelected ? mSelectedTextColor : mTextColor);
        this.mIsSelected = isSelected;
    }

    @Override
    public void showMessageTip(boolean show, int count) {
        mMessageCircleTip.setVisibility(show ? View.VISIBLE : View.GONE);
        if (count == -1) {
            mMessageCircleTip.setText("");
        } else {
            mMessageCircleTip.setText(count >= 1000 ? "999+" : count + "");
        }
    }

    @Override
    protected void initView(View rootView) {
        mIvIcon = (ImageView) rootView.findViewById(R.id.iv_icon);
        mTvText = (TextView) rootView.findViewById(R.id.tv_title);
        mMessageCircleTip = (MessageCircle) rootView.findViewById(R.id.mc_circle);
    }

    public void setTextColor(int textColor, int selectedTextColor) {
        mTextColor = textColor;
        mSelectedTextColor = selectedTextColor;

        mTvText.setTextColor(mTextColor);
    }

    public void setText(String text) {
        mTvText.setText(text);
    }

    public void setIconImage(int iconImage, int selectedIconImage) {
        mSelectedIconImage = selectedIconImage;
        mIconImage = iconImage;

        mIvIcon.setImageResource(iconImage);
    }
}
