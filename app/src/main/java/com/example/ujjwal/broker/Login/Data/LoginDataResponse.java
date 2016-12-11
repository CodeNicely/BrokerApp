package com.example.ujjwal.broker.Login.Data;

/**
 * Created by ujjwal on 13/10/16.
 */
public class LoginDataResponse   {
	private boolean success;
	private String message;
	/*private String message_display;
*/
	public LoginDataResponse(boolean success, String message, String message_display)
	{
		this.message=message;
	/*	this.message_display=message_display;
	*/	this.success=success;
	}
	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	/*public String getMessage_display() {
		return message_display;
	}
*/
}
