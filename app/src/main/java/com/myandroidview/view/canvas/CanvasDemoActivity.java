package com.myandroidview.view.canvas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.myandroidview.activity.R;

import java.util.ArrayList;

public class CanvasDemoActivity extends AppCompatActivity {

    PieView pieView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas_demo);

        pieView= (PieView) findViewById(R.id.pieview);
        pieView.setStartAngle(0);
        ArrayList mData=new ArrayList<PieData>();
        for(int i=0;i<5;i++){
            PieData pieData=new PieData();
            pieData.value=10+i*10;
            mData.add(pieData);
        }
        pieView.setData(mData);
    }

}
