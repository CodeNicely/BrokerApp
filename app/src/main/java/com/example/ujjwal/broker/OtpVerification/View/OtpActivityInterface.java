package com.example.ujjwal.broker.OtpVerification.View;

/**
 * Created by ujjwal on 13/10/16.
 */
public interface OtpActivityInterface {

	void showProgressbar(boolean show);
	void showError(String error);
	void otpStatus(boolean status);

}
