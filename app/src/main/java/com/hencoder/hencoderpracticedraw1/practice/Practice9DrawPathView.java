package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {
    private Paint paint;
    private Path path;

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = initPaint();
        path = new Path();
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        initPath(path);
        canvas.drawPath(path, paint);
    }

    private Paint initPaint() {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        return paint;
    }

    private void initPath(Path path) {
        RectF rectF = new RectF(200, 200, 400, 400);
        path.addArc(rectF, -225, 225);
        RectF rectF1 = new RectF(400, 200, 600, 400);
        path.arcTo(rectF1, -180, 225, false);
        path.lineTo(400, 542);
    }

}
