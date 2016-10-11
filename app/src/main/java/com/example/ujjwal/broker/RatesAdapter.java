package com.example.ujjwal.broker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ujjwal on 11/10/16.
 */
public class RatesAdapter extends RecyclerView.Adapter<RatesAdapter.MyViewHolder>{

    private List<Rates> rateList;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rate_list_row, parent, false);

        return new MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Rates movie = rateList.get(position);
        holder.name.setText(movie.getProductName());
        holder.rate.setText(movie.getProductRate());
    }

    @Override
    public int getItemCount() {
        return rateList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,rate;

        public MyViewHolder(View view) {
            super(view);
            rate = (TextView) view.findViewById(R.id.rate);
            name= (TextView) view.findViewById(R.id.name);
        }
    }

    public RatesAdapter(List<Rates> rateList) {
        this.rateList = rateList;
    }

}
