package com.example.ujjwal.broker.Deals.View;

import android.content.Context;
import android.provider.Settings;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ujjwal.broker.Deals.Model.Data.ProductListDetails;
import com.example.ujjwal.broker.R;
import com.example.ujjwal.broker.helper.SharedPrefs;
import com.example.ujjwal.broker.helper.image_loader.GlideImageLoader;
import com.example.ujjwal.broker.helper.image_loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ujjwal on 19/12/16.
 */
public class ProductsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	Context context;
	ProductsFragment productsFragment;
	ProductListDetails productListDetails;
	List<ProductListDetails> productListDetailsList=new ArrayList<>();
	SharedPrefs sharedPrefs;
	LayoutInflater layoutInflater;
	ImageLoader imageLoader;

	public ProductsRecyclerAdapter(Context context, ProductsFragment productsFragment) {
		this.context = context;
		this.productsFragment = productsFragment;
		layoutInflater = LayoutInflater.from(context);
		sharedPrefs=new SharedPrefs(context);
		imageLoader=new GlideImageLoader(context);
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view=layoutInflater.inflate(R.layout.product_item,parent,false);
		return new ProductViewHolder(view);
	}


	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

		productListDetails=productListDetailsList.get(position);
		final ProductViewHolder productViewHolder= (ProductViewHolder) holder;
		productViewHolder.productName.setText(productListDetails.getName());
		productViewHolder.productDescription.setText(productListDetails.getDescription());
		productViewHolder.productRate.setText(productListDetails.getRate());
		productViewHolder.productRate.append(" ");
		productViewHolder.productRate.append(productListDetails.getUnit());

		productViewHolder.sellButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				productsFragment.getProductDetails(v,sharedPrefs.getAccessToken(),
						productListDetailsList.get(position).getId(),1,position);
				Log.i("ProductsRecyclerAdapter","productIDSELL"+productListDetailsList.get(position).getId());
			}
		});
		productViewHolder.buyButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				productsFragment.getProductDetails(v,sharedPrefs.getAccessToken(),
						productListDetailsList.get(position).getId(),0,position);
				Log.i("ProductsRecyclerAdapter","productIDBUY"+productListDetailsList.get(position).getId());

			}
		});

		Log.d("itemPosition",Integer.toString(position)+""+productListDetails.getId());

		imageLoader.LoadImage(productListDetails.getImage(),productViewHolder.productImage,
				productViewHolder.progressBar);

		Glide.with(context).load(productListDetails.getImage()).into(productViewHolder.productImage);
	}


	public void setData(List<ProductListDetails> productListDetails) {
		this.productListDetailsList = productListDetails;
	}

	@Override
	public int getItemCount() {
		return productListDetailsList.size();
	}

	private class ProductViewHolder extends RecyclerView.ViewHolder {

		@BindView(R.id.product_name)
		TextView productName;
		@BindView(R.id.product_rate)
		TextView productRate;
		@BindView(R.id.product_image)
		ImageView productImage;
		@BindView(R.id.product_description)
		TextView productDescription;
		@BindView(R.id.imageProgressBar)
		ProgressBar progressBar;
		@BindView(R.id.product_card)
		CardView productCard;
		@BindView(R.id.button_sell)
		Button sellButton;
		@BindView(R.id.button_buy)
		Button buyButton;

		public ProductViewHolder(View view) {
			super(view);
			ButterKnife.bind(this,view);
		}
	}
}
