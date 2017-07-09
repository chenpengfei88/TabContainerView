package com.fe.library.widget;

import android.graphics.Canvas;

/**
 * Created by chenpengfei on 2017/7/9.
 */
public interface Suspension {

    /**
     *  绘制悬浮
     * @param canvas
     * @param tabWidth tab宽度
     * @param position 第几个tab
     * @param positionOffset 移动的百分比
     */
    void onDraw(Canvas canvas, int tabWidth, int position, float positionOffset);
}
