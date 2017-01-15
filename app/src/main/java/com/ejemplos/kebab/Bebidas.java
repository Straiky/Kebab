package com.ejemplos.kebab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by adminportatil on 19/12/2016.
 */

public class Bebidas extends AppCompatActivity {
    Spinner spnBebidas;
    Button sig, salir, atras, añadir;
    Double factura = 0.0;
    EditText canti;
    TextView txtprecio;
    ArrayList<String> bebidaList = new ArrayList<String>();
    ArrayList<String> kebabList = new ArrayList<String>();
    ArrayList<String> cliente = new ArrayList<String>();
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bebidas);


        spnBebidas = (Spinner) findViewById(R.id.spnBebidas);
        atras = (Button) findViewById(R.id.btnatras);
        sig = (Button) findViewById(R.id.btnsiguiente);
        salir = (Button) findViewById(R.id.btnsalir);
        añadir = (Button) findViewById(R.id.btnAñadir);
        canti = (EditText) findViewById(R.id.cantidadBebidas);
        txtprecio=(TextView) findViewById(R.id.precio);

        kebabList = getIntent().getStringArrayListExtra("pedido");
        cliente = getIntent().getStringArrayListExtra("cliente");
        factura = getIntent().getExtras().getDouble("factura");

        ArrayAdapter adaptador = ArrayAdapter.createFromResource(this, R.array.bebidas, android.R.layout.simple_spinner_item);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnBebidas.setAdapter(adaptador);

        spnBebidas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                    case 1:
                    case 2:
                        txtprecio.setText("1€");
                        break;
                    case 3:
                    case 4:
                        txtprecio.setText("2€");
                        break;
                    case 5:
                        txtprecio.setText("0.5€");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spnBebidas.setSelection(0);
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

        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (canti.getText().toString().equals("") | canti.getText().toString().equals("0")) {
                    Toast.makeText(getApplicationContext(), "No se puede añadir una bebida con 0 cantidades", Toast.LENGTH_LONG).show();
                }else{
                    bebidaList.add(spnBebidas.getSelectedItem().toString());
                    bebidaList.add(canti.getText().toString());
                    switch (spnBebidas.getSelectedItemPosition()) {
                        case 0:
                        case 1:
                        case 2:
                            factura += (Integer.parseInt(canti.getText().toString()));
                            Toast.makeText(getApplicationContext(), "Has añadido " + canti.getText().toString() + " euro", Toast.LENGTH_LONG).show();
                            break;
                        case 3:
                        case 4:
                            factura += (2 * Integer.parseInt(canti.getText().toString()));
                            Toast.makeText(getApplicationContext(), "Has añadido " + 2 * Integer.parseInt(canti.getText().toString()) + " euros", Toast.LENGTH_LONG).show();
                            break;
                        case 5:
                            factura += (0.5 * Integer.parseInt(canti.getText().toString()));
                            Toast.makeText(getApplicationContext(), "Has añadido " + 0.5 * Integer.parseInt(canti.getText().toString()) + " euros", Toast.LENGTH_LONG).show();
                            break;
                    }
                    spnBebidas.setSelection(0);
                    canti.setText("0");
                }
            }

        });

    }

    private void empiezaSig(View view) {
        Intent intent = new Intent(this, Pedido.class);
        intent.putExtra("cliente", cliente);
        intent.putExtra("pedido", kebabList);
        intent.putExtra("bebidas", bebidaList);
        intent.putExtra("factura", factura);
        startActivity(intent);
    }


}