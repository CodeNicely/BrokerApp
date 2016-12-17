package com.example.ujjwal.broker.Buy.Api;

import com.example.ujjwal.broker.Buy.Model.Data.BuyResponse;
import com.example.ujjwal.broker.helper.Urls;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ujjwal on 14/12/16.
 */
public interface RequestBuy {
	@FormUrlEncoded
	@POST(Urls.SUB_URL_BUY_SELL)
	Call<BuyResponse> getJSON(@Query("access_token") String access_token, @Field("type")boolean type
	     , @Field("product")String product, @Field("sub_product")String sub_product
	, @Field("rate")String rate , @Field("quantity")String quantity);

}
