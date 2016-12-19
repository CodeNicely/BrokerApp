package com.example.ujjwal.broker.OtpVerification.Presenter;


import android.text.TextWatcher;

import com.example.ujjwal.broker.OtpVerification.Data.OtpResponse;
import com.example.ujjwal.broker.OtpVerification.Model.OtpVerifyHelperInterface;
import com.example.ujjwal.broker.OtpVerification.Model.RetrofitOtpVerifyHelper;
import com.example.ujjwal.broker.OtpVerification.OtpVerificationCallback;
import com.example.ujjwal.broker.OtpVerification.View.OtpActivity;
import com.example.ujjwal.broker.OtpVerification.View.OtpActivityInterface;

/**
 * Created by ujjwal on 13/10/16.
 */
public class OtpVerifyPresenterImp  implements OtpVerifyPresenter {

	private OtpActivityInterface otpActivityInterface;
	private OtpVerifyHelperInterface otpVerifyHelperInterface;


	public OtpVerifyPresenterImp(OtpActivity otpActivity, RetrofitOtpVerifyHelper retrofitOtpVerifyHelper) {
		this.otpActivityInterface = otpActivity;
		this.otpVerifyHelperInterface = retrofitOtpVerifyHelper;
	}



	@Override
	public void getOtpData(String otp_number, String mobile_no) {
		otpActivityInterface.showProgressbar(false);
		otpVerifyHelperInterface.getOtpResponse(otp_number, mobile_no, new OtpVerificationCallback() {


			@Override
			public void onOtpVerified(OtpResponse otpResponse) {
				if(otpResponse.isSuccess()){
					otpActivityInterface.showProgressbar(false);
					otpActivityInterface.otpStatus(otpResponse);
					otpResponse.getAccess_token();

				}else {
					otpActivityInterface.showError(otpResponse.getMessage());
					otpActivityInterface.otpStatus(otpResponse);
				}
			}

			@Override
			public void onFailure(String error) {
				otpActivityInterface.showProgressbar(true);
				otpActivityInterface.showError(error);

			}
		});

	}
}
