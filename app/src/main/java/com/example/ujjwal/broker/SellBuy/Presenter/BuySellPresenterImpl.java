package com.example.ujjwal.broker.SellBuy.Presenter;

import com.example.ujjwal.broker.SellBuy.BuySellCallback;
import com.example.ujjwal.broker.SellBuy.Model.BuySellHelper;
import com.example.ujjwal.broker.SellBuy.Model.Data.BuySellResponse;
import com.example.ujjwal.broker.SellBuy.View.BuySellView;

/**
 * Created by ujjwal on 29/12/16.
 */
public class BuySellPresenterImpl implements BuySellPresenter {
	private BuySellView buySellView;
	private BuySellHelper buySellHelper;

	public BuySellPresenterImpl(BuySellView buySellView, BuySellHelper buySellHelper) {
		this.buySellView = buySellView;
		this.buySellHelper = buySellHelper;
	}

	@Override
	public void getBuySellData(String accessToken, int id, String product_name, String product_description, String price, String unit) {
		buySellView.showProgressBar(true);
		buySellHelper.getBuySellData(accessToken,id,product_name,product_description,price,unit, new BuySellCallback() {
			@Override
			public void onSuccess(BuySellResponse buySellResponse) {
				buySellView.showProgressBar(false);
				if (buySellResponse.isSuccess()){
					buySellView.showMessage(buySellResponse.getMessage());
				}else {
					buySellView.showMessage(buySellResponse.getMessage());
				}
			}

			@Override
			public void onFailure() {
				buySellView.showMessage("Something went wrong");
			}
		});
	}
}
