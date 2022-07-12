package com.example.paymentcalculator;

import java.util.ArrayList;

public class Products {
    static private ArrayList<String> products = new ArrayList<String>();

    static public void addProduct(String p){
        products.add(p);
    }
    static public ArrayList<String> getProducts(){
        return products;
    }
}
