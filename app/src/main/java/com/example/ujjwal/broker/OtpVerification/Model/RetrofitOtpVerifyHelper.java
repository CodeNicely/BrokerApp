package com.example.ujjwal.broker.OtpVerification.Model;

import android.util.Log;

import com.example.ujjwal.broker.OtpVerification.Api.RequestOtpVerify;
import com.example.ujjwal.broker.OtpVerification.Data.OtpResponse;
import com.example.ujjwal.broker.OtpVerification.OtpVerificationCallback;
import com.example.ujjwal.broker.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ujjwal on 13/10/16.
 */
public class RetrofitOtpVerifyHelper implements OtpVerifyHelperInterface{

	private static String TAG ="RetrofitOtpVerifyHelper";



	@Override
	public void getOtpResponse(String otp_number, String mobile_no, final OtpVerificationCallback otpVerificationCallback) {
		HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

		Retrofit retrofit = new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client).
																								addConverterFactory(GsonConverterFactory.create()).build();
		final RequestOtpVerify requestOtpVerify = retrofit.create(RequestOtpVerify.class);




		Call<OtpResponse> call=requestOtpVerify.getJson(otp_number,mobile_no);
		call.enqueue(new Callback<OtpResponse>() {
			@Override
			public void onResponse(Call<OtpResponse> call, Response<OtpResponse> response) {
				Log.i(TAG,"Got Response"+response.body().getMessage());

				otpVerificationCallback.onOtpVerified(response.body());
			}

			@Override
			public void onFailure(Call<OtpResponse> call, Throwable t) {
					t.printStackTrace();
					otpVerificationCallback.onFailure(t.getMessage());
			}
		});
	}
}
