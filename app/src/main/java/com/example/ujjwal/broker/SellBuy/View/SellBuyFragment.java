package com.example.ujjwal.broker.SellBuy.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ujjwal.broker.R;
import com.example.ujjwal.broker.SellBuy.Model.Data.SellBuyCategoryDetails;
import com.example.ujjwal.broker.SellBuy.Model.Data.SellBuyData;
import com.example.ujjwal.broker.SellBuy.Model.RetrofitBuySellCategoryProvider;

import com.example.ujjwal.broker.SellBuy.Model.RetrofitBuySellHelper;
import com.example.ujjwal.broker.SellBuy.Presenter.BuySellCategoryPresenter;
import com.example.ujjwal.broker.SellBuy.Presenter.BuySellCategoryPresenterImpl;
import com.example.ujjwal.broker.SellBuy.Presenter.BuySellPresenter;
import com.example.ujjwal.broker.SellBuy.Presenter.BuySellPresenterImpl;
import com.example.ujjwal.broker.helper.SharedPrefs;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SellBuyFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class SellBuyFragment extends Fragment implements BuySellView, View.OnClickListener {

	private static final String TAG = "BuyFragment";

	@BindView(R.id.spinner_category)
	Spinner spinnerCategory;
	@BindView(R.id.spinner_unit)
	Spinner spinnerUnit;

	@BindView(R.id.edittext_product_name)
	EditText editTextProductName;
	@BindView(R.id.edittext_product_description)
	EditText editTextProductDescription;

	@BindView(R.id.buy_rate)
	EditText editTextPrice;

	@BindView(R.id.buy_submit)
	Button submit;
	@BindView(R.id.progress_bar)
	ProgressBar progressBar;
	@BindView(R.id.toolbar_buy_sell)
	Toolbar toolbar;

	@BindView(R.id.type)
	RadioGroup radioGroup;
	private String price,product_name,product_description, category,unit;

	private BuySellCategoryPresenter buySellCategoryPresenter;
	private BuySellPresenter buySellPresenter;
	private SharedPrefs sharedPrefs;
	private 	int j=0;//category_id
	private OnFragmentInteractionListener mListener;

	public SellBuyFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_buy_sell,container,false);

		ButterKnife.bind(this,view);
		sharedPrefs = new SharedPrefs(getContext());


		toolbar.setTitle("Sell/Buy");
		toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
		toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				getActivity().onBackPressed();
			}
		});

		buySellCategoryPresenter=new BuySellCategoryPresenterImpl(this,new RetrofitBuySellCategoryProvider());
		buySellCategoryPresenter.requestSellBuyCategoryList(sharedPrefs.getAccessToken());

		buySellPresenter=new BuySellPresenterImpl(this,new RetrofitBuySellHelper());

		submit.setOnClickListener(this);

		// Inflate the layout for this fragment
		return view;
	}

	// TODO: Rename method, update argument and hook method into UI event
	public void onButtonPressed(Uri uri) {
		if (mListener != null) {
			mListener.onFragmentInteraction(uri);
		}
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if (context instanceof OnFragmentInteractionListener) {
			mListener = (OnFragmentInteractionListener) context;
		} else {
			throw new RuntimeException(context.toString()
						   + " must implement OnFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}

	@Override
	public void showProgressBar(boolean show) {
		if (show){
			progressBar.setVisibility(View.VISIBLE);

		}else {
			progressBar.setVisibility(View.GONE);
		}

	}

	@Override
	public void showMessage(String message) {
		Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
	}

	@Override
	public void setCategoryList(SellBuyData sellBuyData) {


		final ArrayList<SellBuyCategoryDetails> categoryDetailsList;
		Log.d(TAG,sellBuyData.getCategory_list().toString());
		categoryDetailsList = sellBuyData.getCategory_list();
		final ArrayList<String> categoryNameList=new ArrayList<>();
		final ArrayList<Integer> categoryIdList=new ArrayList<>();
		for (int i=0;i<categoryDetailsList.size();i++) {
			categoryNameList.add(categoryDetailsList.get(i).getName());
			categoryIdList.add(categoryDetailsList.get(i).getId());
		}
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(),
						android.R.layout.simple_list_item_1,categoryNameList);
		spinnerCategory.setAdapter(adapter1);

		spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				category= (String) spinnerCategory.getSelectedItem();

				for (int i=0;i<categoryDetailsList.size();i++){
					if (categoryNameList.get(i)==category){
						 j=i;
						break;

					}
				}
					//category_id=j
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});


		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(),
							android.R.layout.simple_list_item_1,sellBuyData.getUnit_list());
		spinnerUnit.setAdapter(adapter2);
		spinnerUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				unit= (String) spinnerUnit.getSelectedItem();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});




	}

	@Override
	public void onClick(View v) {

		product_name=editTextProductName.getText().toString();
		product_description=editTextProductDescription.getText().toString();
		price = editTextPrice.getText().toString();

		if (v == submit) {
			if (price.isEmpty() ||  product_name.isEmpty()||product_description.isEmpty() || category.isEmpty()) {
				showProgressBar(false);
				showMessage("Fields cannot be empty");
			} else {


				buySellPresenter.getBuySellData(sharedPrefs.getAccessToken(),j,product_name,product_description,price,unit);
			}
		}
	}

	/**
	 * This interface must be implemented by activities that contain this
	 * fragment to allow an interaction in this fragment to be communicated
	 * to the activity and potentially other fragments contained in that
	 * activity.
	 * <p/>
	 * See the Android Training lesson <a href=
	 * "http://developer.android.com/training/basics/fragments/communicating.html"
	 * >Communicating with Other Fragments</a> for more information.
	 */
	public interface OnFragmentInteractionListener {
		// TODO: Update argument type and name
		void onFragmentInteraction(Uri uri);
	}
}
