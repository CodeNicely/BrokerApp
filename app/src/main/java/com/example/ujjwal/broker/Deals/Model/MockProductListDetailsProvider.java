package com.example.ujjwal.broker.Deals.Model;

import android.util.Log;

import com.example.ujjwal.broker.Deals.Model.Data.ProductListData;
import com.example.ujjwal.broker.Deals.Model.Data.ProductListDetails;
import com.example.ujjwal.broker.Deals.ProductCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ujjwal on 19/12/16.
 */
public class MockProductListDetailsProvider implements ProductListDetailsProvider{
	@Override
	public void requestProductList(String access_token, int category_id, ProductCallback productCallback) {
		List<ProductListDetails> productListDetails =new ArrayList<>();
		for (int i=0;i<10;i++){
			ProductListDetails productDetails=new ProductListDetails("Name",i,"Description",1000,"Unit","ABCD");
			productListDetails.add(productDetails);
		}

		ProductListData productListData=new ProductListData(true,"Successful",productListDetails);
		Log.i("","Response"+productListData.getProductDetails().size());
		productCallback.onSuccess(productListData);
	}
}
