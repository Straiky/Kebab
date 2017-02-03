package com.ejemplos.kebab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by adminportatil on 07/01/2017.
 */

public class Pedido extends AppCompatActivity {
    RadioButton rdbTarjeta, rdbContado;
    EditText txtTarjeta, txtFecha, txtDig;
    TextView lblTar, lblFecha, lblDig, lblTotal, lblCliente;
    TextView tipoK, tam, tipoC, can, tipoB, canB;
    ArrayList pedido, bebidas, cliente;
    Button salir, aceptar;
    Double factura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.pedido);

            Intent intent = getIntent();
            pedido = intent.getCharSequenceArrayListExtra("pedido");
            try {
                bebidas = intent.getCharSequenceArrayListExtra("bebidas");
            } catch (Exception e) {
                bebidas.add("No has pedido ningúna bebida");
            }

            txtDig = (EditText) findViewById(R.id.txtDigitos);
            txtFecha = (EditText) findViewById(R.id.txtFecha);
            txtTarjeta = (EditText) findViewById(R.id.txtNumTarjeta);
            rdbContado = (RadioButton) findViewById(R.id.rdbContado);
            rdbTarjeta = (RadioButton) findViewById(R.id.rdbTarjeta);
            tipoK = (TextView) findViewById(R.id.Tipo_de_Kebab);
            tipoC = (TextView) findViewById(R.id.Tipo_de_Carne);
            tam = (TextView) findViewById(R.id.Tamaño);
            can = (TextView) findViewById(R.id.Cantidad);
            tipoB = (TextView) findViewById(R.id.Tipo_de_Bebida);
            canB = (TextView) findViewById(R.id.Cantidad_bebida);
            lblTar = (TextView) findViewById(R.id.NºTarjeta);
            lblFecha = (TextView) findViewById(R.id.lblFecha);
            lblDig = (TextView) findViewById(R.id.lblDigitos);
            salir = (Button) findViewById(R.id.btnsalir);
            aceptar = (Button) findViewById(R.id.btnAceptar);
            lblTotal = (TextView) findViewById(R.id.lblTotal);
            lblCliente= (TextView) findViewById(R.id.datosCliente);

            cliente=intent.getCharSequenceArrayListExtra("cliente");
            for(int i=0; i<cliente.size(); i++){
                lblCliente.setText((String)lblCliente.getText()+ cliente.get(i)+"\r\n");
            }

            txtTarjeta.requestFocus();
            if (pedido == null) {
                tipoK.setText("No has pedido ningun Kebab");
            } else {
                for (int i = 0; i < pedido.size(); i++) {
                    tipoK.setText((String) tipoK.getText() + pedido.get(i) + "\r\n");
                    i++;
                    tam.setText((String) tam.getText() + pedido.get(i) + "\r\n");
                    i++;
                    tipoC.setText((String) tipoC.getText() + pedido.get(i) + "\r\n");
                    i++;
                    can.setText((String) can.getText() + pedido.get(i) + "\r\n");
                }
            }

            if (bebidas == null) {
                tipoB.setText("No has pedido ninguna bebida");
            } else {
                for (int j = 0; j < bebidas.size(); j++) {
                    tipoB.setText((String) tipoB.getText() + bebidas.get(j) + "\r\n");
                    j++;
                    canB.setText((String) canB.getText() + bebidas.get(j) + "\r\n");
                }
            }

            factura = intent.getExtras().getDouble("factura");
            lblTotal.setText("" + factura);

            rdbContado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        txtTarjeta.setVisibility(View.GONE);
                        txtFecha.setVisibility(View.GONE);
                        txtDig.setVisibility(View.GONE);
                        lblDig.setVisibility(View.GONE);
                        lblFecha.setVisibility(View.GONE);
                        lblTar.setVisibility(View.GONE);
                    } else {
                        txtDig.setVisibility(View.VISIBLE);
                        txtTarjeta.setVisibility(View.VISIBLE);
                        txtFecha.setVisibility(View.VISIBLE);
                        lblFecha.setVisibility(View.VISIBLE);
                        lblTar.setVisibility(View.VISIBLE);
                        lblDig.setVisibility(View.VISIBLE);
                    }
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
            aceptar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ((rdbTarjeta.isChecked() & !txtTarjeta.getText().toString().equals("") & !txtFecha.getText().toString().equals("") & !txtDig.getText().toString().equals("")) | rdbContado.isChecked()) {
                        empiezaSig();
                    } else {
                        if (txtTarjeta.getText().toString().equals("")) {
                            txtTarjeta.setError("Debes introducir el campo");
                        }
                        if (txtFecha.getText().toString().equals("")) {
                            txtFecha.setError("Debes introducir el campo");
                        }
                        if (txtDig.getText().toString().equals("")) {
                            txtDig.setError("Debes introducir el campo");
                        }
                    }
                }
            });
        }catch(Exception e){
            Log.e("Error!",e.toString()+e.getLocalizedMessage());
        }
    }
    private void empiezaSig() {
        Intent intent1 = new Intent(this, Agradecimientos.class);
        intent1.putExtra("factura", factura);
        startActivity(intent1);
    }
}
