package com.example.ujjwal.broker.OtpVerification.View;

import com.example.ujjwal.broker.OtpVerification.Data.OtpResponse;

/**
 * Created by ujjwal on 13/10/16.
 */
public interface OtpActivityInterface {

	void showProgressbar(boolean show);
	void showError(String error);
	void otpStatus(OtpResponse status);

}
