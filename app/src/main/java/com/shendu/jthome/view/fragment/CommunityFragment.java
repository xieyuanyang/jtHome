package com.shendu.jthome.view.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
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
import com.shendu.jthome.http.CustomProgressDialog;
import com.shendu.jthome.http.VolleyHandler;
import com.shendu.jthome.http.VolleyHttpRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * 社区
 */
public class CommunityFragment extends BaseFragment {

//    private PullToRefreshListView mPullRefreshListView;
//    private ActAdapter adapter;

    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.fragment_community, null);
        // 得到控件
//        mPullRefreshListView = (PullToRefreshListView) view.findViewById(R.id.pull_refresh_list);
//        mPullRefreshListView
//                .setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
//                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//                    @Override
//                    public void onPullDownToRefresh(
//                            PullToRefreshBase<ListView> refreshView) {
//
//
//                    }
//
//                    @Override
//                    public void onPullUpToRefresh(
//                            PullToRefreshBase<ListView> refreshView) {
//
//                    }
//                });
//        adapter = new ActAdapter(ct);
//        mPullRefreshListView.setAdapter(adapter);
//        mPullRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(ct, "点你妹", Toast.LENGTH_LONG).show();
//            }
//        });
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View view) {

    }


//    private void volleyTest() {
//
//        Map<String, String> map;
//        map = new HashMap<String, String>();
//
//        VolleyHandler<String> volleyRequest = new VolleyHandler<String>(ct, CustomProgressDialog.show("正在加载哦",
//                ct)) {
//
//            @Override
//            public void reqSuccess(String response) {
//                // 成功的回调 : 可以操作返回的数据
//
//                mPullRefreshListView.onRefreshComplete();
//                Log.e("成功", "response=" + response.toString());
//            }
//
//            @Override
//            public void reqError(String error) {
//                // 失败的回调 ：失败的提醒
//                mPullRefreshListView.onRefreshComplete();
//            }
//        };
//
//        VolleyHttpRequest.String_request("http://lvxinapp.anyuanbao.com/api?method=getAllCaseType", map, volleyRequest);
//    }
}
