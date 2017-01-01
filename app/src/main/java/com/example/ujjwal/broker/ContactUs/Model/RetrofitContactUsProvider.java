package com.example.ujjwal.broker.ContactUs.Model;

import com.example.ujjwal.broker.ContactUs.Api.ContactUsApi;
import com.example.ujjwal.broker.ContactUs.ContactUsCallback;
import com.example.ujjwal.broker.ContactUs.Model.Data.ContactUsData;
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
 * Created by ujjwal on 29/12/16.
 */
public class RetrofitContactUsProvider implements ContactUsProvider {
	ContactUsApi contactUsApi;
	Call<ContactUsData> contactUsDataCall;

	public RetrofitContactUsProvider() {

		HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		OkHttpClient client=new OkHttpClient.Builder().addInterceptor(interceptor).build();

		Retrofit retrofit= new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client)
								   .addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
		contactUsApi=retrofit.create(ContactUsApi.class);
	}


	@Override
	public void requestContactUs(String accessToken, final ContactUsCallback contactUsCallback) {
			contactUsDataCall=contactUsApi.requestContactUs(accessToken);
			contactUsDataCall.enqueue(new Callback<ContactUsData>() {
				@Override
				public void onResponse(Call<ContactUsData> call, Response<ContactUsData> response) {
					contactUsCallback.onSuccess(response.body());
				}

				@Override
				public void onFailure(Call<ContactUsData> call, Throwable t) {
					contactUsCallback.onFailure();
					t.printStackTrace();

				}
			});
	}
}
