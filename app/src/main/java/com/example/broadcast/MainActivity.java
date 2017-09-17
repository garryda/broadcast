package com.example.broadcast;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
需求：发出一条广播，强制所有的活动死亡，然后返回到登陆界面
前提条件：每个活动都可以注册注销广播，且只是栈顶的活动才能进行接收广播
处理过程：
1）写好活动管理类
2）写好基础activity类，其有内部类（也就是广播类），且在onResume()和onPause()方法中进行注册和注销操作
3）在需要发送的广播的地方，发送广播且创建新的intent进行跳转首页
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt=(Button)findViewById(R.id.sendReceiver);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.example.broadcast.finish");
                sendBroadcast(intent);
            }
        });
    }
}
