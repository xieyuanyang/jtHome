package com.shendu.jthome.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.shendu.jthome.R;
import com.shendu.jthome.model.Message;
import com.shendu.jthome.util.ParseEmojiMsgUtil;
import com.shendu.jthome.util.SelectFaceHelper;
import com.shendu.jthome.util.Util;
import com.shendu.jthome.view.activity.ImageZoom;
import com.shendu.jthome.view.myview.listview.ListViewForScrollView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/1/12.
 */
public class LatestAdapter extends BaseAdapter {

    private Context ct;
    private PopupWindow popupWindow;
    private SelectFaceHelper mFaceHelper;
    View addFaceToolView;
    Button mFaceBtn;
    EditText mEditMessageEt;
    private boolean isVisbilityFace;
    private LatestListViewAdapter latestListViewAdapter;
    private Button mSentBtn;//发送
    private String comments_content;
    private JSONArray commentsArray;
    private List<Message> mData = new ArrayList<Message>();
    private static boolean isReplay = false;//判断是回复还是评论
    private String pic_url[] = new String[]{
            "http://d.ifengimg.com/mw978_mh598/y0.ifengimg.com/a/2016_03/f557c7da2f5a1df.jpg",
            "http://d.ifengimg.com/mw978_mh598/y0.ifengimg.com/a/2016_03/f557c7da2f5a1df.jpg",
            "http://d.ifengimg.com/mw978_mh598/y0.ifengimg.com/a/2016_03/f557c7da2f5a1df.jpg"
    };//图片地址
    private LatestGridViewAdapter gridViewAdapter;

