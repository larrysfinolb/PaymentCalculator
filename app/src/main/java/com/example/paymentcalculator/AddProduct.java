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

        pc.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!pc.getText().toString().equals("") && !pu.getText().toString().equals("")){
                    float puF = Float.parseFloat(String.valueOf(pu.getText()));
                    float pcF = Float.parseFloat(String.valueOf(pc.getText()));
                    total.setText("SubTotal a Pagar: " + String.format("%.2f", (puF * pcF)) + "$");
                }
            }
        });
    }

    public void sentProduct(View view){
        float puF = Float.parseFloat(String.valueOf(pu.getText()));
        float pcF = Float.parseFloat(String.valueOf(pc.getText()));
        Products.addProduct("-" + name.getText() + " - " + pu.getText() + " - " + pc.getText() + " - " + String.format("%.2f", (puF * pcF)));

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
