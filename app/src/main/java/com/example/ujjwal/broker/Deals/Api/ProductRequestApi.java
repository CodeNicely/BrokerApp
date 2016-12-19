package com.example.ujjwal.broker.Deals.Api;

import com.example.ujjwal.broker.Deals.Model.Data.ProductListData;
import com.example.ujjwal.broker.helper.Urls;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ujjwal on 20/12/16.
 */
public interface ProductRequestApi {
	@GET(Urls.SUB_URL_PRODUCT)
	Call<ProductListData> getProductData(@Query("access_token")String access_token,
										 @Query("category_id")int category_id);
}
