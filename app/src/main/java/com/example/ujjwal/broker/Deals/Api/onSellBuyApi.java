package com.example.ujjwal.broker.Deals.Api;


import com.example.ujjwal.broker.Deals.Model.Data.SellBuyResponse;
import com.example.ujjwal.broker.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ujjwal on 21/12/16.
 */
public interface onSellBuyApi {

	@GET(Urls.SUB_URL_BUY_SELL)
	Call<SellBuyResponse> getSellBuyDetails(@Query("access_token")String access_token, @Query("type")boolean
	type, @Query("product_id")String product_id);

}
