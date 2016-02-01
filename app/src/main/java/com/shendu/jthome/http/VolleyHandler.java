package com.shendu.jthome.http;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;


/**
 * 抽象出 成功的监听和失败的监听
 * 用来回调信息
 *
 * @param <T>
 * @author yuan
 */

public abstract class VolleyHandler<T> {


    protected CustomProgressDialog progressDialog;


    public Response.Listener<T> reqLis;
    public Response.ErrorListener reqErr;
    private Context ct;

    public VolleyHandler(Context ct, CustomProgressDialog progressDialog) {
        // 初始化 变量
        this.ct = ct;
        this.progressDialog = progressDialog;
        reqLis = new reqListener();
        reqErr = new reqErrorListener();

    }

    public abstract void reqSuccess(T response);

    public abstract void reqError(String error);

    /**
     * 成功后的监听
     *
     * @author yuan
     */
    public class reqListener implements Response.Listener<T> {

        @Override
        public void onResponse(T response) {
            // 使用抽象函数 设置 回调函数 reqSuccess

            if (progressDialog != null) {
                progressDialog.dismiss(ct, progressDialog);
            }

            reqSuccess(response);
        }
    }

    /**
     * 失败后的监听
     *
     * @author yuan
     */
    public class reqErrorListener implements Response.ErrorListener {

        @Override
        public void onErrorResponse(VolleyError error) {
            // 设置回调函数 使用 抽象方法 ReqError

            if (progressDialog != null) {
                progressDialog.dismiss(ct, progressDialog);
            }
            Toast.makeText(ct, VolleyErrorHelper.getMessage(error, ct),
                    Toast.LENGTH_LONG).show();

            reqError(error.getMessage());
        }

    }

}
