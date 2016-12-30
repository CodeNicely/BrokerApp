package com.example.ujjwal.broker.SellBuy.Api;

import com.example.ujjwal.broker.SellBuy.Model.Data.SellBuyData;
import com.example.ujjwal.broker.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ujjwal on 30/12/16.
 */
public interface SellBuyCategoryRequestApi {

@GET(Urls.SUB_URL_BUY_SELL_CATEGORY)
	Call<SellBuyData> getCategoryData(@Query("access_token")String access_token);
}
