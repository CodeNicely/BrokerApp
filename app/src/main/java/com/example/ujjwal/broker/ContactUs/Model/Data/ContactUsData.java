package com.example.ujjwal.broker.ContactUs.Model.Data;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.widget.TextView;

/**
 * Created by ujjwal on 29/12/16.
 */
public class ContactUsData {
	private boolean success;
	private String message;
	private String firm_name;
	private String mobile1,mobile2,mobile3,landline1,landline2;
	private String address;

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public ContactUsData(boolean success, String message, String firm_name, String mobile1, String mobile2, String mobile3, String landline1, String landline2, String address) {
		this.success = success;
		this.message = message;
		this.firm_name = firm_name;
		this.mobile1 = mobile1;
		this.mobile2 = mobile2;
		this.mobile3 = mobile3;
		this.landline1 = landline1;
		this.landline2 = landline2;
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public String getFirm_name() {
		return firm_name;
	}

	public String getMobile1() {
		return mobile1;
	}

	public String getMobile2() {
		return mobile2;
	}

	public String getMobile3() {
		return mobile3;
	}

	public String getLandline1() {
		return landline1;
	}

	public String getLandline2() {
		return landline2;
	}
}
