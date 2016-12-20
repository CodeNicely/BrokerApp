package com.example.ujjwal.broker.Deals.Model;

import com.example.ujjwal.broker.Deals.ProductCallback;

/**
 * Created by ujjwal on 19/12/16.
 */
public interface ProductListDetailsProvider {
	void requestProductList(String access_token, int category_id, ProductCallback productCallback);

}
