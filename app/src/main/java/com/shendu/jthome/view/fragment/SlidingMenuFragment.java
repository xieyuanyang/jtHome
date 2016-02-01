package com.shendu.jthome.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shendu.jthome.R;
import com.shendu.jthome.base.BaseFragment;


public class SlidingMenuFragment extends BaseFragment {


    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.fragment_sliding_menu, null);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View view) {

    }
}
