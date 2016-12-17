package com.example.ujjwal.broker.Buy.Presenter;

import com.example.ujjwal.broker.Buy.BuyCallback;
import com.example.ujjwal.broker.Buy.Model.BuyHelperInterface;
import com.example.ujjwal.broker.Buy.Model.Data.BuyResponse;
import com.example.ujjwal.broker.Buy.Model.RetrofitBuyHelper;
import com.example.ujjwal.broker.Buy.View.BuyFragment;
import com.example.ujjwal.broker.Buy.View.BuyFragmentInterface;

/**
 * Created by ujjwal on 14/12/16.
 */
public class BuyPresenterImp implements  BuyPresenter {
	BuyFragmentInterface buyFragment;
	BuyHelperInterface buyHelper;


	public BuyPresenterImp(BuyFragment buyFragment, RetrofitBuyHelper retrofitBuyHelper) {
		this.buyFragment=buyFragment;
		this.buyHelper=retrofitBuyHelper;

	}


	@Override
	public void getBuyData(String access_token,String product, String sub_product,String rate,String quantity) {
		buyFragment.showProgressbar(true);
		buyHelper.buyData(access_token,true,product, sub_product, rate, quantity, new BuyCallback() {


			@Override
			public void onBuySuccess(BuyResponse buyResponse) {
				if (buyResponse.isSuccess()){
					buyFragment.showProgressbar(false);
				}else {
					buyFragment.showProgressbar(false);
					buyFragment.showMessage(buyResponse.getMessage());
				}

			}

			@Override
			public void onBuyFailure(String error) {
					buyFragment.showProgressbar(false);
				buyFragment.showMessage(error);
			}
		});


	}

}
