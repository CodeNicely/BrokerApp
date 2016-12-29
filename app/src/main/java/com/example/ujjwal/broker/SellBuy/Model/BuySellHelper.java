package com.example.ujjwal.broker.SellBuy.Model;

import com.example.ujjwal.broker.SellBuy.BuySellCallback;

/**
 * Created by ujjwal on 29/12/16.
 */
public interface BuySellHelper {
	void getBuySellData(String accessToken, int product_id, String price, BuySellCallback buySellCallback);
}
