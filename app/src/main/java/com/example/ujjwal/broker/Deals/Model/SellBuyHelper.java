package com.example.ujjwal.broker.Deals.Model;

import com.example.ujjwal.broker.Deals.SellBuyCallback;

/**
 * Created by ujjwal on 21/12/16.
 */
public interface SellBuyHelper {
	void getSellBuyDetails(String accessToken, int id, boolean i, SellBuyCallback sellBuyCallback);
}
