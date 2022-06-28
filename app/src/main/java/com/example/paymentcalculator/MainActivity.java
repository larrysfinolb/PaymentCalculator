package com.example.paymentcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView_billInDollars;
    TextView textView_dollarValue;
    TextView textView_currentDollars, textView_currentBs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_billInDollars = findViewById(R.id.montoTotal);
        textView_dollarValue = findViewById(R.id.tasaDolar);
        textView_currentDollars = findViewById(R.id.dolaresActuales);
        textView_currentBs = findViewById(R.id.bolivaresActuales);
    }

    // Para enviar los datos a la siguiente Activity
    public void sendData(View view) {

        // float billInBs = 0;
        float billInDollars = Float.parseFloat(textView_billInDollars.getText().toString());
        float dollarValue = Float.parseFloat(textView_dollarValue.getText().toString());
        float currentDollars = Float.parseFloat(textView_currentDollars.getText().toString());
        float currentBs = Float.parseFloat(textView_currentBs.getText().toString());

        /*if (currentDollars >= billInDollars) {
            currentDollars -= billInDollars; // Pago solo en dolares.
        } else {
            billInDollars -= currentDollars; // Pago una parte de dolares.
            currentDollars = 0; // Me quedo sin dolares.
            billInBs = billInDollars * dollarValue; // Calculo el resto en bs.
            if (currentBs >= billInBs) {
                currentBs -= billInBs; // Completo el pago con bs.
            } else {
                billInBs -= currentBs; // Pago otra parte en dolares.
                currentBs = 0; // Me quedo sin bs
            }
        }*/

        Intent intent = new Intent(this, OutputsActivity.class);
        intent.putExtra("billInDollars", billInDollars);
        intent.putExtra("dollarValue", dollarValue);
        intent.putExtra("currentDollars", currentDollars);
        intent.putExtra("currentBs", currentBs);
        // intent.putExtra("billInBs", billInBs);
        startActivity(intent);
    }
}