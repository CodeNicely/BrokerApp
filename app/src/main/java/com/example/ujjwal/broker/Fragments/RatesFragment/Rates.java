package com.example.ujjwal.broker.Fragments.RatesFragment;

/**
 * Created by ujjwal on 11/10/16.
 */
public class Rates {


    public String productRate,productName;

    public Rates(){

    }
    public Rates(String productName,String productRate){
        this.productName=productName;
        this.productRate=productRate;

    }

    public String getProductRate() {
        return productRate;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductRate(String rate) {
        this.productRate = rate;
    }
    public void setProductName(String name){
        this.productRate=name;
    }


}
