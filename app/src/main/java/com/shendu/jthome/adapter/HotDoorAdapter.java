package com.shendu.jthome.adapter;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.shendu.jthome.R;
import com.shendu.jthome.http.VolleyHttpRequest;
import com.shendu.jthome.view.myview.staggeredgridview.DynamicHeightImageView;
import com.shendu.jthome.view.myview.staggeredgridview.DynamicHeightTextView;

import java.util.Random;

/**
 * Created by Administrator on 2016/1/7.
 */
public class HotDoorAdapter extends BaseAdapter {

    Context ct;
    String imageUrls[];
    String[] titles;
    private final Random mRandom;
    private static final SparseArray<Double> sPositionHeightRatios = new SparseArray<Double>();


    public HotDoorAdapter(Context ct, String imageUrls[], String[] titles) {
        this.ct = ct;
        this.imageUrls = imageUrls;
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(ct));
        this.titles = titles;
        mRandom = new Random();

    }


    @Override
    public View getView(final int position, View convertView,
                        ViewGroup parent) {


        ViewHolder holder;
        LayoutInflater layoutInflator = LayoutInflater.from(ct);

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = layoutInflator.inflate(R.layout.staggered_recycler_view_item,
                    null);
            holder.image = (DynamicHeightImageView) convertView.findViewById(R.id.iv);
            holder.title_tv = (DynamicHeightTextView) convertView.findViewById(R.id.title_tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.image.setTag(position);

        double positionHeight = getPositionRatio(position);
        holder.image.setHeightRatio(positionHeight);

        if (holder.image.getTag().equals(position)) {
            VolleyHttpRequest.imageLoader(imageUrls[position], holder.image, 0, 0);
        }

        holder.title_tv.setText(titles[position]);


        return convertView;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imageUrls.length;
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    class ViewHolder {
        DynamicHeightImageView image;
        DynamicHeightTextView title_tv;
    }


    private double getPositionRatio(final int position) {
        double ratio = sPositionHeightRatios.get(position, 0.0);
        // if not yet done generate and stash the columns height
        // in our real world scenario this will be determined by
        // some match based on the known height and width of the image
        // and maybe a helpful way to get the column height!
        if (ratio == 0) {
            ratio = getRandomHeightRatio();
            sPositionHeightRatios.append(position, ratio);
            Log.d("xyy", "getPositionRatio:" + position + " ratio:" + ratio);
        }
        return ratio;
    }

    private double getRandomHeightRatio() {
        return (mRandom.nextDouble() / 2.0) + 1.0; // height will be 1.0 - 1.5 the width
    }

}
