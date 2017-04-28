package com.fe.tabcontainerview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.fe.library.widget.AbsTab;

/**
 * Created by chenpengfei on 2017/4/28.
 */
public class ExampleTwoTab extends AbsTab {

    private ImageView mIvIcon;
    private int mIcon, mSelectedIcon;

    public ExampleTwoTab(Context context, int index) {
        super(context, index);

        inflaterView(this, R.layout.tab_example_two);
    }

    @Override
    protected void tabSelected(boolean isSelected) {
        mIvIcon.setImageResource(isSelected ? mSelectedIcon : mIcon);
    }


    @Override
    protected void initView(View rootView) {
        mIvIcon = (ImageView) rootView.findViewById(R.id.iv_icon);
    }

    public void setIcons(int icon, int selectedIcon) {
        mIcon = icon;
        mSelectedIcon = selectedIcon;

        mIvIcon.setImageResource(mIcon);
    }
}
