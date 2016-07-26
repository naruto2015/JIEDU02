package com.myandroidview.recycleview;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/**
 * Created by naruto on 2016/7/25.
 * 实现上拉加载的监听：加载条件：滑动到最后，且是停止状态，则开始加载数据
 */
public class LoadDataScrollController extends RecyclerView.OnScrollListener implements SwipeRefreshLayout.OnRefreshListener{


    /**
     * 当前布局管理器的类型
     */
    private LayoutManagerType mLayoutManagerType;

    /**
     * 当前RecycleView显示的最大条目
     */
    private int mLastVisibleItemPosition;


    /**
     * 每列的最后一个条目
     */
    private int[] mLastPostions;


    /**
     * 是否正在加载数据  包括刷新和向上加载更多
     */
    private boolean isLoadData = false;


    /**
     * 回调接口
     */
    private OnRecycleRefreshListener mListener;


    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        RecyclerView.LayoutManager layoutManager=recyclerView.getLayoutManager();
        //如果是null，第一次运行确定布局
        if(mLayoutManagerType==null){
            if(layoutManager instanceof LinearLayoutManager){
                mLayoutManagerType=LayoutManagerType.LINEAR_LAYOUT;
            }else if(layoutManager instanceof GridLayoutManager){
                mLayoutManagerType=LayoutManagerType.GRID_LAYOUT;
            }else if(layoutManager instanceof StaggeredGridLayoutManager){
                mLayoutManagerType=LayoutManagerType.STAGGERED_GRID_LAYOUT;
            }else{
                throw new RuntimeException("LayoutManager should be LinearLayoutManager,GridLayoutManager,StaggeredGridLayoutManager");
            }
        }

    }


    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
    }

    @Override
    public void onRefresh() {

    }

    /**
     * 数据加载接口回调
     */
    interface OnRecycleRefreshListener{
        void refresh();
        void loadMore();
    }



}
