package com.example.ujjwal.broker.OtpVerification.Model;

import com.example.ujjwal.broker.OtpVerification.OtpVerificationCallback;

/**
 * Created by ujjwal on 13/10/16.
 */
public interface OtpVerifyHelperInterface {


	void getOtpResponse(String otp_number, String mobile_no, OtpVerificationCallback otpVerificationCallback);
}
