package com.example.ujjwal.broker.Sell.Api;

import com.example.ujjwal.broker.Sell.Model.Data.SellResponse;
import com.example.ujjwal.broker.Sell.SellCallback;
import com.example.ujjwal.broker.helper.Urls;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ujjwal on 15/12/16.
 */
public interface RequestSell {
	@FormUrlEncoded
	@POST(Urls.SUB_URL_BUY_SELL)
	Call<SellResponse> getJson(@Query("access_token") String access_token, @Field("type")boolean type ,
	 	@Field("product")String product,@Field("sub_product")String sub_product,
		@Field("rate")String rate,@Field("quantity")String quantity);
}
