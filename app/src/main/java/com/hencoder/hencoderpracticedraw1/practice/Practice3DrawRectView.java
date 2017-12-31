package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice3DrawRectView extends View {

    private static final String TAG = Practice3DrawRectView.class.getSimpleName();
    private Paint mPaint;
    private int w;
    private int h;
    private Rect rect;

    public Practice3DrawRectView(Context context) {
        super(context);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = initPaint();
        rect = new Rect();
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.w = w;
        this.h = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawRect() 方法画矩形
        int left = w / 2 - 200;
        int top = h / 2 + 200;
        int right = w / 2 + 200;
        int bottom = h / 2 - 200;
        Log.v(TAG, "left:" + left);
        Log.v(TAG, "top:" + top);
        Log.v(TAG, "right:" + right);
        Log.v(TAG, "bottom:" + bottom);
        rect.set(left, top, right, bottom);
        canvas.drawRect(rect, mPaint);
    }

    private Paint initPaint() {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

}
