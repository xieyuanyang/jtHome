package com.shendu.jthome.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shendu.jthome.R;


/**
 * Created by WuXiaolong on 2015/9/14.
 */
public class StaggeredRecycleViewAdapter extends RecyclerView.Adapter<StaggeredRecycleViewAdapter.ViewHolder> {

    private Context mContext;

    public StaggeredRecycleViewAdapter(Context context) {
        mContext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.staggered_recycler_view_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.title.setText("" + position + "");
//        Random random = new Random(20);
        holder.title.setHeight(Integer.parseInt("" + (int) Math.random() * 50 + 400 + ""));//高度随机，下拉刷新高度会变
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public interface OnItemClickListener {
        public void onClick(View parent, int position);
    }
}
