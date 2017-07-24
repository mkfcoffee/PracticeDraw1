package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice2DrawCircleView extends View {
    private static final String TAG = Practice2DrawCircleView.class.getSimpleName();
    private Paint mPaint;
    private int width;
    private int height;
    private int rightwidth;
    private int bottomheight;

    public Practice2DrawCircleView(Context context) {
        super(context);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        rightwidth = w * 3 / 4;
        bottomheight = h * 3 / 4;
        Log.v(TAG, "width:" + width);
        Log.v(TAG, "height:" + height);
        Log.v(TAG, "rightwidth:" + rightwidth);
        Log.v(TAG, "bottomheight:" + bottomheight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPaint1();
        canvas.drawCircle(width / 4, height / 4, width / 8, mPaint);
//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        initPaint2();
        canvas.drawCircle(rightwidth, height / 4, width / 8, mPaint);

        initPaint3();
        canvas.drawCircle(width / 4, bottomheight, width / 8, mPaint);

        initPaint4();
        canvas.drawCircle(rightwidth, bottomheight, width / 8, mPaint);

    }

    private void initPaint1() {
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
    }

    private void initPaint2() {
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    private void initPaint3() {
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);

    }

    private void initPaint4() {
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
    }
}
