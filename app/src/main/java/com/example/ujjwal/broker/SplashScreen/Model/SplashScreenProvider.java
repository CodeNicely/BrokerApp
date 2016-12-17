package com.example.ujjwal.broker.SplashScreen.Model;

import com.example.ujjwal.broker.SplashScreen.SplashScreenCallback;

/**
 * Created by ujjwal on 11/12/16.
 */
public interface SplashScreenProvider {
	void sendFcm  (String fcm ,SplashScreenCallback splashScreenCallback);
}
