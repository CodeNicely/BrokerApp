package com.example.ujjwal.broker.Deals;

import com.example.ujjwal.broker.Deals.Model.Data.CategoryData;

/**
 * Created by ujjwal on 13/12/16.
 */
public interface CategoryCallback {
	void onSuccess(CategoryData categoryData);
	void onFailure();
}
