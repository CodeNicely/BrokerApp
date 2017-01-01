package com.example.ujjwal.broker.Deals.Presenter;

import com.example.ujjwal.broker.Deals.Model.Data.SellBuyResponse;
import com.example.ujjwal.broker.Deals.Model.SellBuyHelper;
import com.example.ujjwal.broker.Deals.SellBuyCallback;
import com.example.ujjwal.broker.Deals.View.ProductView;

/**
 * Created by ujjwal on 21/12/16.
 */
public class SellBuyPresenterImpl implements SellBuyPresenter {
	ProductView productView;
	SellBuyHelper sellBuyHelper;

	public SellBuyPresenterImpl(ProductView productView, SellBuyHelper sellBuyHelper) {
		this.productView = productView;
		this.sellBuyHelper = sellBuyHelper;
	}

	@Override
	public void getSellBuyDetails(String accessToken, int id) {
	sellBuyHelper.getSellBuyDetails(accessToken,id, new SellBuyCallback() {
		@Override
		public void onSuccess(SellBuyResponse sellBuyResponse) {
			if (sellBuyResponse.isSuccess()){
				productView.showMessage(sellBuyResponse.getMessage());
			}else {
				productView.showMessage(sellBuyResponse.getMessage());
			}
		}

		@Override
		public void onFailure() {
				productView.showMessage("Something Went Wrong");
		}
	});
	}
}
