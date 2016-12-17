package com.example.ujjwal.broker.Buy.Model;

import android.util.Log;

import com.example.ujjwal.broker.Buy.Api.RequestBuy;
import com.example.ujjwal.broker.Buy.BuyCallback;
import com.example.ujjwal.broker.Buy.Model.Data.BuyResponse;
import com.example.ujjwal.broker.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ujjwal on 14/12/16.
 */
public class RetrofitBuyHelper implements BuyHelperInterface {
		private static String TAG ="RetrofitBuyHelper";


	@Override
	public void buyData(String access_token, boolean type, String product, String sub_product, String rate, String quantity, final BuyCallback buyCallback) {
		HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

		Retrofit retrofit= new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client)
								   .addConverterFactory(GsonConverterFactory.create()).build();
		RequestBuy requestBuy =retrofit.create(RequestBuy.class);
		Call<BuyResponse> call =requestBuy.getJSON(access_token,type,product,sub_product,rate,quantity);
		call.enqueue(new Callback<BuyResponse>() {
			@Override
			public void onResponse(Call<BuyResponse> call, Response<BuyResponse> response) {
				Log.i(TAG,"Got Response "+response.body().getMessage().toString());
				buyCallback.onBuySuccess(response.body());
			}

			@Override
			public void onFailure(Call<BuyResponse> call, Throwable t) {
				buyCallback.onBuyFailure(t.getMessage());
			}
		});
	}
}
