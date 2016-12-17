package com.example.ujjwal.broker.Sell.Model.Data;

/**
 * Created by ujjwal on 15/12/16.
 */
public class SellResponse {
private boolean status;
	private  String message ;
	public void SellResponse(String message,boolean status){
		this.status=status;
		this.message=message;

	}
	public boolean isSuccess(){
		return status;
	}
	public String getMessage(){
		return message;
	}


}
