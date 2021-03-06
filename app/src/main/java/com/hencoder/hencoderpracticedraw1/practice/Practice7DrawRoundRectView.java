package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice7DrawRoundRectView extends View {
    private Paint paint;
    private RectF rectF;
    private int w;
    private int h;

    public Practice7DrawRoundRectView(Context context) {
        super(context);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = initPaint();
        rectF = new RectF();
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
//        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形
        rectF.set(w / 2 - 200, h / 2 - 150, w / 2 + 200, h / 2 + 150);
        canvas.drawRoundRect(rectF, 10, 10, paint);
    }

    private Paint initPaint() {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }
}
