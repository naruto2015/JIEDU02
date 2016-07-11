package com.myandroidview.view.canvas;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by naruto on 2016/7/11.
 */
public class SloopView extends View{


    private Paint mPaint=new Paint();

    public SloopView(Context context) {
        super(context,null);

    }

    public SloopView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }


    private void initPaint(){
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(10f);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPoint(200,200,mPaint);
        canvas.drawPoints(new float[]{500,300,
                                       500,400,
                                       500,500},mPaint);
        canvas.drawLine(600,600,700,800,mPaint);

    }
}
