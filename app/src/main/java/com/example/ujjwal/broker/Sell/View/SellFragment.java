package com.example.ujjwal.broker.Sell.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ujjwal.broker.Buy.Presenter.BuyPresenter;
import com.example.ujjwal.broker.R;
import com.example.ujjwal.broker.Sell.Model.RetrofitSellHelper;
import com.example.ujjwal.broker.Sell.Presenter.SellPresenter;
import com.example.ujjwal.broker.Sell.Presenter.SellPresenterImp;
import com.example.ujjwal.broker.helper.SharedPrefs;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ujjwal on 13/12/16.
 */
public class SellFragment extends Fragment implements SellFragmentInterface, View.OnClickListener {
	private static final String TAG ="SellFragment";

	@BindView(R.id.spinner_product)
	 Spinner spinnerProduct;
	@BindView(R.id.spinner_subproduct)
	 Spinner spinnerSubProduct;
	@BindView(R.id.sell_rate)
	EditText editTextRate;
	@BindView(R.id.sell_quantity)
	EditText editTextQuantity;
	@BindView(R.id.sell_submit)
	 Button submit;
	@BindView(R.id.progress_bar)
	ProgressBar progressBar;

	private String rate,quantity,product,sub_product;
	private SellPresenter sellPresenter;

	private SharedPrefs sharedPrefs;


	String[] SPINNERVALUES_PRODUCT = {"RICE","WHEAT","DAAL","..."};
	String[] SPINNERVALUES_SUBPRODUCT = {"RICE","WHEAT","DAAL","..."};

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView=inflater.inflate(R.layout.fragment_sell,container,false);

			ButterKnife.bind(this,rootView);
			sharedPrefs=new SharedPrefs(getContext());
			addItemsOnSpinner();
			initialise();
		return rootView;
	}

	private void initialise() {
		sellPresenter =new SellPresenterImp(this,new RetrofitSellHelper()) ;
		rate=editTextRate.getText().toString();
		quantity=editTextQuantity.getText().toString();
		submit.setOnClickListener(this);

		spinnerProduct.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				product= (String) spinnerProduct.getSelectedItem();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});
		spinnerSubProduct.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				sub_product= (String) spinnerSubProduct.getSelectedItem();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});
	}

	private void addItemsOnSpinner() {
		ArrayAdapter<String> adapter1=new ArrayAdapter<String>(getActivity(),
			android.R.layout.simple_list_item_1,SPINNERVALUES_PRODUCT);
		spinnerProduct.setAdapter(adapter1);
		ArrayAdapter<String> adapter2 =new ArrayAdapter<String>(getActivity(),
			android.R.layout.simple_list_item_1,SPINNERVALUES_SUBPRODUCT);
		spinnerSubProduct.setAdapter(adapter2);


	}

	@Override
	public void showProgressBar(boolean show) {
	if(show){
	progressBar.setVisibility(View.VISIBLE);
	}
	progressBar.setVisibility(View.INVISIBLE);
	}

	@Override
	public void showMessage(String message) {
		Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
	}

	@Override
	public void onClick(View v) {
		if(v==submit){
			if(rate.isEmpty() || quantity.isEmpty() ||product.isEmpty() ||sub_product.isEmpty() ){
				showProgressBar(false);
				showMessage("Fields cannot be empty");
			}else {
				sellPresenter.getSellData(sharedPrefs.getAccessToken(), product,sub_product,rate,quantity);
			}

		}

	}
}
