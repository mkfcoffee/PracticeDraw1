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

import com.hencoder.hencoderpracticedraw1.Data;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {

    private Paint paint;
    private Paint textPaint;
    private List<Data> datas;
    private int originX;
    private int originY;
    private int w;
    private int h;
    private int coordinateH;
    private int width = 80;//每一项宽度
    private int space = 30;//每一项间隔
    private Rect rect;

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initDatas();
        originX = 100;
        paint = new Paint();
        textPaint = new Paint();
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(36);
        textPaint.setTextAlign(Paint.Align.CENTER);
        rect = new Rect();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.w = w;
        this.h = h;
        originY = h-250;
        coordinateH = originY -50;
        Log.v("Y ","originY: "+originY +"coordinateH: "+coordinateH);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        drawCoordinate(canvas);
        drawHistogram(canvas);
    }

    private void drawCoordinate(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.WHITE);
        canvas.drawText("直方图",w/2,h-100,textPaint);
        canvas.drawLine(originX,originY,originX,50,paint);
        int w = originX+ (space+width)*datas.size()+80;
        canvas.drawLine(originX,originY,w,originY,paint);
    }

    private void drawHistogram(Canvas canvas) {
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        for(int i =0;i<datas.size();i++){
            int left  = originX +space + (width+space)*i;
            int top = (int)(originY - ((float)datas.get(i).getAmount()/100) * coordinateH);
            int right = left+width;
            int bottom = originY;
            Log.v("Rect","left: "+left +" top: "+top+" right: "+right+" bottom: "+bottom);
            rect.set(left,top,right,bottom);
            canvas.drawRect(rect,paint);
            canvas.drawText(datas.get(i).getName(),right-width/2,originY+30,textPaint);
        }
    }

    private void initDatas() {
        datas = new ArrayList<>();
        datas.add(new Data("Froyo", 10));
        datas.add(new Data("GB", 20));
        datas.add(new Data("ICS", 20));
        datas.add(new Data("JB", 40));
        datas.add(new Data("KitKat", 60));
        datas.add(new Data("L", 70));
        datas.add(new Data("M", 35));
    }
}
