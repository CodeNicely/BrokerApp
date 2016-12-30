package com.example.ujjwal.broker.SellBuy.Model.Data;

/**
 * Created by ujjwal on 29/12/16.
 */
public class SellBuyCategoryDetails {
	private int id;
	private String name;
	private String description;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public SellBuyCategoryDetails(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

}
