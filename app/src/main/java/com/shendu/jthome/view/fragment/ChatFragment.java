package com.shendu.jthome.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.easemob.easeui.EaseConstant;
import com.easemob.easeui.ui.EaseConversationListFragment;
import com.shendu.jthome.view.activity.ChatActivity;


/**
 * 聊天
 */
public class ChatFragment extends EaseConversationListFragment {


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.getBoolean("isConflict", false))
            return;
        super.onActivityCreated(savedInstanceState);

        conversationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                startActivity(new Intent(getActivity(), ChatActivity.class).putExtra(EaseConstant.EXTRA_USER_ID, "admin"));

            }
        });
    }
}
