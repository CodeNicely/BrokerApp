package com.example.ujjwal.broker.SellBuy.Model;

import com.example.ujjwal.broker.SellBuy.BuySellProductCallback;

/**
 * Created by ujjwal on 29/12/16.
 */
public interface BuySellProductProvider {
	void requestProductList(Integer integer, BuySellProductCallback buySellProductCallback) ;
}
