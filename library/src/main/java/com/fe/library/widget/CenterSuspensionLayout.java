package com.fe.library.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by chenpengfei on 2017/7/9.
 */
public class CenterSuspensionLayout extends LinearLayout {

    private Suspension mSuspension;

    /**
     *  单个Tab宽度
     */
    private int mTabWidth;

    /**
     *  ViewPager 当前第position个
     */
    private int mPosition;

    /**
     *  ViewPager 当前移动的百分比
     */
    private float mPositionOffset;


    public CenterSuspensionLayout(Context context) {
        super(context);
    }

    public CenterSuspensionLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CenterSuspensionLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CenterSuspensionLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setSuspension(Suspension suspension, int tabWidth) {
        mSuspension = suspension;
        mTabWidth = tabWidth;

        System.out.println("================setSuspension===================="+mTabWidth);
    }

    public void moveOffset(int position, float positionOffset, int positionOffsetPixels) {
        mPosition = position;
        mPositionOffset = positionOffset;

        System.out.println("================moveOffset====================");

        invalidate();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);

        mSuspension.onDraw(canvas, mTabWidth, mPosition, mPositionOffset);
    }
}
