package com.myandroidview.view.canvas;

/**
 * Created by naruto on 2016/8/2.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

public class PathViewOne extends View{


    private Paint mPaint=new Paint();

    private Handler handler=null;

    private long CurrentX=99;
    private long CurrentY=99;

    public PathViewOne(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setARGB(255,201,222,193);
        mPaint.setStrokeWidth(3f);
        mPaint.setStyle(Paint.Style.STROKE);

        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(CurrentX<301){
                    CurrentX+=3;
                    CurrentY+=3;
                    invalidate();
                }

            }
        };

    }

    public PathViewOne(Context context) {
        super(context,null);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Path path=new Path();
        path.moveTo(100,100);
        path.lineTo(300,300);
        mPaint.setARGB(255,201,222,193);
        canvas.drawPath(path,mPaint);

        if(CurrentX!=99){
            Path path2=new Path();
            path2.moveTo(100,100);
            path2.lineTo(CurrentX,CurrentY);
            mPaint.setColor(Color.RED);
            canvas.drawPath(path2,mPaint);
        }

        //#C9DEC1
        Paint circlePaint=new Paint();
        circlePaint.setColor(Color.BLACK);
        circlePaint.setStrokeWidth(1f);
        circlePaint.setStyle(Paint.Style.STROKE);

        canvas.drawCircle(99,99,5,circlePaint);
        canvas.drawCircle(301,301,5,circlePaint);

        Paint fillPaint=new Paint();
        circlePaint.setColor(Color.BLACK);
        circlePaint.setStrokeWidth(1f);
        circlePaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(CurrentX,CurrentY,5,fillPaint);

       handler.sendEmptyMessageDelayed(1,100);

    }


}
