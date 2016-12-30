package com.example.ujjwal.broker.Deals.Model.Data;

/**
 * Created by ujjwal on 20/12/16.
 */
public class ProductListDetails {
	private String name;
	private int id;
	private String image;
	private int price;
	private String description;
	private String unit;

	public ProductListDetails(String name, int id, String image, int price, String description, String unit) {
		this.name = name;
		this.id = id;
		this.image = image;
		this.price = price;
		this.description = description;
		this.unit = unit;
	}

	public String getName(){
		return name;
	}
	public String getImage(){
		return image;
	}
	public int getId(){
		return id;
	}
	public int getPrice(){
		return price;
	}

	public String getDescription() {
		return description;
	}

	public String getUnit() {
		return unit;
	}
}
