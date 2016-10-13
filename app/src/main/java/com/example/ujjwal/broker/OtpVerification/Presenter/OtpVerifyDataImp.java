package com.example.ujjwal.broker.OtpVerification.Presenter;


import com.example.ujjwal.broker.OtpVerification.Data.OtpResponse;
import com.example.ujjwal.broker.OtpVerification.Model.OtpVerifyHelperInterface;
import com.example.ujjwal.broker.OtpVerification.OtpVerificationCallback;
import com.example.ujjwal.broker.OtpVerification.View.OtpActivityInterface;

/**
 * Created by ujjwal on 13/10/16.
 */
public class OtpVerifyDataImp  implements OtpVerifyData {

	private OtpActivityInterface otpActivityInterface;
	private OtpVerifyHelperInterface otpVerifyHelperInterface;


	public OtpVerifyDataImp(OtpActivityInterface otpActivityInterface, OtpVerifyHelperInterface otpVerifyHelperInterface) {
		this.otpActivityInterface = otpActivityInterface;
		this.otpVerifyHelperInterface = otpVerifyHelperInterface;
	}

	@Override
	public void getOtpData(String otp_number, String mobile_no) {
		otpActivityInterface.showProgressbar(true);
		otpVerifyHelperInterface.getOtpResponse(otp_number, mobile_no, new OtpVerificationCallback() {


			@Override
			public void onOtpVerified(OtpResponse otpResponse) {
				if(otpResponse.isSuccess()){
					otpActivityInterface.otpStatus(true);
					otpActivityInterface.showProgressbar(false);

				}else {
					otpActivityInterface.showError("Error Try Again");
				otpActivityInterface.showProgressbar(true);
				}



			}

			@Override
			public void onFailure(String error) {
			otpActivityInterface.showError(error);
				otpActivityInterface.showProgressbar(true);
				otpActivityInterface.otpStatus(false);
			}
		});

	}
}
