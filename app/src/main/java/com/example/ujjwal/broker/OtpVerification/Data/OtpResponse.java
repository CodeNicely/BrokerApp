package com.example.ujjwal.broker.OtpVerification.Data;

/**
 * Created by ujjwal on 13/10/16.
 */
public class OtpResponse {
	private String message,access_token;
	private boolean success;

	public OtpResponse(String message,String access_token, boolean success) {
		this.message = message;
		this.access_token = access_token;
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}


	public String getAccess_token() {
		return access_token;
	}

}
