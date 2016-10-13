package com.example.ujjwal.broker.OtpVerification;

import com.example.ujjwal.broker.OtpVerification.Data.OtpResponse;

/**
 * Created by ujjwal on 13/10/16.
 */
public interface OtpVerificationCallback {

	void onOtpVerified(OtpResponse otpResponse);
	void onFailure(String error);
}
