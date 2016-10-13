package com.example.ujjwal.broker.Login.Model;

import com.example.ujjwal.broker.Login.Api.RequestLogin;
import com.example.ujjwal.broker.Login.Data.LoginDataResponse;
import com.example.ujjwal.broker.Login.LoginCallback;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ujjwal on 13/10/16.
 */
public class RetrofitLoginHelper implements LoginBaseClassHelper {


	@Override
	public void loginData(String mobile, String firm, String name, final LoginCallback loginCallback) {

		/*HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
*/
		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.111:8000/").addConverterFactory(GsonConverterFactory.create()).build();
		RequestLogin requestLogin = retrofit.create(RequestLogin.class);
		Call<LoginDataResponse> call = requestLogin.getJSON(mobile, firm, name);
		call.enqueue(new Callback<LoginDataResponse>() {

			@Override
			public void onResponse(Call<LoginDataResponse> call, Response<LoginDataResponse> response) {
				if(response.body().isSuccess())
				{
					loginCallback.onLoginSuccess(response.body());
				}
				else
				{
					loginCallback.onLoginFailure("error try again");
				}

			}

			@Override
			public void onFailure(Call<LoginDataResponse> call, Throwable t) {
				t.printStackTrace();
			}
		});
	}
}