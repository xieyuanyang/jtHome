package com.shendu.jthome.view.myview.gesture;

import android.view.GestureDetector;
import android.view.MotionEvent;

import com.shendu.jthome.view.activity.MainActivity;

/**
 * Created by Administrator on 2016/1/19.
 */
public class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

    private int verticalMinDistance = 8;
    private int minVelocity = 0;

    public MyGestureListener() {
        super();
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        if (e1.getX()
                - e2.getX() < verticalMinDistance && Math.abs(velocityX) > minVelocity) {
            MainActivity.sm.toggle();
        }
        return false;
    }

}