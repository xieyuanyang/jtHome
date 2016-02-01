package com.shendu.jthome.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.shendu.jthome.R;
import com.shendu.jthome.adapter.HotDoorAdapter;
import com.shendu.jthome.base.BaseFragment;
import com.shendu.jthome.view.myview.staggeredgridview.PullToRefreshStaggeredGridView;
import com.shendu.jthome.view.myview.staggeredgridview.StaggeredGridView;


/**
 * 热门
 */
public class HotDoorFragment extends BaseFragment implements
        PullToRefreshBase.OnRefreshListener<StaggeredGridView> {

    private StaggeredGridView mDongTaiGridView;
    /**
     * 下来刷新
     **/
    private PullToRefreshStaggeredGridView mPullToRefreshStaggerdGridView;
    private HotDoorAdapter adapter;

    String[] titles = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"};

    String[] imageUrls = new String[]{
            "http://file.bmob.cn/M00/D9/44/oYYBAFSGZlyAXZjwAAC5ynS9Zww4985471",
            "http://file.bmob.cn/M00/D8/8F/oYYBAFSFh_WAB_uIAAB4PTlS6rI0966668",
            "http://file.bmob.cn/M00/D7/56/oYYBAFSBhJSAIdIJAACoNxTDcM44444974",
            "http://file.bmob.cn/M00/D9/45/oYYBAFSGZvKAdpqWAACKHHYyClU0459660",
            "http://file.bmob.cn/M00/D9/45/oYYBAFSGZreAEyRSAADfcLFM62U5428980",
            "http://file.bmob.cn/M00/D9/44/oYYBAFSGZlyAXZjwAAC5ynS9Zww4985471",
            "http://file.bmob.cn/M00/D9/44/oYYBAFSGZYqAUYxAAADSNZMdbOs5036914",
            "http://file.bmob.cn/M00/D9/43/oYYBAFSGZRCATj2XAADDaZB1Nbo6433800",
            "http://file.bmob.cn/M00/D9/41/oYYBAFSGZJKAWXyDAADPOI8iH6Q3523485",
            "http://file.bmob.cn/M00/D8/8F/oYYBAFSFiE6AbAu2AACfguCRGHY3486277",
            "http://file.bmob.cn/M00/D8/8F/oYYBAFSFh_WAB_uIAAB4PTlS6rI0966668",
            "http://file.bmob.cn/M00/D7/57/oYYBAFSBhd-Aa1IiAAC86WAfmc89917549",
            "http://file.bmob.cn/M00/D7/56/oYYBAFSBhJSAIdIJAACoNxTDcM44444974",
            "http://file.bmob.cn/M00/D7/55/oYYBAFSBgiKAC2aGAAC4We1hZmk1405980",
            "http://file.bmob.cn/M00/D7/56/oYYBAFSBgrmAXQ8BAAD665llCTc5545260",
            "http://file.bmob.cn/M00/D7/56/oYYBAFSBg-CAePQKAAC38mflwMY8903422"
    };

    @Override
    public View initView(LayoutInflater inflater) {

        view = inflater.inflate(R.layout.fragment_hot_door, null);
        mPullToRefreshStaggerdGridView = (PullToRefreshStaggeredGridView) view
                .findViewById(R.id.pull_grid_view);
        mPullToRefreshStaggerdGridView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        mPullToRefreshStaggerdGridView.setMode(PullToRefreshBase.Mode.BOTH);
        mPullToRefreshStaggerdGridView.setOnRefreshListener(this);
        mDongTaiGridView = mPullToRefreshStaggerdGridView.getRefreshableView();
        adapter = new HotDoorAdapter(ct, imageUrls,titles);

        mDongTaiGridView.setAdapter(adapter);


        return view;
    }


    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onRefresh(PullToRefreshBase<StaggeredGridView> refreshView) {

        if (refreshView.isHeaderShown()) {

            mPullToRefreshStaggerdGridView.onRefreshComplete();
        } else {
            mPullToRefreshStaggerdGridView.onRefreshComplete();
        }

    }
}
