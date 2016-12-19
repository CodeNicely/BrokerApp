package com.example.ujjwal.broker.Deals.Model;

import android.util.Log;

import com.example.ujjwal.broker.Deals.Api.CategoryRequestApi;
import com.example.ujjwal.broker.Deals.CategoryCallback;
import com.example.ujjwal.broker.Deals.Model.Data.CategoryData;
import com.example.ujjwal.broker.helper.Urls;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ujjwal on 19/12/16.
 */
public class RetrofitCategoryProvider implements CategoryProvider {

	CategoryRequestApi categoryRequestApi;


	@Override
	public void requestCategoryDetails(String access_token, final CategoryCallback categoryCallback) {

		HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		OkHttpClient client = new OkHttpClient.Builder().connectTimeout(2,TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).addInterceptor(interceptor).build();

		Retrofit retrofit=new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client)
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.build();

		categoryRequestApi=retrofit.create(CategoryRequestApi.class);

		Call<CategoryData> call =categoryRequestApi.getCategoryData(access_token);
		call.enqueue(new Callback<CategoryData>() {
			@Override
			public void onResponse(Call<CategoryData> call, Response<CategoryData> response) {
				Log.i("Retrofit Category","Response Recieved:"+response.body());
					categoryCallback.onSuccess(response.body());

			}

			@Override
			public void onFailure(Call<CategoryData> call, Throwable t) {
				categoryCallback.onFailure();
				t.printStackTrace();
			}
		});



	}


}
