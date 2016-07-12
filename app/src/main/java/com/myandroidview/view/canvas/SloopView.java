package com.myandroidview.view.canvas;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
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

        //第一种
        canvas.drawRect(200,850,300,950,mPaint);
       //第二种
        rect2=new Rect(200,1000,300,1100);
        canvas.drawRect(rect2,mPaint);
        //第三种
       /* RectF rectF=new RectF(200,1000,300,1100);
        canvas.drawRect(rectF,mPaint);*/

        //圆角矩形
      /*  rect2=new Rect(200,1000,300,1100);
        canvas.drawRoundRect(rect2,30,30,mPaint);*/

        //canvas.drawCircle(400,1500,300,mPaint);

    }

    private Rect rect2;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       // super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width = 0;
        int height = 0;

        if(widthMode==MeasureSpec.EXACTLY){
            width=widthSize;
        }else{

        }

        if(heightMode==MeasureSpec.EXACTLY){
            height=heightSize;
        }else{

        }
        setMeasuredDimension(width,height);

    }
}
