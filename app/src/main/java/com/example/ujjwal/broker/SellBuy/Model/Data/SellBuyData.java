package com.example.ujjwal.broker.SellBuy.Model.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ujjwal on 29/12/16.
 */
public class SellBuyData {
	private boolean success;
	private String message;
	private List<SellBuyCategoryDetails> categoryDetailsList;

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public List<SellBuyCategoryDetails> getCategoryDetailsList() {
		return categoryDetailsList;
	}

	public SellBuyData(boolean success, String message, List<SellBuyCategoryDetails> categoryDetailsList) {
		this.success = success;
		this.message = message;
		this.categoryDetailsList = categoryDetailsList;
	}
}
