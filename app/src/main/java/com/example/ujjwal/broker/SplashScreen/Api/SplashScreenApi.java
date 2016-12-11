package com.example.ujjwal.broker.SplashScreen.Api;

import com.example.ujjwal.broker.SplashScreen.Model.Data.SplashScreenData;
import com.example.ujjwal.broker.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ujjwal on 11/12/16.
 */
public interface SplashScreenApi {

	@GET(Urls.SUB_URL_SPLASH_SCREEN)
	Call<SplashScreenData> sendFcm(@Query("fcm") String fcm);
}
