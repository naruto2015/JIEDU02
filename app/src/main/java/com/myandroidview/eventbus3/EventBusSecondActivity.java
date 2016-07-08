package com.myandroidview.eventbus3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.myandroidview.activity.R;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

public class EventBusSecondActivity extends AppCompatActivity {


    private ListView listView;
    private ArrayList<EventBusBean> list=new ArrayList<EventBusBean>();
    private EventbusDao eventbusDao=new EventBusDaoImpl(EventBusSecondActivity.this);
    private MyAdapter adapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_second);


        context=this;
        listView= (ListView) findViewById(R.id.listview);
        //SimpleAdapter adapter=new SimpleAdapter(this,list,R.layout.item,new String[]{"name"},new int[]{R.id.time});

        adapter=new MyAdapter(list,context);
        listView.setAdapter(adapter);

        list=eventbusDao.getAll();
        adapter.notifyDataSetChanged();



    }





}
