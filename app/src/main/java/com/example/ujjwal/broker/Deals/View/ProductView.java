package com.example.ujjwal.broker.Deals.View;

import android.view.View;

import com.example.ujjwal.broker.Deals.Model.Data.ProductListDetails;

import java.util.List;

/**
 * Created by ujjwal on 19/12/16.
 */
public interface ProductView {
	void showProgressBar(boolean show);
	void showMessage(String message);


	void setProductData(List<ProductListDetails> productListDetails);

}
