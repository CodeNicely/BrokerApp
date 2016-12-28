package com.example.ujjwal.broker.ContactUs;

import com.example.ujjwal.broker.ContactUs.Model.Data.ContactUsData;

/**
 * Created by ujjwal on 29/12/16.
 */
public interface ContactUsCallback {
	void onSuccess(ContactUsData contactUsData);
	void onFailure();
}
