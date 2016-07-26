package com.myandroidview.recycleview;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.myandroidview.activity.R;

import utils.DividerItemDecoration;

public class SwipeRefreshActivity extends AppCompatActivity implements LoadDataScrollController.OnRecycleRefreshListener {

    /*
     使用原生的SwipeRefreshLayout和代码判断
     实现RecyclewView 的刷新和加载更多
     */

    private SwipeRefreshLayout mSwipeRefresh;

    private RecyclerView mRecycle;

    private HomeAdapter mAdapter;

    private LoadDataScrollController mController;


    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh);

        mRecycle= (RecyclerView) findViewById(R.id.recycle);
        mSwipeRefresh= (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);

        mSwipeRefresh.setColorSchemeColors(Color.RED,Color.GREEN, Color.BLUE);
        /**
         * 创建控制器，同时使当前activity实现数据监听回调接口
         */
        mController=new LoadDataScrollController(this);
         mAdapter=new HomeAdapter();
        //设置垂直的线性布局管理器，Orientation -->   VERTICAL:垂直   HORIZONTAL:水平
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

        //添加分割线
        mRecycle.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL_LIST));

        mRecycle.setLayoutManager(layoutManager);
        mRecycle.setItemAnimator(new DefaultItemAnimator());
        mRecycle.setAdapter(mAdapter);
        mAdapter.refresh();

        mRecycle.setOnScrollListener(mController);
        mSwipeRefresh.setOnRefreshListener(mController);

    }

    @Override
    public void refresh() {

        //刷新的接口回调
        mSwipeRefresh.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.refresh();
                mSwipeRefresh.setRefreshing(false);
                mController.setLoadDataStatus(false);
            }
        },2000);
    }

    @Override
    public void loadMore() {

        //加载更多的接口回调
        pd=new ProgressDialog(this);
        pd.show();
        mSwipeRefresh.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.add();
                mController.setLoadDataStatus(false);
                pd.dismiss();
            }
        }, 2000);


    }





}
