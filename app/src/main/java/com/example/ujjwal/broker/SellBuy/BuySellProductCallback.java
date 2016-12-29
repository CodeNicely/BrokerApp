package com.example.ujjwal.broker.SellBuy;

import com.example.ujjwal.broker.SellBuy.Model.Data.SellBuyProductData;

/**
 * Created by ujjwal on 29/12/16.
 */
public interface BuySellProductCallback {
	void onSuccess(SellBuyProductData sellBuyProductData);
	void onFailure();

}
