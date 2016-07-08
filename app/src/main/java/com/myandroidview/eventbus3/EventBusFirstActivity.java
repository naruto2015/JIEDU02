package com.myandroidview.eventbus3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.myandroidview.activity.R;
import com.myandroidview.eventbus2.SecondEvent;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import de.greenrobot.event.EventBus;

public class EventBusFirstActivity extends AppCompatActivity {


    private EventbusDao eventbusDao=new EventBusDaoImpl(EventBusFirstActivity.this);
    private SimpleDateFormat simpleDateFormat;
    private TextView btn;
    private ArrayList<EventBusBean> list=new ArrayList<EventBusBean>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_first);
        EventBus.getDefault().register(this);
        btn= (TextView) findViewById(R.id.btn_first);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBusFirstActivity.this.startActivityForResult(new Intent(EventBusFirstActivity.this,EventBusSecondActivity.class),1);
            }
        });

        simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        EventBus.getDefault().post(new EventBusBean());

        list=eventbusDao.getAll();
    }


    /*@Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }*/

    //SecondEvent接收函数三
    public void onEventAsync(EventBusBean event){

        while(true){
            Log.e("Tag","开始插入");
            EventBusBean eventBusBean=new EventBusBean();
            eventBusBean.time=simpleDateFormat.format(new Date());
            eventbusDao.insert(eventBusBean);
            try {
                Thread.sleep(1000*60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
