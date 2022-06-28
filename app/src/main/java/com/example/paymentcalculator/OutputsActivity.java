package com.example.paymentcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OutputsActivity extends AppCompatActivity {

    TextView textView_1, textView_2, textView_3;
    float billInDollars, dollarValue, currentDollars, currentBs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outputs);

        textView_1 = findViewById(R.id.sobranDolares);
        textView_2 = findViewById(R.id.sinBolivares);
        textView_3 = findViewById(R.id.conBolivares);

        Bundle data = this.getIntent().getExtras();
        billInDollars = data.getFloat("billInDollars");
        dollarValue = data.getFloat("dollarValue");
        currentDollars = data.getFloat("currentDollars");
        currentBs = data.getFloat("currentBs");
        // billInBs = data.getFloat("billInBs");
    }
}