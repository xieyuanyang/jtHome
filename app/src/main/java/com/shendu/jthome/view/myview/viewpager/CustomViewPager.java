package com.shendu.jthome.view.myview.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 禁止viewpager滑动
 *
 * @author xyy
 */
public class CustomViewPager extends ViewPager {
    private boolean setTouchModel = false;

    public CustomViewPager(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        if (setTouchModel)
//            return super.onInterceptTouchEvent(ev);
//        else
//            return false;
//    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (setTouchModel)
            return super.onTouchEvent(ev);
        else
            return false;
    }

    //简单但重要一步，ViewPager获得touch焦点时候，阻止父层SlidingMenu的拦截
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean ret = super.dispatchTouchEvent(ev);
        if (ret) {
            requestDisallowInterceptTouchEvent(true);
        }
        return ret;
    }

}
