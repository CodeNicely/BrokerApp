package com.example.ujjwal.broker.ContactUs.Presenter;

import com.example.ujjwal.broker.ContactUs.ContactUsCallback;
import com.example.ujjwal.broker.ContactUs.Model.ContactUsProvider;
import com.example.ujjwal.broker.ContactUs.Model.Data.ContactUsData;
import com.example.ujjwal.broker.ContactUs.View.ContactUsView;

/**
 * Created by ujjwal on 29/12/16.
 */
public class ContactUsPresenterImpl implements ContactUsPresenter {
	ContactUsView contactUsView;
	ContactUsProvider contactUsProvider;

	public ContactUsPresenterImpl(ContactUsView contactUsView, ContactUsProvider contactUsProvider) {
		this.contactUsView = contactUsView;
		this.contactUsProvider = contactUsProvider;
	}

	@Override
	public void requestContactUs() {
		contactUsView.showProgressBar(true);
		contactUsProvider.requestContactUs(new ContactUsCallback() {
			@Override
			public void onSuccess(ContactUsData contactUsData) {
				contactUsView.showProgressBar(false);
				if (contactUsData.isSuccess()){
					contactUsView.setContactUsData(contactUsData);
				}else {
					contactUsView.showMessage(contactUsData.getMessage());
				}
			}

			@Override
			public void onFailure() {
				contactUsView.showProgressBar(false);
				contactUsView.showMessage("Something went wrong");
			}
		});


	}
}
