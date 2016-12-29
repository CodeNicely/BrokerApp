package com.example.ujjwal.broker.SellBuy.Model.Data;

/**
 * Created by ujjwal on 29/12/16.
 */
public class SellBuyProductDetails {
	private int product_id;
	private String product_name;
	private String product_description;

	public int getProduct_id() {
		return product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public String getProduct_description() {
		return product_description;
	}

	public SellBuyProductDetails(int product_id, String product_name, String product_description) {

		this.product_id = product_id;
		this.product_name = product_name;
		this.product_description = product_description;
	}
}
