package com.example.ujjwal.broker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ujjwal on 11/10/16.
 */
public class RatesFragment extends android.support.v4.app.Fragment {

    private List<Rates> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RatesAdapter mAdapter;


    public RatesFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.daily_rates,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        mAdapter = new RatesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
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
        movieList.add(rate);


        rate = new Rates("Broken", "1200");
        movieList.add(rate);

        rate = new Rates("Broken", "1200");
        movieList.add(rate);

        rate = new Rates("Broken", "1200");
        movieList.add(rate);

        rate = new Rates("Broken", "1200");
        movieList.add(rate);

        rate = new Rates("Broken", "1200");
        movieList.add(rate);

        rate = new Rates("Broken", "1200");
        movieList.add(rate);

        rate = new Rates("Broken", "1200");
        movieList.add(rate);

        rate = new Rates("Broken", "1200");
        movieList.add(rate);

        rate = new Rates("Broken", "1200");
        movieList.add(rate);

        rate = new Rates("Broken", "1200");
        movieList.add(rate);

        rate = new Rates("Broken", "1200");
        movieList.add(rate);

        mAdapter.notifyDataSetChanged();
    }

}
