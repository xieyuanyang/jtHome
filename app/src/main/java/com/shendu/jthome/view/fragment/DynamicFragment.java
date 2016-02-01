package com.shendu.jthome.view.fragment;


import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.shendu.jthome.R;
import com.shendu.jthome.adapter.DynamicTabPagerAdapter;
import com.shendu.jthome.base.BaseFragment;
import com.shendu.jthome.view.activity.MainActivity;
import com.shendu.jthome.view.myview.gesture.ViewPagerGestureListener;
import com.shendu.jthome.view.myview.viewpager.SliderDirectViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态 xyy
 */
public class DynamicFragment extends BaseFragment {

    private TabLayout tablayout;
    private LinearLayout left_ll;
    public static SliderDirectViewPager viewpager;
    private DynamicTabPagerAdapter tabPagerAdapter;
    private List<Fragment> list;
    private Resources rs;
    private String titles[];


    @Override
    public View initView(LayoutInflater inflater) {

        view = inflater.inflate(R.layout.fragment_dynamic, null);
        left_ll = (LinearLayout) view.findViewById(R.id.left_ll);
        left_ll.setOnClickListener(this);
        rs = getResources();
        titles = new String[]{rs.getString(R.string.dynamic_focus), rs.getString(R.string.dynamic_hot), rs.getString(R.string.dynamic_act)};

        viewpager = (SliderDirectViewPager) view.findViewById(R.id.tab_vp);
        tablayout = (TabLayout) view.findViewById(R.id.tablayout);


        tabPagerAdapter = new DynamicTabPagerAdapter(getChildFragmentManager(), list, titles);
        viewpager.setAdapter(tabPagerAdapter);


        //给tablayout设置viewpager
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        tablayout.setupWithViewPager(viewpager);

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

        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

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
        list.add(new FocusFragment());
        list.add(new HotPointFragment());
        list.add(new ActFragment());

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.left_ll:
                MainActivity.sm.toggle();
                break;
        }

    }


}
