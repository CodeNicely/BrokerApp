package com.example.ujjwal.broker.Deals.Model.Data;

/**
 * Created by ujjwal on 20/12/16.
 */
public class ProductListDetails {
	private String name;
	private int product_id;
	private String image;
	private int rate;
	private String description;
	private String unit;

	public ProductListDetails(String name, int product_id, String image, int rate, String description, String unit) {
		this.name = name;
		this.product_id = product_id;
		this.image = image;
		this.rate = rate;
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
		return product_id;
	}
	public int getRate(){
		return rate;
	}

	public String getDescription() {
		return description;
	}

	public String getUnit() {
		return unit;
	}
}
