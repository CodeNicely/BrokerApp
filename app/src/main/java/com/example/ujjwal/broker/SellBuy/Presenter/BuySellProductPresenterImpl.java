package com.example.ujjwal.broker.SellBuy.Presenter;


import com.example.ujjwal.broker.SellBuy.BuySellProductCallback;
import com.example.ujjwal.broker.SellBuy.Model.BuySellProductProvider;
import com.example.ujjwal.broker.SellBuy.Model.Data.SellBuyProductData;
import com.example.ujjwal.broker.SellBuy.Model.RetrofitBuySellProductProvider;
import com.example.ujjwal.broker.SellBuy.View.BuySellView;
import com.example.ujjwal.broker.SellBuy.View.SellBuyFragment;

/**
 * Created by ujjwal on 29/12/16.
 */
public class BuySellProductPresenterImpl implements BuySellProductPresenter {
	private BuySellView buySellView;
	private BuySellProductProvider buySellProductProvider;

	public BuySellProductPresenterImpl(BuySellView buySellView, BuySellProductProvider buySellProductProvider) {
		this.buySellView = buySellView;
		this.buySellProductProvider = buySellProductProvider;
	}



	@Override
	public void requestProductList(Integer integer) {
		buySellView.showProgressBar(true);
		buySellProductProvider.requestProductList(integer, new BuySellProductCallback() {
			@Override
			public void onSuccess(SellBuyProductData sellBuyProductData) {
				buySellView.showProgressBar(false);
				if (sellBuyProductData.isSuccess()){
					buySellView.setProductList(sellBuyProductData);
				}else {
					buySellView.showMessage(sellBuyProductData.getMessage());
				}
			}

			@Override
			public void onFailure() {
				buySellView.showMessage("Something went wrong");
			}
		});
	}
}
