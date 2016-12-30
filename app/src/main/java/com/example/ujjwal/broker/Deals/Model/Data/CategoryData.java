package com.example.ujjwal.broker.Deals.Model.Data;

import java.util.List;

/**
 * Created by ujjwal on 19/12/16.
 */
public class CategoryData {
	private String message;
	private boolean success;

	private List<CategoryDetails> category_list;

	public CategoryData(String message, boolean success, List<CategoryDetails> category_list) {
		this.message = message;
		this.success = success;
		this.category_list = category_list;
	}

	public String getMessage(){
		return message;
	}
	public boolean isSuccess(){
		return success;
	}
	public List<CategoryDetails> getCategoryList(){
		return category_list;
	}
}
