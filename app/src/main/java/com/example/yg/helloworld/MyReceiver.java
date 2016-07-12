package com.example.yg.helloworld;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by yg on 2016/4/21.
 */
public class MyReceiver extends BroadcastReceiver {
    public void onReceive(Context context,Intent intent){
        Toast.makeText(context,"检测到意图",Toast.LENGTH_LONG).show();
    }
}
