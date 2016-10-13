	package com.example.ujjwal.broker.Fragments;

	import android.app.Activity;
	import android.content.Intent;
	import android.net.Uri;
	import android.os.Bundle;
	import android.support.annotation.Nullable;
	import android.support.v4.app.Fragment;
	import android.support.v4.app.LoaderManager;
	import android.util.Log;
	import android.view.LayoutInflater;
	import android.view.View;
	import android.view.ViewGroup;
	import android.widget.AdapterView;
	import android.widget.ArrayAdapter;
	import android.widget.Spinner;
	import android.widget.Toast;

	import com.example.ujjwal.broker.R;

	import butterknife.BindView;
	import butterknife.ButterKnife;


	public class SellFragment extends Fragment {


		private static final String TAG = "SellFragment";
		@BindView(R.id.spinner_category)
	Spinner spinnerCategory;
	private Activity rootView;

	public SellFragment() {

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_sell, container, false);

		ButterKnife.bind(this,rootView);

		Log.i(TAG,this.spinnerCategory.toString());
	//	addItemsOnSpinner();

		spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view,
									   int position, long id) {
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		// Inflate the layout for this fragment
		return rootView;
	}


	private void addItemsOnSpinner() {


		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
				R.array.android_dropdown_arrays, android.R.layout.simple_spinner_item);

		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spinnerCategory.setAdapter(adapter);

	/*	spinnerCategory.setOnItemSelectedListener(new CustomOnItemSelectedListener());

		*/


	/*	spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});*/


	}
/*

	public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {


		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int pos,
								   long id) {
			// TODO Auto-generated method stub
			if (parent.getItemAtPosition(pos).toString()
						.equals("Rice")) {

			} else if (parent.getItemAtPosition(pos).toString()
							   .equals("Dhan")) {

			}

		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub

		}

	}

*/

}