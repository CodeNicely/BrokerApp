package com.example.ujjwal.broker.Deals.Model.Data;

/**
 * Created by ujjwal on 21/12/16.
 */
public class SellBuyResponse {
	boolean success;
	String message;

	public SellBuyResponse(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}
}
