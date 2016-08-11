package com.myandroidview.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.myandroidview.eventbus.FirstEvent;
import com.myandroidview.eventbus.SecondActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class MainActivity extends Activity {

    @InjectView(R.id.btn_try)
    Button btn;

    @InjectView(R.id.tv)
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//
        EventBus.getDefault().register(this);
       /* btn = (Button) findViewById(R.id.btn_try);
        tv = (TextView)findViewById(R.id.tv);*/

        ButterKnife.inject(this);

       /* btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        SecondActivity.class);
                startActivity(intent);
            }
        });*/
    }

    //为控件添加一个响应函数
    @OnClick(R.id.btn_try)
    public void submit(){
        Intent intent = new Intent(getApplicationContext(),
                SecondActivity.class);
        startActivity(intent);
    }

    public void onEventMainThread(FirstEvent event) {
        String msg = "onEventMainThread收到了消息：" + event.getMsg();
        Log.d("harvic", msg);
        tv.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
