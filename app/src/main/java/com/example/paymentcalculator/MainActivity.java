package com.example.paymentcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private EditText editTextDollars;
    private EditText editTextRateDollar;
    private Spinner spinner;
    private TextView textViewTotal;
    private TextView textViewOweDollars;
    private TextView textViewWillPayBs;


    private ArrayList<String> products = Products.getProducts();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextDollars = findViewById(R.id.editTextDollars);
        editTextRateDollar = findViewById(R.id.editTextRateDollar);
        spinner = findViewById(R.id.spinner);
        textViewTotal = findViewById(R.id.textViewTotal);
        textViewOweDollars = findViewById(R.id.textViewOweDollars);
        textViewWillPayBs = findViewById(R.id.textViewWillPayBs);

        Collections.copy(products, Products.getProducts());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, products);
        spinner.setAdapter(adapter);

        editTextDollars.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) calculator();
            }
        });
        editTextRateDollar.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) calculator();
            }
        });

        calculator();
    }

    private void calculator() {
        if (products.size() > 0) {
            float total = 0;
            for (String product : products) {
                String[] description = product.split("-");
                float subtotal = Float.parseFloat(description[description.length - 1]);
                total += subtotal;
            }
            textViewTotal.setText("Total a pagar en $: " + String.format("%.2f", total));


            if (!editTextDollars.getText().toString().equals("")) {
                float yourDollars = Float.parseFloat(editTextDollars.getText().toString());
                float oweDollars = total - yourDollars;
                oweDollars = oweDollars >= 0 ? oweDollars : 0;
                textViewOweDollars.setText("Restas de pagar en $: " + String.format("%.2f", oweDollars));
                if (!editTextRateDollar.getText().toString().equals("")) {
                    float rateDollar = Float.parseFloat(String.valueOf(editTextRateDollar.getText()));
                    float willPayBs = oweDollars * rateDollar;
                    willPayBs = willPayBs >= 0 ? willPayBs : 0;
                    textViewWillPayBs.setText("Pagaras en Bs: " + String.format("%.2f", willPayBs));
                }
            }
        }
    }

    public void addProduct(View view) {
        Intent intent = new Intent(this, AddProduct.class);
        startActivity(intent);
    }

    public void deleteProduct(View view) {
        int position = spinner.getSelectedItemPosition();
        Products.removeProduct(position);
        calculator();
    }
}