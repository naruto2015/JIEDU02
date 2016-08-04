package com.myandroidview.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.myandroidview.activity.R;

public class ValueAnimatorActivity extends AppCompatActivity {


    private float mScreenHeight;
    private ImageView mBlueBall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);

        mBlueBall = (ImageView) findViewById(R.id.id_ball);
        DisplayMetrics displayMetrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        mScreenHeight=displayMetrics.heightPixels;

    }

    /*
    自有落体
     */
    public void verticalRun(View view){

        final ValueAnimator animator=ValueAnimator.ofFloat(0,mScreenHeight-mBlueBall.getHeight());
        animator.setTarget(mBlueBall);
        animator.setDuration(1000).start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mBlueBall.setTranslationY((Float) valueAnimator.getAnimatedValue());
            }
        });

    }

    /**
     * 抛物线
     * @param view
     */
    public void paowuxian(View view){

        ValueAnimator valueAnimator=new ValueAnimator();
        valueAnimator.setDuration(3000);
        valueAnimator.setObjectValues(new PointF(0,0));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {
            @Override
            public PointF evaluate(float fraction, PointF pointF, PointF t1) {
                // x方向200px/s ，则y方向0.5 * 10 * t
                PointF point = new PointF();
                point.x = 200 * fraction * 3;
                point.y = 0.5f * 200 * (fraction * 3) * (fraction * 3);
                return point;
            }
        });

        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                PointF point = (PointF) animation.getAnimatedValue();
                mBlueBall.setX(point.x);
                mBlueBall.setY(point.y);

            }
        });


    }

    /*
    淡出且删除
     */
    public void fadeOut(View view){
        ObjectAnimator anim=ObjectAnimator.ofFloat(mBlueBall,"alpha",0.5f);

        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

                ViewGroup parent= (ViewGroup) mBlueBall.getParent();
                if(parent!=null){
                    parent.removeView(mBlueBall);
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        anim.start();

    }




}
