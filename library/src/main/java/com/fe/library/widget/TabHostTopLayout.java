package com.fe.library.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/**
 * Created by chenpengfei on 2017/7/9.
 */
public class TabHostTopLayout extends HorizontalScrollView {

    private LinearLayout mHostLayout;

    public TabHostTopLayout(Context context) {
        super(context);

        addHostView(context);
    }

    public TabHostTopLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        addHostView(context);
    }

    public TabHostTopLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        addHostView(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TabHostTopLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        addHostView(context);
    }

    private void addHostView(Context context) {
        mHostLayout = new LinearLayout(context);
        mHostLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mHostLayout.setOrientation(LinearLayout.HORIZONTAL);

        addView(mHostLayout);
    }

    public LinearLayout getHostView() {
        return mHostLayout;
    }


}
