package com.example.ujjwal.broker.Deals.Model;

import com.example.ujjwal.broker.Deals.CategoryCallback;

/**
 * Created by ujjwal on 19/12/16.
 */
public interface CategoryProvider {
	void requestCategoryDetails(String access_token, CategoryCallback categoryCallback);
}
