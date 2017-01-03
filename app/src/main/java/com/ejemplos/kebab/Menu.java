package com.ejemplos.kebab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by adminportatil on 16/12/2016.
 */

public class Menu extends AppCompatActivity{
    Spinner tk,tam, tCar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listakebabs);

        tk=(Spinner) findViewById(R.id.spnTipoKebab);
        tam=(Spinner) findViewById(R.id.spnTamaño);
        tCar=(Spinner) findViewById(R.id.spnCarne);

        ArrayAdapter adaptador=ArrayAdapter.createFromResource(this, R.array.tipoKebab, android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tk.setAdapter(adaptador);

        ArrayAdapter adapter2=ArrayAdapter.createFromResource(this, R.array.tamaño, android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tam.setAdapter(adapter2);

        ArrayAdapter adapter3=ArrayAdapter.createFromResource(this, R.array.tipoCarne, android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tCar.setAdapter(adapter3);
    }
}
