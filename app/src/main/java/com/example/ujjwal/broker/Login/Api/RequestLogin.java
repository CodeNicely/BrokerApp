package com.example.ujjwal.broker.Login.Api;

import com.example.ujjwal.broker.Login.Data.LoginDataResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ujjwal on 13/10/16.
 */

public interface RequestLogin {
	@FormUrlEncoded
	@POST("Urls.SUB_URL_LOGIN")
	Call<LoginDataResponse> getJSON(@Field("mobile") String mobile,@Field("firm")String firm ,@Field("name") String name,
	@Field("city")String city,@Field("category")String category);

}
