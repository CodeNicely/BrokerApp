package com.example.ujjwal.broker.Deals.View;

import com.example.ujjwal.broker.Deals.Model.Data.CategoryData;

/**
 * Created by ujjwal on 19/12/16.
 */
public interface CategoryView {
	public void showProgressBar(boolean show);
	public void showMessage(String message);
	public void setTabs(CategoryData categoryData);
}
