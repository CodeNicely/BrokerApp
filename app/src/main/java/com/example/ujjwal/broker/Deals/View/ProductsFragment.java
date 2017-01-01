package com.example.ujjwal.broker.Deals.View;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ujjwal.broker.Deals.Model.Data.ProductListDetails;
import com.example.ujjwal.broker.Deals.Model.MockProductListDetailsProvider;

import com.example.ujjwal.broker.Deals.Model.MockSellBuyHelper;
import com.example.ujjwal.broker.Deals.Model.RetrofitProductProvider;
import com.example.ujjwal.broker.Deals.Presenter.ProductListPresenter;
import com.example.ujjwal.broker.Deals.Presenter.ProductListPresenterImpl;
import com.example.ujjwal.broker.Deals.Presenter.SellBuyPresenter;
import com.example.ujjwal.broker.Deals.Presenter.SellBuyPresenterImpl;
import com.example.ujjwal.broker.R;
import com.example.ujjwal.broker.helper.SharedPrefs;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProductsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProductsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductsFragment extends Fragment implements ProductView {
	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String CATEGORY_ID = "categoryId";
	// TODO: Rename and change types of parameters
	private int categoryId=-1;
	@BindView(R.id.recyclerView)
	RecyclerView recyclerView;
	@BindView(R.id.progressBar)
	ProgressBar progressBar;
	@BindView(R.id.toolbar)
	Toolbar toolbar;


	private OnFragmentInteractionListener mListener;
	SharedPrefs sharedPrefs;
	ProductListPresenter productListPresenter;
	ProductsRecyclerAdapter productsRecyclerAdapter;
	SellBuyPresenter sellBuyPresenter;
	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @param categoryId Parameter 1.
	 * @return A new instance of fragment ProductsFragment.
	*/// TODO: Rename and change types and number of parameters
	public static ProductsFragment newInstance(int categoryId) {
		ProductsFragment fragment = new ProductsFragment();
		Bundle args = new Bundle();
		args.putInt(CATEGORY_ID, categoryId);
		fragment.setArguments(args);
		return fragment;
	}

	public ProductsFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			categoryId = getArguments().getInt(CATEGORY_ID);

		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.fragment_products,container,false);
		// Inflate the layout for this fragment
		ButterKnife.bind(this,v);
		sharedPrefs=new SharedPrefs(getContext());
		initialise();
		if (categoryId==-1){
			toolbar.setVisibility(View.VISIBLE);
			productListPresenter.requestProductList(sharedPrefs.getAccessToken(),categoryId);
		}
		else {
			toolbar.setVisibility(View.GONE);
			productListPresenter.requestProductList(sharedPrefs.getAccessToken(),categoryId);
		}


		return v;
	}

	private void initialise() {
		productListPresenter=new ProductListPresenterImpl(this,new RetrofitProductProvider());
		sellBuyPresenter=new SellBuyPresenterImpl(this,new MockSellBuyHelper());
		LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
		recyclerView.setLayoutManager(linearLayoutManager);
		recyclerView.setHasFixedSize(true);
		productsRecyclerAdapter=new ProductsRecyclerAdapter(getContext(),this);
		recyclerView.setAdapter(productsRecyclerAdapter);
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
		if (show) {
			progressBar.setVisibility(View.VISIBLE);
			recyclerView.setVisibility(View.GONE);
		}else {
			progressBar.setVisibility(View.GONE);
			recyclerView.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void showMessage(String message) {
		Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
	}

	@Override
	public void updateAdapter() {
		productsRecyclerAdapter.notifyDataSetChanged();
	}

	@Override
	public void setProductData(List<ProductListDetails> productListDetails) {
		if (productListDetails.size()==0){
		recyclerView.setVisibility(View.GONE);
		}else {
		recyclerView.setVisibility(View.VISIBLE);
		}
		productsRecyclerAdapter.setData(productListDetails);

		productsRecyclerAdapter.notifyDataSetChanged();

	}


	public void onSellBuy(String accessToken, int id) {

		//sellBuyPresenter.getSellBuyDetails(accessToken, id);

		String moblie_no = "9425503905";

		String uri = "tel:" + moblie_no.trim() ;
		Intent intent = new Intent(Intent.ACTION_DIAL);
		intent.setData(Uri.parse(uri));
		startActivity(intent);
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
