package com.example.paymentcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.example.paymentcalculator.Products;

public class AddProduct extends AppCompatActivity {

    TextView name, pu, pc, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        name = findViewById(R.id.editTextTextPersonName);
        pu = findViewById(R.id.editTextNumberDecimal7);
        pc = findViewById(R.id.editTextNumberDecimal6);
        total = findViewById(R.id.textView9);

        pc.addTextChangedListener(new TextWatcher() {

            float puF = Float.parseFloat(String.valueOf(pu.getText()));
            float pcF = Float.parseFloat(String.valueOf(pc.getText()));

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                total.setText("SubTotal a Pagar: " + String.valueOf(puF * pcF) + "$");
            }
        });
    }

    void sentProduct(View view){
        float puF = Float.parseFloat(String.valueOf(pu.getText()));
        float pcF = Float.parseFloat(String.valueOf(pc.getText()));
        Products.addProduct("|" + name.getText() + "|P/U " + pu.getText() + "|Peso " + pc.getText() + "|Total " + String.valueOf(puF * pcF) + "$|");

        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }

}