    public LatestAdapter(Context ct) {
        this.ct = ct;
        commentsArray = new JSONArray();
        latestListViewAdapter = new LatestListViewAdapter(ct, mData, isReplay);
        gridViewAdapter = new LatestGridViewAdapter(ct, pic_url);

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
        final ViewHolder holder;
        LayoutInflater layoutInflator = LayoutInflater.from(ct);

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = layoutInflator.inflate(R.layout.item_latest_listview,
                    null);
            holder.dz_tv = (TextView) convertView.findViewById(R.id.dz_tv);
            holder.write_iv = (ImageView) convertView.findViewById(R.id.write_iv);
            holder.id_listView = (ListViewForScrollView) convertView.findViewById(R.id.id_listView);
            holder.comments_ll = (LinearLayout) convertView.findViewById(R.id.comments_ll);
            holder.gridView = (GridView) convertView.findViewById(R.id.gridView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // 构造多个超链接的html, 通过选中的位置来获取用户名
        StringBuilder sbBuilder = new StringBuilder();
        for (int j = 0; j < 3; j++) {
            sbBuilder.append("username-" + j + ",");
        }
        String likeUsers = sbBuilder.substring(0, sbBuilder.lastIndexOf(",")).toString();
        holder.dz_tv.setMovementMethod(LinkMovementMethod.getInstance());
        holder.dz_tv.setText(addClickablePart(likeUsers), TextView.BufferType.SPANNABLE);
        holder.id_listView.setAdapter(latestListViewAdapter);
        holder.gridView.setAdapter(gridViewAdapter);

        //查看浏览大图
        holder.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ct, ImageZoom.class);
                intent.putExtra("pic_url", pic_url);
                ct.startActivity(intent);
            }
        });

        //点击回复
        holder.id_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isReplay = true;
                        new PopupWindows(holder.id_listView);
                    }
                }, 0);
            }
        });

        //点击评论
        holder.comments_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isReplay = false;
                        new PopupWindows(holder.write_iv);
                    }
                }, 0);
            }
        });


        return convertView;
    }

    class ViewHolder {
        LinearLayout comments_ll;
        ImageView write_iv;
        TextView dz_tv;
        ListViewForScrollView id_listView;
        GridView gridView;

    }


    /**
     * 点赞
     *
     * @param str
     * @return
     */
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
                        ds.setColor(Color.BLUE); // 设置文本颜色
                        // 去掉下划线
                        ds.setUnderlineText(false);
                    }

                }, start, start + name.length(), 0);
            }
        }
        return ssb.insert(1, 3 + "");
    }

    /**
     * 评论弹窗
     */
    public class PopupWindows extends PopupWindow {

        public PopupWindows(View parent) {

            View view = View.inflate(ct, R.layout.item_comments_popwindow, null);
            addFaceToolView = view.findViewById(R.id.add_tool);
            mFaceBtn = (Button) view.findViewById(R.id.btn_to_face);
            mEditMessageEt = (EditText) view.findViewById(R.id.mEditMessageEt);
            mSentBtn = (Button) view.findViewById(R.id.btnSend);
            mFaceBtn.setOnClickListener(faceClick);

            setFocusable(true);

            //发送评论
            mSentBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    String msg = mEditMessageEt.getText().toString();
                    if (msg.equals("")) {
                        return;
                    }
                    Message mMessage = new Message();
                    String msgStr = ParseEmojiMsgUtil.convertToMsg(mEditMessageEt.getText(), ct);// 这里不要直接用mEditMessageEt.getText().toString();
                    mMessage.setContent(msgStr);
                    mMessage.setSend(true);
                    mMessage.setIsReplay(isReplay);
                    mMessage.setTime(Util.getDate());
                    mData.add(mMessage);
                    latestListViewAdapter.notifyDataSetChanged();
                    mEditMessageEt.setText("");
                    dismiss();


                }
            });

            //设置点击消失
            view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    dismiss();
                    isVisbilityFace = false;
                    addFaceToolView.setVisibility(View.GONE);
                    mFaceHelper = null;
                    return false;
                }
            });

            //点击输入框时表情栏消失
            mEditMessageEt.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {

                    isVisbilityFace = false;
                    addFaceToolView.setVisibility(View.GONE);
                    return false;
                }
            });


            //软键盘不会挡着popupwindow
            setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
            setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
            setBackgroundDrawable(new BitmapDrawable());
            setOutsideTouchable(true);
            setContentView(view);
            showAtLocation(parent, Gravity.BOTTOM, 0, 0);
            update();
        }
    }

    /**
     * 判断是否打开表情界面
     */
    View.OnClickListener faceClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (null == mFaceHelper) {
                mFaceHelper = new SelectFaceHelper(ct, addFaceToolView);
                mFaceHelper.setFaceOpreateListener(mOnFaceOprateListener);
                hideInputManager();
            }
            if (isVisbilityFace) {
                isVisbilityFace = false;
                addFaceToolView.setVisibility(View.GONE);
                hideInputManager();
            } else {
                isVisbilityFace = true;
                addFaceToolView.setVisibility(View.VISIBLE);
                hideInputManager();
            }
        }
    };


    /**
     * 表情选择监听
     */
    SelectFaceHelper.OnFaceOprateListener mOnFaceOprateListener = new SelectFaceHelper.OnFaceOprateListener() {
        @Override
        public void onFaceSelected(SpannableString spanEmojiStr) {
            if (null != spanEmojiStr) {
                mEditMessageEt.append(spanEmojiStr);
            }
        }

        @Override
        public void onFaceDeleted() {
            int selection = mEditMessageEt.getSelectionStart();
            String text = mEditMessageEt.getText().toString();
            if (selection > 0) {
                String text2 = text.substring(selection - 1);
                if ("]".equals(text2)) {
                    int start = text.lastIndexOf("[");
                    int end = selection;
                    mEditMessageEt.getText().delete(start, end);
                    return;
                }
                mEditMessageEt.getText().delete(selection - 1, selection);
            }
        }

    };


    /**
     * 隐藏软键盘
     */
    public void hideInputManager() {

        InputMethodManager imm = (InputMethodManager) ct.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mEditMessageEt.getWindowToken(), 0); //强制隐藏键盘
    }


}
