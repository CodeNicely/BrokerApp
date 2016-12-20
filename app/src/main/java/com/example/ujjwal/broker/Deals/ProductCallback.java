package com.example.ujjwal.broker.Deals;

import com.example.ujjwal.broker.Deals.Model.Data.ProductListData;

/**
 * Created by ujjwal on 21/12/16.
 */
public interface ProductCallback {
	void onSuccess(ProductListData productListData);
	void onFailure();
}
