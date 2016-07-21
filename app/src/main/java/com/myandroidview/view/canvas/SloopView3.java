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
public class SloopView3 extends View{

    public SloopView3(Context context) {
        super(context,null);
    }

    public SloopView3(Context context, AttributeSet attrs) {
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







    }
}
