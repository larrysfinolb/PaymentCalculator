package com.example.paymentcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OutputsActivity extends AppCompatActivity {

    // Declaramos las variables necesarias
    TextView textView_1, textView_2, textView_3;
    float billInDollars, dollarValue, currentDollars, currentBs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outputs);

        // Inicializamos las variables necesarias apartir del id del componente correspondiente
        textView_1 = findViewById(R.id.sobranDolares);
        textView_2 = findViewById(R.id.sinBolivares);
        textView_3 = findViewById(R.id.conBolivares);

        // Inicializamos las variables apartir de los valores traidos desde la activity anterior
        Bundle data = this.getIntent().getExtras();
        billInDollars = data.getFloat("billInDollars");
        dollarValue = data.getFloat("dollarValue");
        currentDollars = data.getFloat("currentDollars");
        currentBs = data.getFloat("currentBs");

        /* Calculamos y establecemos en los TextView los valores de los Outputs apartir de los
        resultados obtenidos con los calculos de los datos de los Inputs */
        float billInBs = (billInDollars - currentDollars) * dollarValue;

        boolean sobranDolares = billInDollars >= currentDollars ? false
                : true;

        textView_1.setText(sobranDolares == false
                ? textView_1.getText() + "No"
                : textView_1.getText() + "Si");

        textView_2.setText(sobranDolares == false
                ? textView_2.getText() + "Dolares insuficientes"
                : textView_2.getText() + "$" + Float.toString(billInDollars));

        textView_3.setText(sobranDolares == false
                ? billInBs > currentBs
                ? textView_3.getText() + "Monto insuficiente"
                : textView_3.getText() + "$" + Float.toString(currentDollars) + " y " + "Bs. " + billInBs
                : textView_3.getText() + "No son necesarios los bolivares");
    }
}