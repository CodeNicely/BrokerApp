package com.example.ujjwal.broker.Buy.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ujjwal.broker.Buy.Model.RetrofitBuyHelper;
import com.example.ujjwal.broker.Buy.Presenter.BuyPresenter;
import com.example.ujjwal.broker.Buy.Presenter.BuyPresenterImp;
import com.example.ujjwal.broker.R;
import com.example.ujjwal.broker.helper.SharedPrefs;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ujjwal on 14/12/16.
 */
public class BuyFragment extends Fragment implements BuyFragmentInterface, View.OnClickListener {
	private static final String TAG = "BuyFragment";

	@BindView(R.id.spinner_category)
	 Spinner spinnerCategory;
	@BindView(R.id.spinner_product)
	 Spinner spinnerProduct;
	@BindView(R.id.buy_rate)
	 EditText editTextRate;
	@BindView(R.id.buy_submit)
	 Button submit;
	@BindView(R.id.progress_bar)
	ProgressBar progressBar;
	@BindView(R.id.toolbar_buy_sell)
	Toolbar toolbar;

	@BindView(R.id.type)
	RadioGroup radioGroup;
	private String rate, product, category;
	private BuyPresenter buyPresenter;


	private SharedPrefs sharedPrefs;
	String[] SPINNERVALUES_PRODUCT = {"RICE","WHEAT","DAAL","..."};
	String[] SPINNERVALUES_SUBPRODUCT = {"RICE","WHEAT","DAAL","..."};

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_buy_sell, container, false);
		ButterKnife.bind(this, rootView);

		toolbar.setTitle("Buy/Sell");
		toolbar.setNavigationIcon(ContextCompat.getDrawable(getContext(),R.drawable.ic_menu_camera));
		toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				getActivity().onBackPressed();
			}
		});

		sharedPrefs = new SharedPrefs(getContext());


		addItemsOnSpinner();
		initiaise();
		radioGroup.clearCheck();
		return rootView;
	}

	private void addItemsOnSpinner() {

		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(),
		    android.R.layout.simple_list_item_1, SPINNERVALUES_PRODUCT);
		spinnerProduct.setAdapter(adapter1);
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(),
			android.R.layout.simple_list_item_1, SPINNERVALUES_SUBPRODUCT);
		spinnerCategory.setAdapter(adapter2);

	}

	private void initiaise() {
		buyPresenter = new BuyPresenterImp(this, new RetrofitBuyHelper());
		rate = editTextRate.getText().toString();
		submit.setOnClickListener(this);
		spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				category = (String) spinnerCategory.getSelectedItem();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});
		spinnerProduct.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				product = (String) spinnerProduct.getSelectedItem();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});

	}


	@Override
	public void showProgressbar(boolean show) {
		if (show){
			progressBar.setVisibility(View.VISIBLE);
		}else {
			progressBar.setVisibility(View.INVISIBLE);
		}

	}

	@Override
	public void showMessage(String message) {
		Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
	}



	@Override
	public void onClick(View v) {
		if (v == submit) {
			if (rate.isEmpty() ||  product.isEmpty() || category.isEmpty()) {
				showProgressbar(false);
				showMessage("Fields cannot be empty");
			} else {

				buyPresenter.getBuyData(sharedPrefs.getAccessToken(), product, category,
						rate);
			}
		}
	}
}
