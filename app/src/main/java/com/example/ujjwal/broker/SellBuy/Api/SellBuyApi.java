package com.example.ujjwal.broker.SellBuy.Api;


import com.example.ujjwal.broker.SellBuy.Model.Data.BuySellResponse;
import com.example.ujjwal.broker.helper.Urls;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ujjwal on 30/12/16.
 */
public interface SellBuyApi {

	@FormUrlEncoded
	@POST(Urls.SUB_URL_BUY_SELL)
	Call<BuySellResponse> getSellBuyDetails(@Field("access_token") String access_token
				, @Field("category_id") int id, @Field("product_name") String name, @Field("product_description") String description
			, @Field("product_price") String price, @Field("product_unit")	String unit	);
}
