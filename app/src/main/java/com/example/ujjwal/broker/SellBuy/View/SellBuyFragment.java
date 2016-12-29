package com.example.ujjwal.broker.SellBuy.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
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

import com.example.ujjwal.broker.Deals.Model.Data.CategoryDetails;
import com.example.ujjwal.broker.R;
import com.example.ujjwal.broker.SellBuy.Model.Data.SellBuyCategoryDetails;
import com.example.ujjwal.broker.SellBuy.Model.Data.SellBuyData;
import com.example.ujjwal.broker.SellBuy.Model.Data.SellBuyProductData;
import com.example.ujjwal.broker.SellBuy.Model.Data.SellBuyProductDetails;
import com.example.ujjwal.broker.SellBuy.Model.RetrofitBuySellCategoryProvider;

import com.example.ujjwal.broker.SellBuy.Model.RetrofitBuySellHelper;
import com.example.ujjwal.broker.SellBuy.Model.RetrofitBuySellProductProvider;
import com.example.ujjwal.broker.SellBuy.Presenter.BuySellCategoryPresenter;
import com.example.ujjwal.broker.SellBuy.Presenter.BuySellCategoryPresenterImpl;
import com.example.ujjwal.broker.SellBuy.Presenter.BuySellPresenter;
import com.example.ujjwal.broker.SellBuy.Presenter.BuySellPresenterImpl;
import com.example.ujjwal.broker.SellBuy.Presenter.BuySellProductPresenter;
import com.example.ujjwal.broker.SellBuy.Presenter.BuySellProductPresenterImpl;
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
	@BindView(R.id.spinner_product)
	Spinner spinnerProduct;
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
	private String price,product, category;
	private int product_id;
	private BuySellCategoryPresenter buySellCategoryPresenter;
	private BuySellProductPresenter buySellProductPresenter;
	private BuySellPresenter buySellPresenter;
	private SharedPrefs sharedPrefs;

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
		toolbar.setNavigationIcon(R.drawable.ic_menu_camera);
		toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				getActivity().onBackPressed();
			}
		});
		buySellCategoryPresenter=new BuySellCategoryPresenterImpl(this,new RetrofitBuySellCategoryProvider());
		buySellCategoryPresenter.requestSellBuyCategoryList();

		buySellProductPresenter=new BuySellProductPresenterImpl(this,new RetrofitBuySellProductProvider());
		buySellPresenter=new BuySellPresenterImpl(this,new RetrofitBuySellHelper());


		price = editTextPrice.getText().toString();

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


		final List<SellBuyCategoryDetails> categoryDetailsList ;
		categoryDetailsList = sellBuyData.getCategoryDetailsList();
		final ArrayList<String> categoryNameList=new ArrayList<>();
		final ArrayList<Integer> categoryIdList=new ArrayList<>();
		for (int i=0;i<categoryDetailsList.size();i++) {
			categoryNameList.set(i,categoryDetailsList.get(i).getCategory_name());
			categoryIdList.set(i,categoryDetailsList.get(i).getCategory_id());
		}
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(),
						android.R.layout.simple_list_item_1,categoryNameList);
		spinnerCategory.setAdapter(adapter1);

		spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				category= (String) spinnerCategory.getSelectedItem();
				int j=0;
				for (int i=0;i<categoryDetailsList.size();i++){
					if (categoryNameList.get(i)==category){
						 j=i;
						break;

					}
				}

				buySellProductPresenter.requestProductList(categoryIdList.get(j));

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});


	}

	@Override
	public void setProductList(SellBuyProductData sellBuyProductData) {
		final List<SellBuyProductDetails> productDetailsList ;
		productDetailsList = sellBuyProductData.getSellBuyProductDetailsList();
		final ArrayList<String> productNameList=new ArrayList<>();
		final ArrayList<Integer> productIdList=new ArrayList<>();

		for (int i=0;i<productDetailsList.size();i++) {
			productNameList.set(i,productDetailsList.get(i).getProduct_name());
			productIdList.set(i,productDetailsList.get(i).getProduct_id());
		}

		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(),
								android.R.layout.simple_list_item_1,productNameList);
		spinnerProduct.setAdapter(adapter1);

		spinnerProduct.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				product= (String) spinnerProduct.getSelectedItem();
				int j=0;
				for (int i=0;i<productDetailsList.size();i++){
					if (productNameList.get(i)==product){
						j=i;
						break;

					}
				}

				product_id=(productIdList.get(j));

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});

	}

	@Override
	public void onClick(View v) {
		if (v == submit) {
			if (price.isEmpty() ||  product.isEmpty() || category.isEmpty()) {
				showProgressBar(false);
				showMessage("Fields cannot be empty");
			} else {


				buySellPresenter.getBuySellData(sharedPrefs.getAccessToken(),product_id,price);
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
