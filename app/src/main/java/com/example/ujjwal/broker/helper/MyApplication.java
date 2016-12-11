package com.example.ujjwal.broker.helper;

import android.app.Application;
import android.content.Context;
import android.util.Log;


import com.google.firebase.iid.FirebaseInstanceId;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;
/**
 * Created by ujjwal on 11/12/16.
 */
public class MyApplication extends Application {

	public static Context context;
	public static String fcm_token;



	public static String getFcm_token() {
		Log.d(TAG,"fcm Token is"+fcm_token);
			return fcm_token;
	}
	public static Context getContext(){
		return context;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		context=this;

		//	FontsOverride.setDefaultFont(this, "SERIF", "fonts/nunito.ttf");
		//   FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/patrick_hand.ttf");
		fcm_token = FirebaseInstanceId.getInstance().getToken();

	}
}
