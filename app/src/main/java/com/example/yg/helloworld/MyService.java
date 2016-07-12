package com.example.yg.helloworld;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by yg on 2016/4/21.
 */
public class MyService extends Service {
    public IBinder onBind(Intent arg0){
        return null;
    }
    public int onStartCommand(Intent intent,int flags,int startId){
        Toast.makeText(this,"Service onStarted",Toast.LENGTH_LONG).show();
        return START_STICKY;
    }
    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"Service onDestroy",Toast.LENGTH_LONG).show();
    }
}
