package com.example.ujjwal.broker.Deals.Model.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ujjwal on 20/12/16.
 */
public class ProductListData {
	private boolean success;
	private String message;

	private List<ProductListDetails> productListDetails=new ArrayList<>();

	public ProductListData(boolean success, String message, List<ProductListDetails> productListDetails) {
		this.success = success;
		this.message = message;
		this.productListDetails = productListDetails;
	}

	public boolean isSuccess(){
		return success;
	}
	public String getMessage(){
		return message;
	}
	public List<ProductListDetails> getProductDetails(){
		return productListDetails;
	}

}
