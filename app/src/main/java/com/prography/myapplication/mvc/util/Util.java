package com.prography.myapplication.mvc.util;

import android.app.Activity;
import android.view.WindowManager;

public class Util {
    public static void noStatusBar(Activity activity, int layoutId){
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        activity.setContentView(layoutId);
    }
}
