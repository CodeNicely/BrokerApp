package com.example.ujjwal.broker.Deals;

import com.example.ujjwal.broker.Deals.Model.Data.ProductListData;
import com.example.ujjwal.broker.Deals.Model.Data.SellBuyResponse;

/**
 * Created by ujjwal on 21/12/16.
 */
public interface SellBuyCallback {
	void onSuccess(SellBuyResponse sellBuyResponse);
	void onFailure();
}
