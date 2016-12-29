package com.example.ujjwal.broker.SellBuy.Model.Data;

/**
 * Created by ujjwal on 29/12/16.
 */
public class BuySellResponse {
private boolean success;
	private String message;

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public BuySellResponse(boolean success, String message) {

		this.success = success;
		this.message = message;
	}
}
