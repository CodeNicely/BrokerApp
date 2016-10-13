package com.example.ujjwal.broker.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.ujjwal.broker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ujjwal on 11/10/16.
 */
public class BuyFragment extends Fragment {


    private static final String TAG = "SellFragment";
    @BindView(R.id.spinner_bcategory)
    Spinner spinnerCategory;
    private Activity rootView;

    public BuyFragment(){


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_buy, container, false);

        ButterKnife.bind(this,rootView);
        Log.i(TAG,this.spinnerCategory.toString());

        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });



    return rootView;



    }
}
