package com.shendu.jthome.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Fragemnt基础类
 *
 * @author xyy
 */
public abstract class BaseFragment extends Fragment implements OnClickListener {

    public View view;
    protected static Context ct;
    private LinearLayout back_iv, left_slidingmenu_ll, right_map, right_share_ll, right_city_ll;
    protected TextView title;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        ct = getActivity();
    }

    /**
     * setContentView;
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initData(savedInstanceState);
        view = initView(inflater);

        return view;
    }


//    //初始化返回
//    public void initBackView(View view) {
//        back_iv = (LinearLayout) view.findViewById(R.id.back_iv);
//        if (back_iv != null) {
//            back_iv.setVisibility(View.VISIBLE);
//            back_iv.setOnClickListener(new OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    // TODO Auto-generated method stub
//                    getActivity().finish();
//                }
//            });
//        }
//    }
//
//    //初始化slidingmenu按钮
//    public void initLeftSlidingMenu(View view) {
//        left_slidingmenu_ll = (LinearLayout) view.findViewById(R.id.left_slidingmenu_ll);
//        if (left_slidingmenu_ll != null) {
//            left_slidingmenu_ll.setVisibility(View.VISIBLE);
//            left_slidingmenu_ll.setOnClickListener(new OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    // TODO Auto-generated method stub
//                    MainActivity.menu.toggle();
//                }
//            });
//        }
//    }
//
//    //初始化标题
//    public void initTitleView(View view, String str) {
//        title = (TextView) view.findViewById(R.id.title);
//        if (title != null) {
//            title.setVisibility(View.VISIBLE);
//            title.setText(str);
//        }
//    }
//
//    //初始化地图找房按钮
//    public void initRightMapView(View view) {
//        right_map = (LinearLayout) view.findViewById(R.id.right_map_ll);
//        if (right_map != null) {
//            right_map.setVisibility(View.VISIBLE);
//            alert("地图找房");
//        }
//    }
//
//    //初始化分享按钮
//    public void initRightShareView(View view) {
//        right_share_ll = (LinearLayout) view.findViewById(R.id.right_share_ll);
//        if (right_share_ll != null) {
//            right_share_ll.setVisibility(View.VISIBLE);
//            alert("分享");
//        }
//    }
//
//    //初始化城市选择
//    public void initRightCityView(View view) {
//        right_city_ll = (LinearLayout) view.findViewById(R.id.right_city_ll);
//        if (right_city_ll != null) {
//            right_city_ll.setVisibility(View.VISIBLE);
//            alert("城市定位");
//        }
//    }


    /**
     * 初始化界面
     */
    public abstract View initView(LayoutInflater inflater);

    /**
     * 初始化数据
     */
    public abstract void initData(Bundle savedInstanceState);

    /**
     * Toast
     *
     * @param str
     */
    protected static void alert(String str) {
//        ToastZ.Toastz(ct, str);
    }


}
