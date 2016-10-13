package com.example.ujjwal.broker.OtpVerification.Api;

import com.example.ujjwal.broker.OtpVerification.Data.OtpResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ujjwal on 14/10/16.
 */
public interface RequestOtpVerify {
	@FormUrlEncoded
	@POST("/Grocery/otp.json")
	Call<OtpResponse> getJson(@Field("otp")String otp, @Field("mobile")String mobile);

}
