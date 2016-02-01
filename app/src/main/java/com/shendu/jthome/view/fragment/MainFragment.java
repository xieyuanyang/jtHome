package com.shendu.jthome.view.fragment;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.shendu.jthome.R;
import com.shendu.jthome.base.BaseFragment;
import com.shendu.jthome.view.myview.viewpager.CustomViewPager;
import com.shendu.jthome.view.myview.scrollview.ViewPagerScroller;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页主Fragment
 *
 * @author xyy
 */
public class MainFragment extends BaseFragment {


    private CustomViewPager viewpager;
    private List<Fragment> list = new ArrayList<Fragment>();
    private HomePagerAdapter homeAdapter;
    private RadioGroup main_radio;
    private RadioButton radio_dynamic, radio_community, radio_circle, radio_chat, radio_find;
    private TextView title_tv;
    private Resources rs;
    private String titles[];


    @Override
    public View initView(LayoutInflater inflater) {

        view = inflater.inflate(R.layout.fragment_main, null);


        viewpager = (CustomViewPager) view.findViewById(R.id.viewpager);
        viewpager.setCurrentItem(0, false);


        //这个是设置viewPager切换过度时间的类
        ViewPagerScroller scroller = new ViewPagerScroller(ct);
        scroller.setScrollDuration(0);
        scroller.initViewPagerScroll(viewpager);

//        rs = getResources();
//        titles = new String[]{rs.getString(R.string.jt_home), rs.getString(R.string.all_plate), "", rs.getString(R.string.chat), rs.getString(R.string.find)};
//        title_tv = (TextView) view.findViewById(R.id.title_tv);
//        title_tv.setText(titles[0]);

        homeAdapter = new HomePagerAdapter(getActivity()
                .getSupportFragmentManager());
        viewpager.setAdapter(homeAdapter);


        radio_dynamic = (RadioButton) view.findViewById(R.id.radio_dynamic);
        radio_community = (RadioButton) view.findViewById(R.id.radio_community);
        radio_circle = (RadioButton) view.findViewById(R.id.radio_circle);
        radio_find = (RadioButton) view.findViewById(R.id.radio_find);
        radio_chat = (RadioButton) view.findViewById(R.id.radio_chat);

        main_radio = (RadioGroup) view.findViewById(R.id.main_radio);
        main_radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int checkId) {
                // TODO Auto-generated method stub

                switch (checkId) {

                    case R.id.radio_dynamic:
                        viewpager.setCurrentItem(0);
//                        title_tv.setText(titles[0]);
                        break;
                    case R.id.radio_community:
                        viewpager.setCurrentItem(1);
//                        title_tv.setText(titles[1]);
                        break;
                    case R.id.radio_circle:
                        viewpager.setCurrentItem(2);
//                        title_tv.setText(titles[2]);
                        break;
                    case R.id.radio_chat:
                        viewpager.setCurrentItem(3);
//                        title_tv.setText(titles[3]);
                        break;
                    case R.id.radio_find:
                        viewpager.setCurrentItem(4);
//                        title_tv.setText(titles[4]);
                        break;
                }
            }
        });


        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {


        list.add(new DynamicFragment());
        list.add(new CommunityFragment());
        list.add(new CircleFragment());
        list.add(new ChatFragment());
        list.add(new FindFragment());


    }

    @Override
    public void onClick(View view) {

    }

    class HomePagerAdapter extends FragmentStatePagerAdapter {

        public HomePagerAdapter(FragmentManager fm) {
            super(fm);
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


}
