package com.example.ujjwal.broker.SellBuy;

import com.example.ujjwal.broker.SellBuy.Model.Data.BuySellResponse;

/**
 * Created by ujjwal on 29/12/16.
 */
public interface BuySellCallback {
	void onSuccess(BuySellResponse buySellResponse);
	void onFailure();

}
