package com.myandroidview.eventbus3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.myandroidview.activity.R;

import java.util.ArrayList;

/**
 * Created by naruto on 2016/7/7.
 */
class MyAdapter extends BaseAdapter {

    private ArrayList<EventBusBean> list;
    private Context context;
    public MyAdapter(ArrayList<EventBusBean> list,Context context){

        this.list=list;
        this.context=context;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        ViewHolder holder=null;
        if(convertView!=null){

            holder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item,null);
            holder.time= (TextView) convertView.findViewById(R.id.time);
            convertView.setTag(holder);

        }else{
            holder= (ViewHolder) convertView.getTag();
        }

        holder.time.setText(list.get(i).time);

        return convertView;
    }

    class ViewHolder{
        public TextView time;
    }

}