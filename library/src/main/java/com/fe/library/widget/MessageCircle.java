package com.fe.library.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import fe.library.R;

/**
 * Created by chenpengfei on 2016/5/20.
 *  消息提示小圆点
 */
public class MessageCircle extends View {

    /**
     *  画笔
     */
    private Paint mPaint;
    /**
     *  内容
     */
    private String mText;
    /**
     *  内容距离圆点边缘间距
     */
    private int mTextSpacing;
    /**
     *  字体大小
     */
    private int mTextSize;
    /**
     *  文字颜色
     */
    private int mTextColor;
    /**
     *  圆点颜色
     */
    private int mCricleColor;
    /**
     * 圆角矩形的圆角度
     */
    private int mRoundRectR = 20;
    /**
     *  内容绘制区域
     */
    private Rect mTextRect = new Rect();

    public MessageCircle(Context context) {
        super(context);
    }

    public MessageCircle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MessageCircle(Context context, AttributeSet attrs, int defStyleAttr) {
       super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MessageCircle(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    public void setText(String text) {
        if(text == null) text = "";
        mText = text;
    }

    public void setText(int text) {
        mText = String.valueOf(text);
    }

    public void setTextColor(int color) {
        mTextColor = color;
    }

    public void setCircleColor(int color) {
        mCricleColor = color;
    }

    /**
     *  解析样式
     */
    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MessageCircleStyle);
        mText = typedArray.getString(R.styleable.MessageCircleStyle_text);
        if(mText == null) mText = "";
        mTextSpacing = typedArray.getDimensionPixelSize(R.styleable.MessageCircleStyle_textSpacing, 10);
        mTextSize = typedArray.getDimensionPixelSize(R.styleable.MessageCircleStyle_messageTextSize, 24);
        mTextColor = typedArray.getColor(R.styleable.MessageCircleStyle_messageTextColor, Color.WHITE);
        mCricleColor =  typedArray.getColor(R.styleable.MessageCircleStyle_cricleColor, Color.RED);
        typedArray.recycle();

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(mTextSize);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mPaint.getTextBounds(mText, 0, mText.length(), mTextRect);
        int mWidth, mHeight;
        if(mText.length() > 2) {
            mWidth = mTextRect.width() + mTextSpacing;
            mHeight = mTextRect.height() + mTextSpacing;
        } else {
            mWidth = mHeight = Math.max(mTextRect.height(), mTextRect.width()) + mTextSpacing;
        }
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //绘制圆点
        mPaint.setColor(mCricleColor);
        if(mText.length() > 2) {
            RectF rect = new RectF();
            rect.left = 0;
            rect.top = 0;
            rect.right = getMeasuredWidth();
            rect.bottom = getMeasuredHeight();
            canvas.drawRoundRect(rect, mRoundRectR, mRoundRectR, mPaint);
        } else {
            int mWidth = getWidth() / 2;
            canvas.drawCircle(mWidth, mWidth, mWidth, mPaint);
        }
        if(TextUtils.isEmpty(mText)) return;
        //绘制数字
        mPaint.setColor(mTextColor);
        //文字X轴移中心来设置距离左边的距离
        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(mText, getMeasuredWidth() / 2, getMeasuredHeight() / 2 + mTextRect.height() / 2, mPaint);
    }

}
