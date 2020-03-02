package com.example.conversortemperatura;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText entradaEditText;
    private Button f2c;
    private TextView saidaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entradaEditText = findViewById(R.id.edittext_entrada);
        saidaTextView = findViewById(R.id.textview_saida);
        f2c = findViewById(R.id.button_converter);

        f2c.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == f2c) {
            paraCelcius();
        }
    }

    private double getEntrada() throws NumberFormatException {
        double entrada;
        try {
            entrada = Double.valueOf(entradaEditText.getText().toString());
        } catch (NumberFormatException ex) {
            throw ex;
        }

        return entrada;
    }


    private void paraCelcius() {
        double valor;

        try {
            valor = getEntrada();
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Entrada inválida!", Toast.LENGTH_SHORT).show();
            valor = 0;
        }


        saidaTextView.setText(String.format("%.2f °C", ((valor - 32) / 1.8) ));
    }
}