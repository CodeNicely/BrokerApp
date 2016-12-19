package com.example.ujjwal.broker.Deals.Presenter;

import com.example.ujjwal.broker.Deals.Model.MockProductListDetailsProvider;
import com.example.ujjwal.broker.Deals.Model.ProductListDetailsProvider;
import com.example.ujjwal.broker.Deals.View.ProductView;
import com.example.ujjwal.broker.Deals.View.ProductsFragment;

/**
 * Created by ujjwal on 19/12/16.
 */
public interface ProductListPresenter {
	void requestProductList(String productView, int productListDetailsProvider);
}
