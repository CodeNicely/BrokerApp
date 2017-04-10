package com.example.ujjwal.broker.Deals.View;

import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ujjwal.broker.Deals.Model.Data.CategoryData;
import com.example.ujjwal.broker.Deals.Model.Data.CategoryDetails;
import com.example.ujjwal.broker.Deals.Model.MockCategoryDetailsProvider;
import com.example.ujjwal.broker.Deals.Model.RetrofitCategoryProvider;
import com.example.ujjwal.broker.Deals.Presenter.CategoryPresenter;
import com.example.ujjwal.broker.Deals.Presenter.CategoryPresenterImpl;
import com.example.ujjwal.broker.R;
import com.example.ujjwal.broker.helper.Keys;
import com.example.ujjwal.broker.helper.SharedPrefs;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ujjwal on 19/12/16.
 */
public class CategoryFragment extends Fragment implements CategoryView {

	@BindView(R.id.viewpager_deals)
	ViewPager viewPager;

	@BindView(R.id.progressBar)
	ProgressBar progressBar;
	@BindView(R.id.tablayout_deals)
	TabLayout tabLayout;

	CategoryPresenter categoryPresenter;
	ViewPagerAdapter viewPagerAdapter;
	SharedPrefs sharedPrefs;
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view= inflater.inflate(R.layout.fragment_deals,container,false);
		ButterKnife.bind(this,view);
		sharedPrefs=new SharedPrefs(getContext());

		categoryPresenter=new CategoryPresenterImpl(this,new RetrofitCategoryProvider());

		viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
		viewPager.setAdapter(viewPagerAdapter);
		tabLayout.setupWithViewPager(viewPager);
		tabLayout.setTabTextColors(ColorStateList.valueOf(ContextCompat.getColor(getContext(),
				R.color.textColorPrimary)));

		categoryPresenter.requestCategoryDetails(sharedPrefs.getAccessToken());
		return view;


	}

	@Override
	public void showProgressBar(boolean show) {
		if (show){
			progressBar.setVisibility(View.VISIBLE);
			tabLayout.setVisibility(View.GONE);
			viewPager.setVisibility(View.GONE);

		}else {
			progressBar.setVisibility(View.GONE);
			tabLayout.setVisibility(View.VISIBLE);
			viewPager.setVisibility(View.VISIBLE);
		}

	}

	@Override
	public void showMessage(String message) {
		Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
	}

	@Override
	public void setTabs(CategoryData categoryData) {
		if (categoryData.isSuccess()) {
			if (categoryData.getCategoryList().size() == 0) {
				tabLayout.setVisibility(View.GONE);
				viewPager.setVisibility(View.GONE);
			} else {
				tabLayout.setVisibility(View.VISIBLE);
				viewPager.setVisibility(View.VISIBLE);
			}
		}
		List<CategoryDetails> categoryDetailsList ;
		categoryDetailsList = categoryData.getCategoryList();

		List<Fragment> fragmentList = new ArrayList<>();
		List<String> titleList = new ArrayList<>();


		int i;
		for (i = 0; i < categoryDetailsList.size();i++){
			ProductsFragment fragment = ProductsFragment.newInstance(categoryDetailsList.get(i).getId());
			fragmentList.add(fragment);
			titleList.add(categoryDetailsList.get(i).getName());
			Log.i("Category Mock ","Response"+categoryDetailsList.get(i).getName());
		}


		viewPagerAdapter.setTabData(fragmentList, titleList);
		viewPagerAdapter.notifyDataSetChanged();


	}
}
