package com.myandroidview.view.canvas;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by naruto on 2016/7/12.
 */
public class PieView extends View {

    public PieView(Context context) {
        super(context,null);
    }

    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public PieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);

    }

    //颜色表
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};

    //饼状图初始绘制角度
    private float mStartAngle=0;
    //数据
    private ArrayList<PieData> mData;
    //宽高
    private int mWidth,mHeight;
    //画笔
    private Paint mPaint=new Paint();

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=w;
        mHeight=h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mData==null){
            return;
        }
        float currentStartAngle=mStartAngle;
        canvas.translate(mWidth/2,mHeight/2); // 将画布坐标原点移动到中心位置
        float r= (float) (Math.min(mWidth,mHeight)/2*0.8);// 饼状图半径
        RectF rect = new RectF(-r, -r, r, r);

        for(int i=0;i<mData.size();i++){
            PieData pie=mData.get(i);
            mPaint.setColor(pie.color);
            canvas.drawArc(rect,currentStartAngle,pie.angle,true,mPaint);
            currentStartAngle+=pie.angle;
        }


    }


    //设置起始角度
    public void setStartAngle(int mStartAngle){
        this.mStartAngle=mStartAngle;
        invalidate();//刷新
    }

    //设置数据
    public void setData(ArrayList<PieData> mData){
        this.mData=mData;
        initDate(mData);
        invalidate();   // 刷新
    }

    public void initDate(ArrayList<PieData> mData){
        if(mData==null || mData.size()==0){
            return;
        }
        float sumValue=0;
        for (int i=0;i<mData.size();i++){
            PieData pie=mData.get(i);
            sumValue+=pie.value;
            int j = i % mColors.length;       //设置颜色
            pie.color=mColors[j];
        }

        float sumAngle=0;
        for(int i=0;i<mData.size();i++){
            PieData pie=mData.get(i);
            float percentage=pie.value/sumValue;//百分比
            float angle=percentage=percentage*360;//对应的角度

            pie.percentage=percentage;            //记录百分比
            pie.angle+=angle;                      //记录角度大小
            sumAngle+=angle;

        }



    }





}
