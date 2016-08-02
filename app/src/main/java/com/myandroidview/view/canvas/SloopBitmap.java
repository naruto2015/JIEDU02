package com.myandroidview.view.canvas;

/**
 * Created by naruto on 2016/8/1.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.myandroidview.activity.R;

public class SloopBitmap extends View {
    public SloopBitmap(Context context) {
        super(context);
    }

    public SloopBitmap(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Bitmap bitmap=null;
        bitmap= BitmapFactory.decodeResource(getResources(), R.drawable.testimage);//资源文件
        // bitmap=BitmapFactory.decodeFile("/sdcard/...png"); //sdcard文件
        // BitmapFactory.decodeStream(is); 网络文件
        canvas.drawBitmap(bitmap,0,0,new Paint());


    }


}
