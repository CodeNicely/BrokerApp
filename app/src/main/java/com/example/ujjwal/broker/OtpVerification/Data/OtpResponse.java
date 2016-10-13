package com.example.ujjwal.broker.OtpVerification.Data;

/**
 * Created by ujjwal on 13/10/16.
 */
public class OtpResponse {
	private String message,message_debug,access_token;
	private boolean success;

	public OtpResponse(String message, String message_debug, String access_token, boolean success) {
		this.message = message;
		this.message_debug = message_debug;
		this.access_token = access_token;
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public String getMessage_debug() {
		return message_debug;
	}

	public String getAccess_token() {
		return access_token;
	}

}
