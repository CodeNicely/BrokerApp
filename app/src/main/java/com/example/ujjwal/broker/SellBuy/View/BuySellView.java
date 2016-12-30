package com.example.ujjwal.broker.SellBuy.View;

import com.example.ujjwal.broker.SellBuy.Model.Data.SellBuyData;

/**
 * Created by ujjwal on 29/12/16.
 */
public interface BuySellView {
	void showProgressBar(boolean show);
	void showMessage(String message);
	void setCategoryList(SellBuyData sellBuyData);

}
