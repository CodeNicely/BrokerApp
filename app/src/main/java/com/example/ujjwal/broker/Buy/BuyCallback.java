package com.example.ujjwal.broker.Buy;

import com.example.ujjwal.broker.Buy.Model.Data.BuyResponse;

/**
 * Created by ujjwal on 13/12/16.
 */
public interface BuyCallback {

	public void onBuySuccess(BuyResponse buyResponse);
	public void onBuyFailure(String error);
}
