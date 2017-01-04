package com.ejemplos.kebab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by adminportatil on 19/12/2016.
 */

public class Bebidas extends AppCompatActivity {
    Spinner spnBebidas;
    Button sig, salir, atras,añadir;

    ArrayList<String> bebidaList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bebidas);
        spnBebidas=(Spinner) findViewById(R.id.spnBebidas);
        atras=(Button) findViewById(R.id.btnatras);
        sig=(Button) findViewById(R.id.btnsiguiente);
        salir=(Button) findViewById(R.id.btnsalir);
        añadir=(Button) findViewById(R.id.btnAñadir);
        ArrayAdapter adaptador=ArrayAdapter.createFromResource(this, R.array.bebidas, android.R.layout.simple_spinner_item);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnBebidas.setAdapter(adaptador);

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                System.runFinalization();
                System.exit(0);
            }
        });
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empiezaSig(null);
            }
        });

        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bebidaList.add(spnBebidas.getSelectedItem().toString());

            }

        });

    }
    private void empiezaSig(View view) {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}