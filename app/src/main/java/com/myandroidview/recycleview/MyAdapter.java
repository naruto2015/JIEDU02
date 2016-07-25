package com.myandroidview.recycleview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myandroidview.activity.R;
import com.myandroidview.bean.RecycleViewBean;

import java.util.List;

/**
 * Created by naruto on 2016/7/24.
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Context context; List<RecycleViewBean> list;

    public MyAdapter(Context context, List<RecycleViewBean> list){
        this.context=context;
        this.list=list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int type=getItemViewType(viewType);
        View view=null;
        if(type==0){
            view=LayoutInflater.from(context).inflate(R.layout.headview,parent,false);

        }else if(type==1){
            view=LayoutInflater.from(context).inflate(R.layout.recycleview_item,parent,false);

        }

        return new Holder(view);
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        //super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager=recyclerView.getLayoutManager();
        if(layoutManager instanceof GridLayoutManager){
            final GridLayoutManager gridLayoutManager= (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {

                    return getItemViewType(position)==0?gridLayoutManager.getSpanCount():1;
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {


        return list.get(position).type;
    }



    class Holder extends RecyclerView.ViewHolder{

        public Holder(View itemView) {
            super(itemView);
        }

    }

}
