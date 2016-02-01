package com.shendu.jthome.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;


import java.util.List;

/**
 * Created by Administrator on 2015/12/31.
 */
public class DynamicTabPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;
    private String titles[];

    public DynamicTabPagerAdapter(FragmentManager fm, List<Fragment> list, String titles[]) {
        super(fm);
        this.list = list;
        this.titles = titles;
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

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}