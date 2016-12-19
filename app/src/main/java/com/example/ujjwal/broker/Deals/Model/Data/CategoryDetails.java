package com.example.ujjwal.broker.Deals.Model.Data;



/**
 * Created by ujjwal on 19/12/16.
 */
public class CategoryDetails {
private int category_id;
	private String name;
	private String description;

	public CategoryDetails(int category_id,String name,String description){
		this.description=description;
		this.name=name;
		this.category_id=category_id;
	}

	public int getId(){
		return category_id;
	}
	public String getName(){
		return name;
	}
	public String getDescription(){
		return description;
	}


}
