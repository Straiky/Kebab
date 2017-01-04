package com.ejemplos.kebab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class Menu  extends AppCompatActivity {
    Button sig, salir, atras,añadir;
    EditText cantidad;
    Spinner tipoKebab, tipoCarne, tipoTamanyo;

    ArrayList<String> kebabList = new ArrayList<String>();

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        añadir=(Button) findViewById(R.id.btnAñadir);
        cantidad=(EditText) findViewById(R.id.txtCantidad);
        tipoKebab=(Spinner) findViewById(R.id.spnTipoKebab);
        tipoCarne=(Spinner) findViewById(R.id.spnTipoCarne);
        tipoTamanyo=(Spinner) findViewById(R.id.spnrTamanyo);
        atras=(Button) findViewById(R.id.btnatras);
        sig=(Button) findViewById(R.id.btnsiguiente);
        salir=(Button) findViewById(R.id.btnsalir);

        ArrayAdapter adpTipoKebab=ArrayAdapter.createFromResource(this, R.array.TipoKebab, android.R.layout.simple_spinner_item);
        ArrayAdapter adpTipoCarne=ArrayAdapter.createFromResource(this, R.array.TipoCarne, android.R.layout.simple_spinner_item);
        ArrayAdapter adpTipoTamanyo=ArrayAdapter.createFromResource(this, R.array.TipoTamanyo, android.R.layout.simple_spinner_item);

        adpTipoKebab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoKebab.setAdapter(adpTipoKebab);
        adpTipoCarne.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoCarne.setAdapter(adpTipoCarne);
        adpTipoTamanyo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoTamanyo.setAdapter(adpTipoTamanyo);


        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kebabList.add(tipoTamanyo.getSelectedItem().toString());
                kebabList.add(tipoCarne.getSelectedItem().toString());
                kebabList.add(tipoKebab.getSelectedItem().toString());
            }

        });




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

    }
    private void empiezaSig(View view) {
        Intent intent=new Intent(this, Bebidas.class);
        startActivity(intent);
    }
}
