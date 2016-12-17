package com.example.ujjwal.broker.Sell;

import com.example.ujjwal.broker.Sell.Model.Data.SellResponse;

/**
 * Created by ujjwal on 13/12/16.
 */
public interface SellCallback {
	void onSuccess(SellResponse sellResponse);
	void onFialure(String error);
}
