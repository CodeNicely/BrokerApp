package com.example.ujjwal.broker.Developer.View;

import
		android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.ujjwal.broker.R;
import com.example.ujjwal.broker.helper.SharedPrefs;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DeveloperFragment extends Fragment {

	@BindView(R.id.toolbar_developer)
	Toolbar toolbar;

	@BindView(R.id.layout_developer)
	LinearLayout developerLayout;




	private OnFragmentInteractionListener mListener;

	public DeveloperFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view=inflater.inflate(R.layout.fragment_developer,container,false);

		ButterKnife.bind(this,view);
		toolbar.setTitle("Developer");

		toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
		toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				getActivity().onBackPressed();
			}
		});

		return view;

	}

	// TODO: Rename method, update argument and hook method into UI event
	public void onButtonPressed(Uri uri) {
		if (mListener != null) {
			mListener.onFragmentInteraction(uri);
		}
	}
	public interface OnFragmentInteractionListener {
		// TODO: Update argument type and name
		void onFragmentInteraction(Uri uri);
	}
}
