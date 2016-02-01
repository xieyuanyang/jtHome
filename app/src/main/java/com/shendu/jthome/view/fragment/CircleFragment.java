package com.shendu.jthome.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shendu.jthome.R;
import com.shendu.jthome.adapter.CircleTabPagerAdapter;
import com.shendu.jthome.base.BaseFragment;
import com.shendu.jthome.view.activity.MainActivity;
import com.shendu.jthome.view.myview.gesture.ViewPagerGestureListener;
import com.shendu.jthome.view.myview.viewpager.SliderDirectViewPager;

import java.util.ArrayList;
import java.util.List;


/**
 * 圈子
 */
public class CircleFragment extends BaseFragment {


    private LinearLayout left_ll;
    private SliderDirectViewPager viewpager;
    private CircleTabPagerAdapter tabPagerAdapter;
    private List<Fragment> list;
    private LinearLayout hot_ll, latest_ll, topic_ll;
    private TextView hot_tv, latest_tv, topic_tv;
    private FrameLayout hot_fl, latest_fl, topic_fl;


    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.fragment_circle, null);

        left_ll = (LinearLayout) view.findViewById(R.id.left_ll);
        left_ll.setOnClickListener(this);

        //toolbar顶部滑动tab
        hot_fl = (FrameLayout) view.findViewById(R.id.hot_fl);
        latest_fl = (FrameLayout) view.findViewById(R.id.latest_fl);
        topic_fl = (FrameLayout) view.findViewById(R.id.topic_fl);
        hot_ll = (LinearLayout) view.findViewById(R.id.hot_ll);
        latest_ll = (LinearLayout) view.findViewById(R.id.latest_ll);
        topic_ll = (LinearLayout) view.findViewById(R.id.topic_ll);
        hot_tv = (TextView) view.findViewById(R.id.hot_tv);
        latest_tv = (TextView) view.findViewById(R.id.latest_tv);
        topic_tv = (TextView) view.findViewById(R.id.topic_tv);
        hot_fl.setOnClickListener(this);
        latest_fl.setOnClickListener(this);
        topic_fl.setOnClickListener(this);


        viewpager = (SliderDirectViewPager) view.findViewById(R.id.tab_vp);
        tabPagerAdapter = new CircleTabPagerAdapter(getChildFragmentManager(), list);
        viewpager.setAdapter(tabPagerAdapter);

        viewpager.setMyDirectListener(new SliderDirectViewPager.MyDirectListener() {

            @Override
            public void getsliderLister(int direct) {
                // TODO Auto-generated method stub

                switch (direct) {
                    case 0:

                        MainActivity.sm.toggle();

                        break;

                    case 1:
                        break;
                }
            }
        });


        //页面切换,改变顶部状态
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageSelected(int arg0) {


                switch (arg0) {
                    case 0:
                        choosePager(0);
                        break;
                    case 1:
                        choosePager(1);
                        break;
                    case 2:
                        choosePager(2);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });

        return view;
    }

    /**
     * 继承GestureListener，重写left和right方法
     */
    private class MyViewPagerGestureListener extends ViewPagerGestureListener {
        public MyViewPagerGestureListener(Context context) {
            super(context);
        }

        @Override
        public boolean left() {
            Log.e("------>>test", "向左滑");
            return super.left();
        }

        @Override
        public boolean right() {
            Log.e("----->>test", "向右滑");
            return super.right();
        }
    }

    @Override
    public void initData(Bundle savedInstanceState) {

        list = new ArrayList<Fragment>();
        list.add(new HotDoorFragment());
        list.add(new LatestFragment());
        list.add(new TopicFragment());

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.left_ll:
                break;
            case R.id.hot_fl:
                viewpager.setCurrentItem(0);
                choosePager(0);
                break;
            case R.id.latest_fl:
                viewpager.setCurrentItem(1);
                choosePager(1);
                break;
            case R.id.topic_fl:
                viewpager.setCurrentItem(2);
                choosePager(2);
                break;
        }
    }

    /**
     * 不同页面不同状态
     *
     * @param position
     */
    private void choosePager(int position) {

        switch (position) {
            case 0:
                hot_ll.setVisibility(View.VISIBLE);
                latest_ll.setVisibility(View.GONE);
                topic_ll.setVisibility(View.GONE);
                hot_tv.setTextColor(getResources().getColor(R.color.white));
                latest_tv.setTextColor(getResources().getColor(R.color.top_tab_press));
                topic_tv.setTextColor(getResources().getColor(R.color.top_tab_press));
                break;
            case 1:
                viewpager.setCurrentItem(1);
                hot_ll.setVisibility(View.GONE);
                latest_ll.setVisibility(View.VISIBLE);
                topic_ll.setVisibility(View.GONE);
                hot_tv.setTextColor(getResources().getColor(R.color.top_tab_press));
                latest_tv.setTextColor(getResources().getColor(R.color.white));
                topic_tv.setTextColor(getResources().getColor(R.color.top_tab_press));
                break;
            case 2:
                hot_ll.setVisibility(View.GONE);
                latest_ll.setVisibility(View.GONE);
                topic_ll.setVisibility(View.VISIBLE);
                hot_tv.setTextColor(getResources().getColor(R.color.top_tab_press));
                latest_tv.setTextColor(getResources().getColor(R.color.top_tab_press));
                topic_tv.setTextColor(getResources().getColor(R.color.white));
                break;
        }

    }
}
