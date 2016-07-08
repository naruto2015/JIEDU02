package com.myandroidview.eventbus3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by naruto on 2016/7/6.
 */
public class DBHelper extends SQLiteOpenHelper{


    private static String DB_NAME="MY_DB";
    private static final int VERSION=1;
    private static final String SQL_CREATE="create table event_bus(id integer primary key autoincrement,time varchar(30))";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }



}
