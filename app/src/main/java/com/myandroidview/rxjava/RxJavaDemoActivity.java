package com.myandroidview.rxjava;

import android.database.Observable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.myandroidview.activity.R;

import rx.Subscriber;
import rx.functions.Action1;


/*
RxJava最核心的两个东西是Observables（被观察者，事件源）和Subscribers（观察者）。
Observables发出一系列事件，Subscribers处理这些事件。这里的事件可以是任何你感兴趣的东西（触摸事件，web接口调用返回的数据。。。）
 */
public class RxJavaDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_demo);

    }




}
