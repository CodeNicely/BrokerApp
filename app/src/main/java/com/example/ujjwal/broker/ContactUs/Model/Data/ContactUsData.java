package com.example.ujjwal.broker.ContactUs.Model.Data;

import android.widget.TextView;

/**
 * Created by ujjwal on 29/12/16.
 */
public class ContactUsData {
	private boolean success;
	private String message;

	private String name1,name2,name3;
	private String number1,number2,number3;
	private String address;
	private String image;
	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public ContactUsData(boolean success, String message, String name1, String name2, String name3, String number1, String number2, String number3, String address, String image) {
		this.success = success;
		this.message = message;
		this.name1 = name1;
		this.name2 = name2;
		this.name3 = name3;
		this.number1 = number1;
		this.number2 = number2;
		this.number3 = number3;
		this.address = address;
		this.image = image;
	}

	public String getName1() {
		return name1;
	}

	public String getName2() {
		return name2;
	}

	public String getNumber1() {
		return number1;
	}

	public String getNumber2() {
		return number2;
	}

	public String getNumber3() {
		return number3;
	}

	public String getName3() {
		return name3;
	}

	public String getAddress() {
		return address;
	}

	public String getImage() {
		return image;
	}
}
