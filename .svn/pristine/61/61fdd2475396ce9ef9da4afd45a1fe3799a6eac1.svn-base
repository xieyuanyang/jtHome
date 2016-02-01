package com.shendu.jthome.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.shendu.jthome.R;
import com.shendu.jthome.model.Message;
import com.shendu.jthome.util.EmojiParser;
import com.shendu.jthome.util.ParseEmojiMsgUtil;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/14.
 * <p/>
 * 用于展示评论信息的adapter
 */
public class LatestListViewAdapter extends BaseAdapter {

    private Context ct;
    //    private JSONArray commentsArray;
    private List<Message> mData = new ArrayList<Message>();
    private boolean isReplay;//判断是回复还是评论

    public LatestListViewAdapter(Context ct, List<Message> mData, boolean isReplay) {

        this.ct = ct;
//        this.commentsArray = commentsArray;
        this.mData = mData;
        this.isReplay = isReplay;


    }

    @Override
    public int getCount() {
        return mData.size();
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
    public View getView(int position, View view, ViewGroup viewGroup) {

//        Log.e("xyyyyyyy", "data=" + mData.toString());
        ViewHolder holder;

        Message msg = mData.get(position);
        int msgType;

//        if (msg.isSend()) {
//            msgType = MSG_TYPE_MY;
//        } else {
//            msgType = MSG_TYPE_OTHER;
//        }

//        Toast.makeText(ct, "isReplay=" + isReplay, Toast.LENGTH_SHORT).show();

        if (view == null) {
            holder = new ViewHolder();
            if (msg.isReplay()) {
                view = LayoutInflater.from(ct).inflate(R.layout.item_latestlistview_two, null);
            } else {
                view = LayoutInflater.from(ct).inflate(R.layout.item_latestlistview, null);
            }

            holder.content_tv = (TextView) view.findViewById(R.id.content_tv);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        String unicode = EmojiParser.getInstance(ct).parseEmoji(msg.getContent());
        SpannableString spannableString = ParseEmojiMsgUtil.getExpressionString(ct, unicode);
        holder.content_tv.setText(spannableString);
//        holder.timeTv.setText(mData.get(position).getTime());
//        try {
//
//            if (commentsArray.getJSONObject(i).has("0")) {
//
//                holder.content_tv.setText(commentsArray.getJSONObject(i).getString("0"));
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        return view;
    }


    class ViewHolder {

        TextView content_tv;
    }
}
