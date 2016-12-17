package com.example.ujjwal.broker.Sell.Presenter;

/**
 * Created by ujjwal on 15/12/16.
 */
public interface SellPresenter {
	void getSellData(String accessToken, String product, String sub_product, String rate, String quantity);
}
