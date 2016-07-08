package com.myandroidview.eventbus3;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by naruto on 2016/7/6.
 */
public class EventBusDaoImpl implements EventbusDao{

    public DBHelper dbHelper=null;
    public EventBusDaoImpl(Context context){
        dbHelper=new DBHelper(context);
    }


    @Override
    public void insert(EventBusBean busBean) {

        SQLiteDatabase sqLiteDatabase=dbHelper.getWritableDatabase();
        sqLiteDatabase.execSQL("insert into event_bus(time) values(?)",new Object[]{busBean.time});
        sqLiteDatabase.close();

    }

    @Override
    public ArrayList<EventBusBean> getAll() {
        SQLiteDatabase sqLiteDatabase=dbHelper.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from event_bus",null);
        EventBusBean busBean=null;
        ArrayList<EventBusBean> list=new ArrayList<EventBusBean>();
        while(cursor.moveToNext()){
            busBean=new EventBusBean();
            busBean.id=cursor.getInt(cursor.getColumnIndex("id"));
            busBean.time=cursor.getString(cursor.getColumnIndex("time"));
            list.add(busBean);
        }
        return list;
    }

    @Override
    public boolean deletAll() {

        SQLiteDatabase sqLiteDatabase=dbHelper.getWritableDatabase();
        sqLiteDatabase.execSQL("delete from event_bus");
        sqLiteDatabase.close();

        return false;
    }



}
