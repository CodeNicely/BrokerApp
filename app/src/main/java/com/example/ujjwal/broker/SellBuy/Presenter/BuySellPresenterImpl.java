package com.example.ujjwal.broker.SellBuy.Presenter;

import com.example.ujjwal.broker.SellBuy.BuySellCallback;
import com.example.ujjwal.broker.SellBuy.Model.BuySellHelper;
import com.example.ujjwal.broker.SellBuy.Model.Data.BuySellResponse;
import com.example.ujjwal.broker.SellBuy.Model.RetrofitBuySellHelper;
import com.example.ujjwal.broker.SellBuy.View.BuySellView;
import com.example.ujjwal.broker.SellBuy.View.SellBuyFragment;

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
	public void getBuySellData(String accessToken, int product_id, String price) {
		buySellView.showProgressBar(true);
		buySellHelper.getBuySellData(accessToken,product_id,price, new BuySellCallback() {
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
