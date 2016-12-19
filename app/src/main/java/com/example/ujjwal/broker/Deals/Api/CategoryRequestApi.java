package com.example.ujjwal.broker.Deals.Api;

import com.example.ujjwal.broker.Deals.Model.Data.CategoryData;
import com.example.ujjwal.broker.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ujjwal on 19/12/16.
 */
public interface CategoryRequestApi {
	@GET(Urls.SUB_URL_CATEGORY)
	Call<CategoryData> getCategoryData(@Query("access_token")String access_token);

}
