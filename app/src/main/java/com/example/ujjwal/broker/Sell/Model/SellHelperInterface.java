package com.example.ujjwal.broker.Sell.Model;

import com.example.ujjwal.broker.Sell.SellCallback;

/**
 * Created by ujjwal on 15/12/16.
 */
public interface SellHelperInterface {
	void sellData(String access_token, boolean type, String product, String sub_product, String rate,
			 String quantity,SellCallback sellCallback);
}
