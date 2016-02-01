package com.shendu.jthome.view.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.shendu.jthome.R;
import com.shendu.jthome.adapter.ImageZoomAdapter;
import com.shendu.jthome.base.BaseActivity;


/**
 * 浏览大图页面
 */
public class ImageZoom extends BaseActivity {

    private ViewPager viewPager;
    private ImageZoomAdapter adapter;
    public static String pic_url[];//图片地址
    private ImageView dots[];//小圆点图片
    private LinearLayout dot_ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_zoom);
        initData();
        initView();

    }

    @Override
    public void initView() {

        adapter = new ImageZoomAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setDot(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public void initData() {
        pic_url = getIntent().getStringArrayExtra("pic_url");
        dot_ll = (LinearLayout) findViewById(R.id.dot_ll);
        setDot(0);

    }

    private void setDot(int position) {

        //初始化小点
        dots = new ImageView[pic_url.length];
        for (int i = 0; i < pic_url.length; i++) {
            dots[i] = new ImageView(context);
            if (i == position) {
                dots[i].setImageResource(R.mipmap.light_dot);
            } else {
                dots[i].setImageResource(R.mipmap.dim_dot);// 都设为灰色
            }

            if (i != 0) {
                dots[i].setPadding(30, 0, 0, 0);
            }
        }

        dot_ll.removeAllViews();
        for (int j = 0; j < dots.length; j++) {
            dot_ll.addView(dots[j], j);
        }

    }

    @Override
    public void onClick(View view) {

    }
}
