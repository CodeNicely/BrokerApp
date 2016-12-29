package com.example.ujjwal.broker.SellBuy.Model;

import com.example.ujjwal.broker.SellBuy.BuySellCategoryCallback;

/**
 * Created by ujjwal on 29/12/16.
 */
public interface BuySellCategoryProvider {
	void requestCategoryList(BuySellCategoryCallback buySellCategoryCallback);
}
