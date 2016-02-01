package com.shendu.jthome.view.myview.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ListView;

import com.shendu.jthome.view.myview.gesture.MyGestureListener;

/**
 * Created by Administrator on 2016/1/19.
 * <p>
 * 解决listView和slidingMenu的冲突问题
 */
public class ListViewForSlidingMenu extends ListView {

    GestureDetector gestureDetector;
    MyGestureListener myGestureListener;


    public ListViewForSlidingMenu(Context context) {
        super(context);

    }

    public ListViewForSlidingMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        myGestureListener = new MyGestureListener();
        gestureDetector = new GestureDetector(context, myGestureListener);
    }

    public ListViewForSlidingMenu(Context context, AttributeSet attrs,
                                  int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 重写此方法将触控事件优先分发给GestureDetector，以解决滑动ListView无法切换屏幕的问题、
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        this.gestureDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }


}
