package com.myandroidview.view.canvas;

/**
 * Created by naruto on 2016/8/1.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class SloopPath extends View{


    private Paint mPaint;
    public SloopPath(Context context) {
        super(context,null);
    }

    public SloopPath(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);

    }


    int mWidth;
    int mHeight;
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mWidth=w;
        mHeight=h;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(mWidth/2,mHeight/2);
        Path path=new Path();

      /*  path.lineTo(200, 200);                      // lineTo    第一次没有做任何操作，默认是（0,0）-（200,200）
        path.lineTo(200,0);
        canvas.drawPath(path,mPaint);*/

        path.lineTo(200,200);
        path.moveTo(200,100);                        //改变下一次操作的起点
        path.lineTo(200,0);
        canvas.drawPath(path,mPaint);

/*
        canvas.translate(mWidth / 2, mHeight / 2);  // 移动坐标系到屏幕中心

        Path path = new Path();                     // 创建Path

        path.lineTo(200, 200);                      // lineTo

        path.setLastPoint(200,100);                 // setLastPoint    setLastPoint是重置上一次操作的最后一个点

        path.lineTo(200,0);                         // lineTo

        canvas.drawPath(path, mPaint);              // 绘制Path
*/

        /*
        close方法用于连接当前最后一个点和最初的一个点(如果两个点不重合的话)，最终形成一个封闭的图形。
         */




    }





}
