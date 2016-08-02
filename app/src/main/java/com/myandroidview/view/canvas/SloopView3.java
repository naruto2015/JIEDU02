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
        //mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(1f);

    }

    private int mHeight,mWidth;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight=h;
        mWidth=w;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //translate 是每次相对于当前坐标系的位置移动
      /*  canvas.translate(200,200);
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(0,0,100,mPaint);

        canvas.translate(200,200);
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(0,0,100,mPaint);*/


      /*
        canvas.translate(mWidth/2,mHeight/2);
        mPaint.setColor(Color.BLACK);
        RectF rectF=new RectF(0,-400,400,0);
        canvas.drawRect(rectF,mPaint);

        mPaint.setColor(Color.BLUE);
        canvas.scale(0.5f,0.5f);
        //canvas.scale(0.5f,0.5f,200,0);  画布缩放，缩放中心向右便宜200px
        canvas.drawRect(rectF,mPaint);
        */

      /*  mPaint.setColor(Color.BLUE);
        RectF rectF=new RectF(-400,-400,400,400);
        canvas.translate(mWidth/2,mHeight/2);
        canvas.drawRect(rectF,mPaint);
        for(int i=0;i<20;i++){
            //scale 与 translet一样也是叠加的
            canvas.scale(0.9f,0.9f);
            canvas.drawRect(rectF,mPaint);

        }
*/

        // 将坐标系原点移动到画布正中心
        canvas.translate(mWidth / 2, mHeight / 2);
        canvas.drawCircle(0,0,200,mPaint);          // 绘制两个圆形
        canvas.drawCircle(0,0,180,mPaint);

        for (int i=0; i<=35; i+=1){               // 绘制圆形之间的连接线
            canvas.drawLine(0,180,0,200,mPaint);
            canvas.rotate(10);
        }



    }


}
