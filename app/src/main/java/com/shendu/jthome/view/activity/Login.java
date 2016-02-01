package com.shendu.jthome.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.easemob.EMCallBack;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMGroupManager;
import com.shendu.jthome.R;
import com.shendu.jthome.base.BaseActivity;

public class Login extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    @Override
    public void initView() {
        login();
    }

    @Override
    public void initData() {

    }


    @Override
    public void onClick(View view) {

    }

    private void login() {
        // 调用sdk登陆方法登陆聊天服务器
        EMChatManager.getInstance().login("xyy", "123456", new EMCallBack() {

            @Override
            public void onSuccess() {
//                if (!progressShow) {
//                    return;
//                }
                // 登陆成功，保存用户名
//                DemoHelper.getInstance().setCurrentUserName(currentUsername);
                // 注册群组和联系人监听
//                DemoHelper.getInstance().registerGroupAndContactListener();

                // ** 第一次登录或者之前logout后再登录，加载所有本地群和回话
                // ** manually load all local groups and
                EMGroupManager.getInstance().loadAllGroups();
                EMChatManager.getInstance().loadAllConversations();

                // 更新当前用户的nickname 此方法的作用是在ios离线推送时能够显示用户nick
//                boolean updatenick = EMChatManager.getInstance().updateCurrentUserNick(
//                        DemoApplication.currentUserNick.trim());
//                if (!updatenick) {
//                    Log.e("LoginActivity", "update current user nick fail");
//                }
                //异步获取当前用户的昵称和头像(从自己服务器获取，demo使用的一个第三方服务)
//                DemoHelper.getInstance().getUserProfileManager().asyncGetCurrentUserInfo();

//                if (!Login.this.isFinishing() && pd.isShowing()) {
//                    pd.dismiss();
//                }
                // 进入主页面
                Intent intent = new Intent(Login.this,
                        MainActivity.class);
                startActivity(intent);

                finish();
            }

            @Override
            public void onProgress(int progress, String status) {
            }

            @Override
            public void onError(final int code, final String message) {
//                if (!progressShow) {
//                    return;
//                }
                runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(getApplicationContext(), getString(R.string.Login_failed) + message,
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
