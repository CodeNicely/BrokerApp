package com.example.ujjwal.broker.Deals.Model.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ujjwal on 20/12/16.
 */
public class ProductListData {
	private boolean success;
	private String message;

	private List<ProductListDetails> product_list =new ArrayList<>();

	public ProductListData(boolean success, String message, List<ProductListDetails> product_list) {
		this.success = success;
		this.message = message;
		this.product_list = product_list;
	}

	public boolean isSuccess(){
		return success;
	}
	public String getMessage(){
		return message;
	}
	public List<ProductListDetails> getProductDetails(){
		return product_list;
	}

}
