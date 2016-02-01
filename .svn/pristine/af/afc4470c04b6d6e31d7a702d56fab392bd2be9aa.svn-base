package com.shendu.jthome.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.shendu.jthome.R;
import com.shendu.jthome.http.VolleyHttpRequest;

/**
 * Created by Administrator on 2016/1/15.
 */
public class LatestGridViewAdapter extends BaseAdapter {

    private Context ct;
    private String pic_url[];

    public LatestGridViewAdapter(Context ct, String pic_url[]) {

        this.ct = ct;
        this.pic_url = pic_url;

    }

    @Override
    public int getCount() {
        return pic_url.length;
    }

    @Override
    public Object getItem(int i) {
        return pic_url[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();
            if (pic_url.length == 1) {
                view = LayoutInflater.from(ct).inflate(R.layout.item_latestgridview_two, null);
            } else {
                view = LayoutInflater.from(ct).inflate(R.layout.item_latestgridview, null);
            }
            holder.pic_iv = (ImageView) view.findViewById(R.id.pic_iv);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }


        VolleyHttpRequest.imageLoader(pic_url[position], holder.pic_iv, 0, 0);

        return view;
    }

    class ViewHolder {

        ImageView pic_iv;
    }
}
