package com.shendu.jthome.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.shendu.jthome.view.activity.ImageZoom;
import com.shendu.jthome.view.fragment.ImageZoomFragment;


/**
 * Created by Administrator on 2016/1/15.
 */
public class ImageZoomAdapter extends FragmentStatePagerAdapter {


    public ImageZoomAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ImageZoomFragment.newInstance(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_UNCHANGED;
    }

    @Override
    public int getCount() {
        return ImageZoom.pic_url.length;
    }
}
