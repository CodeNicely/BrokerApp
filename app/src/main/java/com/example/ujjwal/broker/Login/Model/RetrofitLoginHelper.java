package com.example.ujjwal.broker.Login.Model;

import android.util.Log;

import com.example.ujjwal.broker.Login.Api.RequestLogin;
import com.example.ujjwal.broker.Login.Data.LoginDataResponse;
import com.example.ujjwal.broker.Login.LoginCallback;
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
 * Created by ujjwal on 13/10/16.
 */
public class RetrofitLoginHelper implements LoginBaseClassHelper {

	private static String TAG ="RetrofitLoginHelper";
	RequestLogin requestLogin;


	@Override
	public void loginData(String mobile, String firm, String name, String city,
						  String category, final LoginCallback loginCallback) {
		HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

		Retrofit retrofit= new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client)
								   .addConverterFactory(GsonConverterFactory.create()).build();
		requestLogin = retrofit.create(RequestLogin.class);


		Call<LoginDataResponse> call= requestLogin.getJSON(mobile,firm,name,city,category);
		call.enqueue(new Callback<LoginDataResponse>() {
			@Override
			public void onResponse(Call<LoginDataResponse> call, Response<LoginDataResponse> response) {
				Log.i(TAG,"Got Response "+response.body().getMessage().toString());

					loginCallback.onLoginSuccess(response.body());

			}
				@Override
			public void onFailure(Call<LoginDataResponse> call, Throwable t) {
					t.printStackTrace();
				loginCallback.onLoginFailure(t.getMessage());
			}
		});
	}
}