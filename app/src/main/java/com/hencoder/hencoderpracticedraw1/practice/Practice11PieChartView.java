package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Data;

import java.util.ArrayList;
import java.util.List;

public class Practice11PieChartView extends View {
    private List<Data> datas;
    private int count ;
    private Paint paint;
    private Paint linePaint;
    private Paint textPaint;
    private int w;
    private int h;
    private int r;
    private RectF rectF;
    private float startAngle = 0f;
    private float sweepAngle=0f;
    private float length = 20;
    private float lineWidth = 50;

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        datas = new ArrayList<>();
        initDatas();
        count  = getCount();
        Log.v("count ","count : "+count);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        rectF = new RectF();
        r = 250;
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(5);
        linePaint.setColor(Color.WHITE);
        textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setTextSize(44);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        drawPie(canvas);
        canvas.drawText("饼图",w/2,h-50,textPaint);
    }

    private void drawPie(Canvas canvas){
        rectF.set(w/2-r,h/2-r,w/2+r,h/2+r);
        Log.v("rectF",rectF.toString());
        for (Data data : datas){
            startAngle = startAngle+sweepAngle;
            sweepAngle =  (data.getAmount()/(float)count)*360;
            Log.v("angle","start: "+ startAngle+ " sweep :" + sweepAngle);
            paint.setColor(data.getColor());
            canvas.drawArc(rectF,startAngle,sweepAngle,true,paint);
            getCenterPoint(startAngle,sweepAngle,canvas);
        }
    }

    private void initDatas() {
        datas = new ArrayList<>();
        datas.add(new Data("Froyo", 10,Data.randomColor()));
        datas.add(new Data("GB", 20,Data.randomColor()));
        datas.add(new Data("ICS", 20,Data.randomColor()));
        datas.add(new Data("JB", 40,Data.randomColor()));
        datas.add(new Data("KitKat", 60,Data.randomColor()));
        datas.add(new Data("L", 70,Data.randomColor()));
        datas.add(new Data("M", 35,Data.randomColor()));
    }

    private void getCenterPoint(float startAngle,float sweepAngle,Canvas canvas){
        float middleAngle = startAngle+sweepAngle/2;
       float x = (float)(r * Math.cos(middleAngle));
       float y = (float)(r * Math.sin(middleAngle));
        int xPm = 1;
        int yPm =1;
       if(x <0 ){
           xPm = -1;
       }else if(x == 0.0){
           xPm = 0;
       }
       if(y<0){
           yPm = -1;
       }else if(y == 0.0){
           yPm = 0;
       }

       canvas.drawLine(w/2+x,
               h/2+y,
               w/2+x+length*xPm,
               h/2+y+length*yPm,linePaint);
       canvas.drawLine(w/2+x+length*xPm,
               h/2+y+length*yPm,
               w/2+x+length*xPm+lineWidth*xPm,
               h/2+y+length*yPm,
               linePaint);

    }

    private int getCount(){
        int count = 0;
        for (Data data :datas){
            count+= data.getAmount();
        }
        return count;
    }
}
