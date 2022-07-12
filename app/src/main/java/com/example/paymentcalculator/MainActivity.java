package com.example.paymentcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextDollars;
    private EditText editTextRateDollar;
    private Spinner spinner;
    private TextView textViewTotal;
    private TextView textViewOweDollars;
    private TextView textViewWillPayBs;


    private String[] products = {"|Pollo|P/U 2.6|Peso 4|35", "|Vaca|P/U 2.6|Peso 4|40"};

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

        //products = (String[]) Products.getProducts().toArray();
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
        if (products.length > 0) {
            double total = 0;
            for (String product : products) {
                String[] description = product.split("|");
                System.out.println("-------------------------------");
                System.out.println(description[description.length - 1]);
                System.out.println("-------------------------------");
                /*double subtotal = Double.parseDouble(description[description.length - 1]);
                total += subtotal;*/
            }
            /*textViewTotal.setText(Double.toString(total));

            double yourDollars = Double.parseDouble(String.valueOf(editTextDollars.getText()));
            double oweDollars = total - yourDollars;
            textViewOweDollars.setText(Double.toString(oweDollars));

            double rateDollar = Double.parseDouble(String.valueOf(editTextRateDollar.getText()));
            double willPayBs = oweDollars * rateDollar;
            textViewWillPayBs.setText(Double.toString(willPayBs));*/
        }
    }

    public void addProduct(View view) {
        Intent intent = new Intent(this, AddProduct.class);
        startActivity(intent);
    }

    public void deleateProduct(View view) {
        int position = spinner.getSelectedItemPosition();
    }
}