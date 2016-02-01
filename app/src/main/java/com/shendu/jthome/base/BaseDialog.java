package com.shendu.jthome.base;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.shendu.jthome.R;


/**
 * Created by jkt-yf-002 on 2015/9/14.
 *
 * @author zhangxh
 */
public class BaseDialog extends Dialog {
    private Context context;
    private static BaseDialog loaddialog;
    private TextView title;
    private TextView message;
    private TextView leftbtn;
    private TextView rightbtn;
    private OnClickListener leftonclick;
    private OnClickListener rightonclick;

    public BaseDialog(Context context) {
        super(context);
        this.context = context;

        View view = View.inflate(context, R.layout.dialog_load, null);
        setContentView(view);

        initview(view);
    }

    private void initview(View view) {
        title = (TextView) view.findViewById(R.id.titletext);
        message = (TextView) view.findViewById(R.id.message);
        leftbtn = (TextView) view.findViewById(R.id.submit);
        rightbtn = (TextView) view.findViewById(R.id.cancel);
        leftbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (leftonclick != null)
                    leftonclick.onClick(loaddialog, 0);
            }
        });
        rightbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (rightonclick != null)
                    rightonclick.onClick(loaddialog, 0);
            }
        });
    }

    public static BaseDialog getDialog(Context context) {
        loaddialog = new BaseDialog(context);
        return loaddialog;
    }

    public BaseDialog setLeftonclick(OnClickListener leftonclick) {
        this.leftonclick = leftonclick;
        return loaddialog;
    }

    public BaseDialog setRightonclick(OnClickListener rightonclick) {
        this.rightonclick = rightonclick;
        return loaddialog;
    }

    /**
     * @param text
     * @return
     * @Description 设置标题文字
     */
    public BaseDialog settitle(String text) {
        title.setText(text);
        return loaddialog;
    }

    /**
     * @param msg
     * @return
     * @Description 设置内容文字
     */
    public BaseDialog setmessage(String msg) {
        message.setText(msg);
        return loaddialog;
    }

    /**
     * @param t
     * @return
     * @Description 设置左边按钮文字
     */
    public BaseDialog setleftbtntext(String t) {
        leftbtn.setText(t);
        return loaddialog;
    }

    /**
     * @param t
     * @return
     * @Description 设置右边按钮文字
     */
    public BaseDialog setrightbtntext(String t) {
        rightbtn.setText(t);
        return loaddialog;
    }


}
