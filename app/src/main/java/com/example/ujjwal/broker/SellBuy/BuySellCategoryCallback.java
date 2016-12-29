package com.example.ujjwal.broker.SellBuy;

import com.example.ujjwal.broker.SellBuy.Model.Data.SellBuyData;

/**
 * Created by ujjwal on 29/12/16.
 */
public interface BuySellCategoryCallback {
	void onSuccess(SellBuyData sellBuyData);
	void onFailure();

}
