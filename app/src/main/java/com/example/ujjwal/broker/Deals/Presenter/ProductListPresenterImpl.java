package com.example.ujjwal.broker.Deals.Presenter;

import android.util.Log;

import com.example.ujjwal.broker.Deals.Model.Data.ProductListData;
import com.example.ujjwal.broker.Deals.Model.ProductListDetailsProvider;
import com.example.ujjwal.broker.Deals.ProductCallback;
import com.example.ujjwal.broker.Deals.View.ProductView;

/**
 * Created by ujjwal on 19/12/16.
 */
public class ProductListPresenterImpl implements ProductListPresenter {

	ProductView productView;
	ProductListDetailsProvider productListDetailsProvider;
	public ProductListPresenterImpl(ProductView productView,
									ProductListDetailsProvider productListDetailsProvider) {
		this.productListDetailsProvider=productListDetailsProvider;
		this.productView=productView;
	}


	@Override
	public void requestProductList(String access_token, int category_id) {
		productView.showProgressBar(true);
		productListDetailsProvider.requestProductList(access_token,category_id,	new ProductCallback() {
			@Override
			public void onSuccess(ProductListData productListData) {
				productView.showProgressBar(false);
				if (productListData.isSuccess()){
//					Log.i("ProductPresenter","List Recieved Size:"+productListData.getProductDetails().size());
					productView.setProductData(productListData.getProductDetails());
				}else {
					productView.showMessage("Something Went Wrong");
				}
			}

			@Override
			public void onFailure() {
				productView.showMessage("Wrong Products");
			}
		});
	}

}
