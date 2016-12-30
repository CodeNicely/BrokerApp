package com.example.ujjwal.broker.Deals.Model;

import android.nfc.Tag;
import android.util.Log;

import com.example.ujjwal.broker.Deals.CategoryCallback;
import com.example.ujjwal.broker.Deals.Model.Data.CategoryData;
import com.example.ujjwal.broker.Deals.Model.Data.CategoryDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ujjwal on 19/12/16.
 */

public class MockCategoryDetailsProvider implements CategoryProvider {

	@Override
	public void requestCategoryDetails(String access_token, CategoryCallback categoryCallback) {
		List<CategoryDetails> categoryDetailsList=new ArrayList<>();
		CategoryDetails categoryDetails=new CategoryDetails(1,"Rice","Food");
		categoryDetailsList.add(categoryDetails);
		for (int i=0;i<10;i++){
			CategoryDetails categoryDetails1=new CategoryDetails(i,"Rice","Food");
			categoryDetailsList.add(categoryDetails1);
		}

		CategoryData categoryData=new CategoryData("Succesful",true,categoryDetailsList);
		Log.i("","Response:"+categoryData.getCategoryList().size());
		categoryCallback.onSuccess(categoryData);
	}

}
