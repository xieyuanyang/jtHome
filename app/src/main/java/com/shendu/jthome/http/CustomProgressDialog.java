package com.shendu.jthome.http;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.shendu.jthome.R;

public class CustomProgressDialog extends Dialog {

    private static CustomProgressDialog customProgressDialog = null;

    public CustomProgressDialog(Context context) {
        super(context);

    }

    public CustomProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    public static CustomProgressDialog createDialog(Context context) {
        customProgressDialog = new CustomProgressDialog(context, R.style.CustomProgressDialog);
        customProgressDialog.setContentView(R.layout.customprogressdialog);
        customProgressDialog.getWindow().getAttributes().gravity = Gravity.CENTER;

        return customProgressDialog;
    }


    /**
     * [Summary] setTitile 标题
     *
     * @param strTitle
     * @return
     */
    public CustomProgressDialog setTitile(String strTitle) {
        return customProgressDialog;
    }

    /**
     * [Summary] setMessage 提示内容
     *
     * @param strMessage
     * @return
     */
    public CustomProgressDialog setMessage(String strMessage) {
        TextView tvMsg = (TextView) customProgressDialog.findViewById(R.id.id_tv_loadingmsg);

        if (tvMsg != null) {
            tvMsg.setText(strMessage);
        }

        return customProgressDialog;
    }

    public static CustomProgressDialog show(String content, final Context context) {


        CustomProgressDialog progressDialog = CustomProgressDialog.createDialog(context);

        progressDialog.setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失


        //关闭dialog同时关闭当前activity
        progressDialog.setOnCancelListener(new OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                ((Activity) context).finish();
            }
        });

        //dialog转圈动画
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.large_progressbar_animator);
        ImageView imageView = (ImageView) customProgressDialog.findViewById(R.id.loadingImageView);
        imageView.startAnimation(anim);

        progressDialog.setMessage(content);
        if (!((Activity) context).isFinishing()) {
            progressDialog.show();


        }
        return progressDialog;
    }

    public static CustomProgressDialog show(Context context) {

        return CustomProgressDialog.show("数据加载中..", context);
    }

    public void dismiss(Context context, CustomProgressDialog dialog) {
        if (!((Activity) context).isFinishing()) {
            dialog.dismiss();
        }
    }
}
