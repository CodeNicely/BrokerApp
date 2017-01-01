package com.example.ujjwal.broker.ContactUs.View;

import com.example.ujjwal.broker.ContactUs.Model.Data.ContactUsData;

/**
 * Created by ujjwal on 29/12/16.
 */
public interface ContactUsView {
	void showProgressBar(boolean show);
	void showMessage(String message);
	void setContactUsData(ContactUsData contactUsData);
	void setMockData();
}
