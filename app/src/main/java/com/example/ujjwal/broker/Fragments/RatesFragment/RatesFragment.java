package com.example.ujjwal.broker.Fragments.RatesFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ujjwal.broker.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ujjwal on 11/10/16.
 */
public class RatesFragment extends android.support.v4.app.Fragment {

    private List<Rates> rateList = new ArrayList<>();
    private RecyclerView recyclerView;

    private RatesAdapter mAdapter;


    public RatesFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.deals_activity,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        mAdapter = new RatesAdapter(rateList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(mAdapter);

        prepareRateData();

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void prepareRateData() {


        Rates rate = new Rates("Rice", "2000");
        rateList.add(rate);

        rate = new Rates("Broken", "1200");
        rateList.add(rate);

        rate = new Rates("Broken", "1200");
        rateList.add(rate);

        rate = new Rates("Broken", "1200");
        rateList.add(rate);

        rate = new Rates("Broken", "1200");
        rateList.add(rate);

        rate = new Rates("Broken", "1200");
        rateList.add(rate);

        rate = new Rates("Broken", "1200");
        rateList.add(rate);

        rate = new Rates("Broken", "1200");
        rateList.add(rate);

        rate = new Rates("Broken", "1200");
        rateList.add(rate);

        rate = new Rates("Broken", "1200");
        rateList.add(rate);


        mAdapter.notifyDataSetChanged();
    }


}
