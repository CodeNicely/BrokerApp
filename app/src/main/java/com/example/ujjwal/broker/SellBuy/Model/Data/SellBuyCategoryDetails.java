package com.example.ujjwal.broker.SellBuy.Model.Data;

/**
 * Created by ujjwal on 29/12/16.
 */
public class SellBuyCategoryDetails {
	private int category_id;
	private String category_name;
	private String category_description;

	public int getCategory_id() {
		return category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public String getCategory_description() {
		return category_description;
	}

	public SellBuyCategoryDetails(int category_id, String category_name, String category_description) {

		this.category_id = category_id;
		this.category_name = category_name;
		this.category_description = category_description;
	}
}
