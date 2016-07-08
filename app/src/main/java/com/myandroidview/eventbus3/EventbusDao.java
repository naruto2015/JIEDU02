package com.myandroidview.eventbus3;

import java.util.ArrayList;

/**
 * Created by naruto on 2016/7/6.
 */
public interface EventbusDao {

    public void insert(EventBusBean busBean);

    public ArrayList<EventBusBean> getAll();

    public boolean deletAll();

}
