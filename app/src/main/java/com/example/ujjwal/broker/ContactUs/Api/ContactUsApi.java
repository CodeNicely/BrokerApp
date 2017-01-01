package com.example.ujjwal.broker.ContactUs.Api;

import com.example.ujjwal.broker.ContactUs.Model.Data.ContactUsData;
import com.example.ujjwal.broker.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ujjwal on 29/12/16.
 */
public interface ContactUsApi {

	@GET(Urls.SUB_URL_CONTACT_US)
	Call<ContactUsData> requestContactUs(@Query("access_token")String accessToken);

}
