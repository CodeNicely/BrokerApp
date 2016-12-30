package com.example.ujjwal.broker.SellBuy.Model.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ujjwal on 29/12/16.
 */
public class SellBuyData {
	private boolean success;
	private String message;
	private ArrayList<SellBuyCategoryDetails> category_list;
	private ArrayList<String> unit_list;

	public List<String> getUnit_list() {
		return unit_list;
	}

	public SellBuyData(boolean success, String message, ArrayList<SellBuyCategoryDetails> category_list, ArrayList<String> unit_list) {
		this.success = success;
		this.message = message;
		this.category_list = category_list;
		this.unit_list = unit_list;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public ArrayList<SellBuyCategoryDetails> getCategory_list() {
		return category_list;
	}
}
