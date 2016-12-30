package com.example.ujjwal.broker.SellBuy.Model;

import com.example.ujjwal.broker.Deals.Model.Data.SellBuyResponse;
import com.example.ujjwal.broker.SellBuy.Api.SellBuyApi;
import com.example.ujjwal.broker.SellBuy.BuySellCallback;
import com.example.ujjwal.broker.SellBuy.Model.Data.BuySellResponse;
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
public class RetrofitBuySellHelper implements BuySellHelper {

	private SellBuyApi sellBuyApi;

	public RetrofitBuySellHelper() {
		HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		OkHttpClient client = new OkHttpClient.Builder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).addInterceptor(interceptor).build();

		Retrofit retrofit=new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client)
								  .addConverterFactory(GsonConverterFactory.create())
								  .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
								  .build();



		sellBuyApi =retrofit.create(SellBuyApi.class);
	}

	@Override
	public void getBuySellData(String accessToken, int product_id, String product_name, String product_description, String price, String unit, final BuySellCallback buySellCallback) {
		Call<BuySellResponse> call=sellBuyApi.getSellBuyDetails(accessToken,product_id,product_name,product_description
				,price,unit);
		call.enqueue(new Callback<BuySellResponse>() {
			@Override
			public void onResponse(Call<BuySellResponse> call, Response<BuySellResponse> response) {
				buySellCallback.onSuccess(response.body());
			}

			@Override
			public void onFailure(Call<BuySellResponse> call, Throwable t) {
			t.printStackTrace();
				buySellCallback.onFailure();
			}
		});

	}
}
