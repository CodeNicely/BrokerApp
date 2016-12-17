package com.example.ujjwal.broker.SplashScreen.View;

import android.content.pm.PackageManager;

import com.example.ujjwal.broker.SplashScreen.Model.Data.SplashScreenData;

/**
 * Created by ujjwal on 11/12/16.
 */
public interface SplashScreenView {

	void onVersionRecived(SplashScreenData splashScreenData) throws PackageManager.NameNotFoundException;

	void onFailed();

	void showMessage(String message);
}
