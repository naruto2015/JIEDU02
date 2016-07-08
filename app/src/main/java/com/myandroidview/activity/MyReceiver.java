package com.myandroidview.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by naruto on 2016/6/30.
 */
public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_USER_PRESENT)){
             //Log.e("hg","收到广播");
            //Toast.makeText(context,"收到广播",Toast.LENGTH_SHORT).show();
        }
    }

}
