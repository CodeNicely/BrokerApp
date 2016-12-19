package com.example.ujjwal.broker.Deals.Model.Data;

import java.util.List;

/**
 * Created by ujjwal on 19/12/16.
 */
public class CategoryData {
	private String message;
	private boolean success;

	private List<CategoryDetails> categoryList;

	public CategoryData(boolean success,String message,List<CategoryDetails> categoryList){
		this.message=message;
		this.success=success;
		this.categoryList=categoryList;
	}

	public String getMessage(){
		return message;
	}
	public boolean isSuccess(){
		return success;
	}
	public List<CategoryDetails> getCategoryList(){
		return categoryList;
	}
}
