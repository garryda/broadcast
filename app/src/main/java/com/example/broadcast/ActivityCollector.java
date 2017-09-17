package com.example.broadcast;

import android.app.Activity;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘鹏达 on 2017/9/17.
 */

public class ActivityCollector {
    public static List<Activity> activities=new ArrayList<>();
    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    public static void finishAll(){
        for (Activity activity:activities){
            if(!activity.isFinishing()){   //为什么会多出这一句，因为没有在运行的activity，可能会因为系统资源不足而被回收，所以需要多出这个判断，判断activity是否已经被回收了
                activity.finish();
            }
        }
    }
}
