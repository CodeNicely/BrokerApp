package com.example.ujjwal.broker.SellBuy.Presenter;


import com.example.ujjwal.broker.SellBuy.BuySellCategoryCallback;
import com.example.ujjwal.broker.SellBuy.Model.BuySellCategoryProvider;
import com.example.ujjwal.broker.SellBuy.Model.Data.SellBuyData;
import com.example.ujjwal.broker.SellBuy.View.BuySellView;

/**
 * Created by ujjwal on 29/12/16.
 */
public class BuySellCategoryPresenterImpl implements BuySellCategoryPresenter {
	BuySellView buySellView;
	BuySellCategoryProvider buySellCategoryProvider;

	public BuySellCategoryPresenterImpl(BuySellView buySellView, BuySellCategoryProvider buySellCategoryProvider) {
		this.buySellView = buySellView;
		this.buySellCategoryProvider = buySellCategoryProvider;
	}

	@Override
	public void requestSellBuyCategoryList(String access_token) {
		buySellView.showProgressBar(true);
		buySellCategoryProvider.requestCategoryList(access_token,new BuySellCategoryCallback() {
			@Override
			public void onSuccess(SellBuyData sellBuyData) {
				buySellView.showProgressBar(false);
				if (sellBuyData.isSuccess()){
					buySellView.setCategoryList(sellBuyData);
				}else {
					buySellView.showMessage(sellBuyData.getMessage());
				}
			}

			@Override
			public void onFailure() {
				buySellView.showMessage("Something went wrong");
			}
		});
	}

}
