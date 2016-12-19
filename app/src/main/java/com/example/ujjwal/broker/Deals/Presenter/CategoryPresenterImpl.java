package com.example.ujjwal.broker.Deals.Presenter;

import com.example.ujjwal.broker.Deals.CategoryCallback;
import com.example.ujjwal.broker.Deals.Model.CategoryProvider;
import com.example.ujjwal.broker.Deals.Model.Data.CategoryData;
import com.example.ujjwal.broker.Deals.Model.MockCategoryDetailsProvider;
import com.example.ujjwal.broker.Deals.Model.RetrofitCategoryProvider;
import com.example.ujjwal.broker.Deals.View.CategoryFragment;
import com.example.ujjwal.broker.Deals.View.CategoryView;

/**
 * Created by ujjwal on 19/12/16.
 */
public class CategoryPresenterImpl implements CategoryPresenter {
	CategoryView categoryView;
	CategoryProvider categoryProvider;


	public CategoryPresenterImpl(CategoryView categoryView, CategoryProvider categoryProvider) {
		this.categoryView = categoryView;
		this.categoryProvider = categoryProvider;
	}

	@Override
	public void requestCategoryDetails(String access_token) {
		categoryView.showProgressBar(true);
		categoryProvider.requestCategoryDetails(access_token, new CategoryCallback() {
			@Override
			public void onSuccess(CategoryData categoryData) {
				if (categoryData.isSuccess()){
					categoryView.setTabs(categoryData);
				}else {
					categoryView.showMessage("Something Went Wrong .Please try again later");
				}
				categoryView.showProgressBar(false);
			}

			@Override
			public void onFailure() {
				categoryView.showMessage("Failed");
			}
		});
	}
}
