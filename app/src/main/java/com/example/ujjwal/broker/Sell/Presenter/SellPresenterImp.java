package com.example.ujjwal.broker.Sell.Presenter;

import com.example.ujjwal.broker.Sell.Model.Data.SellResponse;
import com.example.ujjwal.broker.Sell.Model.RetrofitSellHelper;
import com.example.ujjwal.broker.Sell.Model.SellHelperInterface;
import com.example.ujjwal.broker.Sell.SellCallback;
import com.example.ujjwal.broker.Sell.View.SellFragment;
import com.example.ujjwal.broker.Sell.View.SellFragmentInterface;

/**
 * Created by ujjwal on 15/12/16.
 */
public class SellPresenterImp implements SellPresenter {

	SellFragmentInterface sellFragmentInterface;
	SellHelperInterface sellHelperInterface;

	public SellPresenterImp(SellFragment sellFragment, RetrofitSellHelper retrofitSellHelper) {
	this.sellFragmentInterface=sellFragment;
	this.sellHelperInterface=retrofitSellHelper;
	}

	@Override
	public void getSellData(String accessToken, String product, String sub_product, String rate, String quantity) {
		sellFragmentInterface.showProgressBar(true);
		sellHelperInterface.sellData(accessToken,false,product,sub_product,rate,quantity,new SellCallback(){


			@Override
			public void onSuccess(SellResponse sellResponse) {

			}

			@Override
			public void onFialure(String error) {

			}
		});
	}
}
