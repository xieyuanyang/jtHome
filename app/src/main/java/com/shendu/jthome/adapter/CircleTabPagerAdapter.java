package com.shendu.jthome.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/1/5.
 */
public class CircleTabPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;

    public CircleTabPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
        // TODO Auto-generated constructor stub
    }

    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

}
