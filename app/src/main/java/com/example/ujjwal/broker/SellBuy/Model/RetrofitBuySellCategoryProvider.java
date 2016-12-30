package com.example.ujjwal.broker.SellBuy.Model;

import com.example.ujjwal.broker.Deals.Model.Data.CategoryData;
import com.example.ujjwal.broker.SellBuy.Api.SellBuyCategoryRequestApi;
import com.example.ujjwal.broker.SellBuy.BuySellCategoryCallback;
import com.example.ujjwal.broker.SellBuy.Model.Data.SellBuyData;
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
public class RetrofitBuySellCategoryProvider implements BuySellCategoryProvider {

	private SellBuyCategoryRequestApi categoryRequestApi;

	public RetrofitBuySellCategoryProvider() {

		HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		OkHttpClient client = new OkHttpClient.Builder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).addInterceptor(interceptor).build();

		Retrofit retrofit = new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client)
									.addConverterFactory(GsonConverterFactory.create())
									.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
									.build();

		categoryRequestApi = retrofit.create(SellBuyCategoryRequestApi.class);
	}

	@Override
	public void requestCategoryList(String access_token, final BuySellCategoryCallback buySellCategoryCallback) {
		Call<SellBuyData> call = categoryRequestApi.getCategoryData(access_token);
		call.enqueue(new Callback<SellBuyData>() {

			@Override
			public void onResponse(Call<SellBuyData> call, Response<SellBuyData> response) {
				buySellCategoryCallback.onSuccess(response.body());
			}

			@Override
			public void onFailure(Call<SellBuyData> call, Throwable t) {
				t.printStackTrace();
				buySellCategoryCallback.onFailure();
			}
		});

	}
}