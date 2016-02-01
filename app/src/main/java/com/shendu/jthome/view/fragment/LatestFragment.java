package com.shendu.jthome.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.shendu.jthome.R;
import com.shendu.jthome.adapter.LatestAdapter;
import com.shendu.jthome.base.BaseFragment;


/**
 * 最新
 */
public class LatestFragment extends BaseFragment {

    private PullToRefreshListView mPullRefreshListView;
    private LatestAdapter adapter;
    private TextView dz_tv;

    @Override
    public View initView(LayoutInflater inflater) {

        view = inflater.inflate(R.layout.fragment_latest, null);


        // 得到控件
        mPullRefreshListView = (PullToRefreshListView) view.findViewById(R.id.pull_refresh_list);
        mPullRefreshListView
                .setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
                    @Override
                    public void onPullDownToRefresh(
                            PullToRefreshBase<ListView> refreshView) {


                        mPullRefreshListView.onRefreshComplete();

                    }

                    @Override
                    public void onPullUpToRefresh(
                            PullToRefreshBase<ListView> refreshView) {


                        mPullRefreshListView.onRefreshComplete();
                    }
                });
        adapter = new LatestAdapter(ct);
        mPullRefreshListView.setAdapter(adapter);
        mPullRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ct, "点你妹", Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }


    private SpannableStringBuilder addClickablePart(String str) {
        // 第一个赞图标
        ImageSpan span = new ImageSpan(ct, R.mipmap.zan);
        SpannableString spanStr = new SpannableString("p.");
        spanStr.setSpan(span, 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        SpannableStringBuilder ssb = new SpannableStringBuilder(spanStr);
        ssb.append(str);
        String[] likeUsers = str.split(",");
        if (likeUsers.length > 0) {
            // 最后一个
            for (int i = 0; i < likeUsers.length; i++) {
                final String name = likeUsers[i];
                final int start = str.indexOf(name) + spanStr.length();
                ssb.setSpan(new ClickableSpan() {

                    @Override
                    public void onClick(View widget) {
                        Toast.makeText(ct, name,
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void updateDrawState(TextPaint ds) {
                        super.updateDrawState(ds);
                        ds.setColor(Color.GREEN); // 设置文本颜色
                        // 去掉下划线
                        ds.setUnderlineText(false);
                    }

                }, start, start + name.length(), 0);
            }
        }
        return ssb.append("等"
                + likeUsers.length + "个人赞了您.").insert(1, 10 + "");
    } // end of addClickablePart


    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View view) {

    }
}
