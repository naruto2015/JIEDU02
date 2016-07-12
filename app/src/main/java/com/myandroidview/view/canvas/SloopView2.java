package com.myandroidview.view.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/**
 * Created by naruto on 2016/7/11.
 */
public class SloopView2 extends View{

    public SloopView2(Context context) {
        super(context,null);
    }

    public SloopView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }
    private Paint mPaint=new Paint();
    private void initPaint(){
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(10f);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        RectF rectF=new RectF(100,100,800,400);
        //绘制矩形背景
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF,mPaint);

        //绘制圆弧
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectF,0,90,false,mPaint);

        RectF rectF2 = new RectF(100,600,800,900);
        // 绘制背景矩形
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF2,mPaint);

        // 绘制圆弧
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectF2,0,90,true,mPaint);

    }
}
