package com.shendu.jthome.view.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.shendu.jthome.R;
import com.shendu.jthome.adapter.FocusPageAdapter;
import com.shendu.jthome.base.BaseFragment;


/**
 * 关注
 *
 * @author xyy
 */
public class FocusFragment extends BaseFragment {

    private PullToRefreshListView mPullRefreshListView;
    private FocusPageAdapter adapter;

    @Override
    public View initView(LayoutInflater inflater) {

        view = inflater.inflate(R.layout.fragment_focus, null);
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
        adapter = new FocusPageAdapter(ct);
        mPullRefreshListView.setAdapter(adapter);


        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View view) {

    }
}
