package com.ejemplos.kebab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by adminportatil on 19/12/2016.
 */

public class Bebidas extends AppCompatActivity {
    Spinner spnBebidas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bebidas);
        spnBebidas=(Spinner) findViewById(R.id.spnBebidas);

        ArrayAdapter adaptador=ArrayAdapter.createFromResource(this, R.array.bebidas, android.R.layout.simple_spinner_item);
    }
}