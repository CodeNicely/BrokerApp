package com.example.ujjwal.broker.Deals.Model.Data;



/**
 * Created by ujjwal on 19/12/16.
 */
public class CategoryDetails {
private int id;
	private String name;
	private String description;

	public CategoryDetails(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getDescription(){
		return description;
	}


}
