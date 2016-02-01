package com.shendu.jthome.view.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.shendu.jthome.R;
import com.shendu.jthome.adapter.ActAdapter;
import com.shendu.jthome.base.BaseFragment;


/**
 * 活动
 *
 * @author xyy
 */
public class ActFragment extends BaseFragment {

    private PullToRefreshListView mPullRefreshListView;
    private ActAdapter adapter;

    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.fragment_act, null);

        // 得到控件
        mPullRefreshListView = (PullToRefreshListView) view.findViewById(R.id.pull_refresh_list);

        adapter = new ActAdapter(ct);
        mPullRefreshListView.setAdapter(adapter);
        mPullRefreshListView.postDelayed(new Runnable() {
            @Override
            public void run() {

                mPullRefreshListView.onRefreshComplete();

            }
        }, 1000);

        mPullRefreshListView
                .setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onPullDownToRefresh(
                            PullToRefreshBase<ListView> refreshView) {


                    }

                    @Override
                    public void onPullUpToRefresh(
                            PullToRefreshBase<ListView> refreshView) {

                    }
                });

        mPullRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ct, "点你妹", Toast.LENGTH_LONG).show();
            }
        });



        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View view) {

    }

}
