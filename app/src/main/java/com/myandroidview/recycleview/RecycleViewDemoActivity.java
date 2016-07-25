package com.myandroidview.recycleview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.myandroidview.activity.R;
import com.myandroidview.bean.RecycleViewBean;

import java.util.ArrayList;
import java.util.List;

import utils.DividerItemDecoration;

public class RecycleViewDemoActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private List<RecycleViewBean> list=new ArrayList<>();
    private Context context;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_demo);
        context=this;

        init();

        initData();

    }

    private void initData() {

            RecycleViewBean bean=new RecycleViewBean();
            bean.type=0;
            list.add(bean);

            RecycleViewBean bean2=new RecycleViewBean();
            bean2.type=1;
            list.add(bean2);

            RecycleViewBean bean3=new RecycleViewBean();
            bean3.type=1;
            list.add(bean3);

            RecycleViewBean bean4=new RecycleViewBean();
            bean4.type=0;
            list.add(bean4);
            adapter.notifyDataSetChanged();
    }

    private void init() {
        recyclerView= (RecyclerView) findViewById(R.id.recycle);
      /*  LinearLayoutManager linear=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linear);*/
        recyclerView.setLayoutManager(new GridLayoutManager(context,2));
        adapter=new MyAdapter(context,list);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL_LIST));
    }



}
