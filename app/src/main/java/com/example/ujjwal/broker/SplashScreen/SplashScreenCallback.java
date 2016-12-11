package com.example.ujjwal.broker.SplashScreen;

import com.example.ujjwal.broker.SplashScreen.Model.Data.SplashScreenData;

/**
 * Created by ujjwal on 11/12/16.
 */
public interface SplashScreenCallback {


	void onSuccess(SplashScreenData splashScreenData);

	void onFailed();
}
