package com.example.ujjwal.broker.Deals.Model;

import android.util.Log;

import com.example.ujjwal.broker.Deals.Model.Data.SellBuyResponse;
import com.example.ujjwal.broker.Deals.SellBuyCallback;

/**
 * Created by ujjwal on 21/12/16.
 */
public class MockSellBuyHelper implements SellBuyHelper {


	@Override
	public  void getSellBuyDetails(String accessToken, int id, SellBuyCallback sellBuyCallback) {
		SellBuyResponse sellBuyResponse=new SellBuyResponse(true,"Sell Successful");
		Log.i("","Response:"+sellBuyResponse.getMessage());
		sellBuyCallback.onSuccess(sellBuyResponse);

	}
}
