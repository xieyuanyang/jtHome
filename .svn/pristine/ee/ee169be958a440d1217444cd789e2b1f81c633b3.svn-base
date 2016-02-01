package com.shendu.jthome.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * activity 基础类
 *
 * @author xyy
 */
public abstract class BaseActivity extends AppCompatActivity implements
        OnClickListener {

    public static Context context;
    protected LayoutInflater layoutInflater;
    private LinearLayout back_iv, left_slidingmenu_ll, right_map, right_share_ll, right_city_ll;
    protected TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题
        super.onCreate(savedInstanceState);
        context = this;
        layoutInflater = LayoutInflater.from(this);

    }

    protected static void alert(String str) {
//        ToastZ.Toastz(context, str);
    }

//    //初始化返回
//    public void initBackView() {
//        back_iv = (LinearLayout) findViewById(R.id.back_iv);
//        if (back_iv != null) {
//            back_iv.setVisibility(View.VISIBLE);
//            back_iv.setOnClickListener(new OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    // TODO Auto-generated method stub
//                    finish();
//                }
//            });
//        }
//    }
//
//    //初始化slidingmenu按钮
//    public void initLeftSlidingMenu() {
//        left_slidingmenu_ll = (LinearLayout) findViewById(R.id.left_slidingmenu_ll);
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
//    public void initTitleView(String str) {
//        title = (TextView) findViewById(R.id.title);
//        if (title != null) {
//            title.setVisibility(View.VISIBLE);
//            title.setText(str);
//        }
//    }
//
//    //初始化地图找房按钮
//    public void initRightMapView() {
//        right_map = (LinearLayout) findViewById(R.id.right_map_ll);
//        if (right_map != null) {
//            right_map.setVisibility(View.VISIBLE);
//            right_map.setOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    alert("地图找房");
//                }
//            });
//        }
//    }
//
//    //初始化分享按钮
//    public void initRightShareView() {
//        right_share_ll = (LinearLayout) findViewById(R.id.right_share_ll);
//        if (right_share_ll != null) {
//            right_share_ll.setVisibility(View.VISIBLE);
//            right_share_ll.setOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    alert("分享");
//                }
//            });
//        }
//    }
//
//    //初始化城市选择
//    public void initRightCityView() {
//        right_city_ll = (LinearLayout) findViewById(R.id.right_city_ll);
//        if (right_city_ll != null) {
//            right_city_ll.setVisibility(View.VISIBLE);
//            right_city_ll.setOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    alert("城市选择");
//                }
//            });
//        }
//    }


    /**
     * 初始化界面
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();

}
