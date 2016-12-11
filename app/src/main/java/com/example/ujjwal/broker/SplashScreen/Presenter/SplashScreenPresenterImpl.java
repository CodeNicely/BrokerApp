package com.example.ujjwal.broker.SplashScreen.Presenter;


import android.content.pm.PackageManager;

import com.example.ujjwal.broker.SplashScreen.Model.Data.SplashScreenData;
import com.example.ujjwal.broker.SplashScreen.Model.SplashScreenProvider;
import com.example.ujjwal.broker.SplashScreen.SplashScreenCallback;
import com.example.ujjwal.broker.SplashScreen.View.SplashScreenView;

/**
 * Created by ujjwal on 11/12/16.
 */
public class SplashScreenPresenterImpl implements SplashScreenPresenter {
	SplashScreenView splashScreenView;
	SplashScreenProvider splashScreenProvider;


	public SplashScreenPresenterImpl(SplashScreenView splashScreenView ,
									 SplashScreenProvider splashScreenProvider){
		this.splashScreenProvider=splashScreenProvider;
		this.splashScreenView =splashScreenView;

	}
	@Override
	public void sendFcm(String fcm) {
		splashScreenProvider.sendFcm(fcm, new SplashScreenCallback() {
			@Override
			public void onSuccess(SplashScreenData splashScreenData) {
			if (splashScreenData.isSuccess()){
				try {
					splashScreenView.onVersionRecived(splashScreenData);

				}catch (PackageManager .NameNotFoundException e){
					e.printStackTrace();
				}
			}

			}

			@Override
			public void onFailed() {
				splashScreenView.onFailed();
			}
		});

	}
}
