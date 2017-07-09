package com.fe.library.widget;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by chenspengfei on 2017/7/9.
 */
public class NormalSuspension implements Suspension {

    /**
     *  画笔
     */
    private Paint mPaint;

    public NormalSuspension() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GREEN);
    }

    @Override
    public void onDraw(Canvas canvas, int tabWidth, int position, float positionOffset) {
        float moveOffset = tabWidth * (position + 1) + tabWidth * positionOffset;
        int leftMoveOffset = (int) (position * tabWidth + tabWidth * positionOffset);
        // 绘制滚动的下划线
        Rect rect = new Rect(leftMoveOffset, 0, (int)moveOffset, 20);
        canvas.drawRect(rect, mPaint);
    }
}
