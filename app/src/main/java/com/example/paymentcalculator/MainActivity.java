package com.example.paymentcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String paymentIn;
    float dollarValue;
    float currentDollars, currentBs;
    float billInDollars, billInBs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Funcion para calcular el pago
    public void paymentCalculator(View view) {
        if (paymentIn == "Dolares") {
            if (currentDollars >= billInDollars) {
                currentDollars -= billInDollars;
                // Cuenta pagada unicamente en dolares
                billInDollars = 0;
                billInBs = 0;
            } else {
                billInDollars -= currentDollars;
                currentDollars = 0; // Se acabaron los dolares, hay que completar con Bs
                billInBs = billInDollars * dollarValue;
                if (currentBs >= billInBs) {
                    currentBs -= billInBs;
                    // Cuenta pagada en dolares y completada en Bs
                    billInBs = 0;
                    billInDollars = 0;
                } else {
                    System.out.println("No tienes dinero suficiente");
                }
            }
        }
        else {
            if (currentBs >= billInBs) {
                currentBs -= billInBs;
                // Cuenta pagada unicamente en Bs
                billInBs = 0;
                billInDollars = 0;
            } else {
                billInBs -= currentBs;
                currentBs = 0; // Se acabaron los bolivares, hay que completar con Dolares
                billInDollars = billInBs / dollarValue;
                if (currentDollars >= billInDollars) {
                    currentDollars -= billInDollars;
                    // Cuenta pagada en Bs y completada en Dolares
                    billInDollars = 0;
                    billInBs = 0;
                } else {
                    System.out.println("No tienes dinero suficiente");
                }
            }
        }
    }
}