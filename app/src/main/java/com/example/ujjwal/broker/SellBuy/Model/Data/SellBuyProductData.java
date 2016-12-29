package com.example.ujjwal.broker.SellBuy.Model.Data;

import java.util.List;

/**
 * Created by ujjwal on 29/12/16.
 */
public class SellBuyProductData {
	private boolean success;
	private String message;
	private List<SellBuyProductDetails> sellBuyProductDetailsList;

	public SellBuyProductData(boolean success, String message, List<SellBuyProductDetails> sellBuyProductDetailsList) {
		this.success = success;
		this.message = message;
		this.sellBuyProductDetailsList = sellBuyProductDetailsList;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public List<SellBuyProductDetails> getSellBuyProductDetailsList() {
		return sellBuyProductDetailsList;
	}
}
