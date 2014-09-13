package com.example.android_private_demo;

import io.rong.imkit.RongIM;
import android.app.Application;

public class App extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		
		// 初始化。
        RongIM.init(this, "8luwapkvuxval", R.drawable.ic_launcher);
        
        try {
            System.loadLibrary("imdemo");
        } catch (UnsatisfiedLinkError e) {
//            e.printStackTrace();
        }
	}

	
	
}
