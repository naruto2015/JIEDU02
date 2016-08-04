package com.myandroidview.view.canvas;

/**
 * Created by naruto on 2016/8/4.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class PathMeasureView extends View {


    private Paint mDeafultPaint;

    public PathMeasureView(Context context) {
        super(context,null);
    }

    public PathMeasureView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mDeafultPaint=new Paint();
        mDeafultPaint.setColor(Color.BLACK);
        mDeafultPaint.setStyle(Paint.Style.STROKE);
        mDeafultPaint.setStrokeWidth(1f);

    }

    int mViewWidth;
    int mViewHeight;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mViewWidth/2,mViewHeight/2);
        Path path=new Path();

        path.lineTo(0,200);
        path.lineTo(200,200);
        path.lineTo(200,0);

        PathMeasure measure1=new PathMeasure(path,false);
        PathMeasure measure2=new PathMeasure(path,true);

        Log.e("TAG", "forceClosed=false---->"+measure1.getLength());
        Log.e("TAG", "forceClosed=true----->"+measure2.getLength());

        canvas.drawPath(path,mDeafultPaint);

    }






}
