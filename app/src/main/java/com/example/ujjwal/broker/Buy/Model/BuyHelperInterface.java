package com.example.ujjwal.broker.Buy.Model;

import com.example.ujjwal.broker.Buy.BuyCallback;

/**
 * Created by ujjwal on 14/12/16.
 */
public interface BuyHelperInterface {
	void buyData(String access_token,boolean type ,String product , String sub_product ,String rate,String quantity, BuyCallback buyCallback);
}
