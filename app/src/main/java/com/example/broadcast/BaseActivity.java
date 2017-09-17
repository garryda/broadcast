package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {
    private ForceOfflineReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       ActivityCollector.addActivity(this);
    }
    public void onResume(){
        super.onResume();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.example.broadcast.finish");
        receiver=new ForceOfflineReceiver();
        registerReceiver(receiver,intentFilter);
    }
    public void onPause(){
        super.onPause();
        if(receiver!=null){
            unregisterReceiver(receiver);
        }
    }
    public void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
    //写下接受广播类
    class ForceOfflineReceiver extends BroadcastReceiver{
        public void onReceive(final Context context, final Intent intent){
            AlertDialog.Builder builder=new AlertDialog.Builder(context);
            builder.setTitle("Warning");
            builder.setMessage("You are forced to be offline.Please try to again");
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollector.finishAll();//销毁所有的活动
                    Intent intent=new Intent(context,Login.class);
                    startActivity(intent);
                }
            });
            builder.show();
        }
    }
}
