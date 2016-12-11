package com.example.ujjwal.broker.SplashScreen.Model;

import com.example.ujjwal.broker.SplashScreen.Api.SplashScreenApi;
import com.example.ujjwal.broker.SplashScreen.Model.Data.SplashScreenData;
import com.example.ujjwal.broker.SplashScreen.SplashScreenCallback;
import com.example.ujjwal.broker.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ujjwal on 11/12/16.
 */
public class ReterofitSplashScreenProvider  implements  SplashScreenProvider{

	SplashScreenApi splashScreenApi;

	public  ReterofitSplashScreenProvider(){
		HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		OkHttpClient client= new OkHttpClient.Builder().addInterceptor(interceptor).build();

		Retrofit retrofit =new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client)
									.addConverterFactory(GsonConverterFactory.create())
									.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
									.build();

		splashScreenApi = retrofit.create(SplashScreenApi.class);


	}


	@Override
	public void sendFcm(String fcm, final SplashScreenCallback splashScreenCallback) {


		Call<SplashScreenData> splashScreenDataCall = splashScreenApi.sendFcm(fcm);

		splashScreenDataCall.enqueue(new Callback<SplashScreenData>() {

			@Override
			public void onResponse(Call<SplashScreenData> call, Response<SplashScreenData> response) {
				splashScreenCallback.onSuccess(response.body());
			}

			@Override
			public void onFailure(Call<SplashScreenData> call, Throwable t) {
				splashScreenCallback.onFailed();
			}
		});


	}
}
