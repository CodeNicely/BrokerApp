package com.example.ujjwal.broker.Buy.Model.Data;

/**
 * Created by ujjwal on 14/12/16.
 */
public class BuyResponse {
	private  boolean success;
	private String message;
	 public void BuyResponse(boolean success ,String message){
		 this.message=message;
		 this.success=success;
	 }
	public boolean isSuccess(){
		return success;
	}
	public String getMessage(){
		return message;
	}

}
