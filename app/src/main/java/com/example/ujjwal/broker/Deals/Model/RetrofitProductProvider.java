package com.example.ujjwal.broker.Deals.Model;

import com.example.ujjwal.broker.Deals.Api.ProductRequestApi;
import com.example.ujjwal.broker.Deals.Model.Data.ProductListData;
import com.example.ujjwal.broker.Deals.ProductCallback;
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
 * Created by ujjwal on 29/12/16.
 */
public class RetrofitProductProvider implements ProductListDetailsProvider {

	ProductRequestApi productRequestApi;

	public RetrofitProductProvider() {

		HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		OkHttpClient client = new OkHttpClient.Builder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).addInterceptor(interceptor).build();

		Retrofit retrofit = new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client)
									.addConverterFactory(GsonConverterFactory.create())
									.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
									.build();
		productRequestApi = retrofit.create(ProductRequestApi.class);

	}

	@Override
	public void requestProductList(String access_token, int category_id, final ProductCallback productCallback) {
		Call<ProductListData> call = productRequestApi.getProductData(access_token, category_id);
		call.enqueue(new Callback<ProductListData>() {

			@Override
			public void onResponse(Call<ProductListData> call, Response<ProductListData> response) {
				productCallback.onSuccess(response.body());
			}

			@Override
			public void onFailure(Call<ProductListData> call, Throwable t) {
				productCallback.onFailure();
				t.printStackTrace();
			}
		});

	}
}