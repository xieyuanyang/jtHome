package com.shendu.jthome.http;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.easemob.easeui.controller.EaseUI;

public class VolleyApplication extends Application {

    /**
     * 01. 建立  请求队列
     * 02. 将 请求队列 加入到 AndroidMain.xml中
     * 03.
     */

    private static RequestQueue queue;

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        EaseUI.getInstance().init(this);
        queue = Volley.newRequestQueue(getApplicationContext());
    }

    //入口
    public static RequestQueue getQueue() {
        return queue;
    }


}
