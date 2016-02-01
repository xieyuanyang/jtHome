package com.shendu.jthome.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shendu.jthome.R;


/**
 * Created by Administrator on 2016/1/8.
 */
public class FocusPageAdapter extends BaseAdapter {


    private Context ct;


    public FocusPageAdapter(Context ct) {
        this.ct = ct;

    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        LayoutInflater layoutInflator = LayoutInflater.from(ct);

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = layoutInflator.inflate(R.layout.item_focus_listview,
                    null);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        return convertView;
    }

    class ViewHolder {
        ImageView image;
        TextView title_tv;
    }

}
