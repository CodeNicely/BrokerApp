package com.example.ujjwal.broker.Login.Data;

/**
 * Created by ujjwal on 13/10/16.
 */
public class LoginDataResponse   {
	private boolean success;
	private String message;
	public LoginDataResponse(boolean success, String message)
	{
		this.message=message;
		this.success=success;
	}
	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

}
