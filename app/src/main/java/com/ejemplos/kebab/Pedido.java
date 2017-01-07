package com.ejemplos.kebab;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by adminportatil on 07/01/2017.
 */

public class Pedido extends AppCompatActivity{
    RadioButton rdbTarjeta, rdbContado;
    EditText txtTarjeta, txtFecha, txtDig;
    TextView lblPedido, lblPedidobebidas, lblTar, lblFecha, lblDig, lblTotal;
    ArrayList pedido, bebidas;
    Button salir, atras, aceptar;
    Double factura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido);

        Intent intent= getIntent();
        pedido=intent.getCharSequenceArrayListExtra("pedido");
        bebidas=intent.getCharSequenceArrayListExtra("bebidas");

        txtDig=(EditText) findViewById(R.id.txtDigitos);
        txtFecha=(EditText) findViewById(R.id.txtFecha);
        txtTarjeta=(EditText) findViewById(R.id.txtNumTarjeta);
        rdbContado=(RadioButton) findViewById(R.id.rdbContado);
        rdbTarjeta=(RadioButton) findViewById(R.id.rdbTarjeta);
        lblPedido=(TextView) findViewById(R.id.lblPedidoRealizado);
        lblPedidobebidas=(TextView) findViewById(R.id.lblBebidasRealizadas);
        lblTar=(TextView) findViewById(R.id.NºTarjeta);
        lblFecha=(TextView) findViewById(R.id.lblFecha);
        lblDig=(TextView) findViewById(R.id.lblDigitos);
        salir=(Button) findViewById(R.id.btnsalir);
        atras=(Button) findViewById(R.id.btnatras);
        aceptar=(Button) findViewById(R.id.btnAceptar);
        lblTotal=(TextView) findViewById(R.id.lblTotal);

        txtTarjeta.requestFocus();
        lblPedido.setText("");
        for(int i=0; i<pedido.size(); i++){
            lblPedido.setText((String)lblPedido.getText()+pedido.get(i)+"\r\n");
        }
        lblPedidobebidas.setText("");
        for(int j=0; j<pedido.size(); j++){
            lblPedidobebidas.setText((String)lblPedidobebidas.getText()+bebidas.get(j)+"\r\n");
        }
        factura=intent.getExtras().getDouble("factura");
        lblTotal.setText(""+factura);

        rdbContado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    txtTarjeta.setVisibility(View.GONE);
                    txtFecha.setVisibility(View.GONE);
                    txtDig.setVisibility(View.GONE);
                    lblDig.setVisibility(View.GONE);
                    lblFecha.setVisibility(View.GONE);
                    lblTar.setVisibility(View.GONE);
                }else{
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
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((rdbTarjeta.isChecked() & !txtTarjeta.getText().toString().equals("") & !txtFecha.getText().toString().equals("") & !txtDig.getText().toString().equals("")) | rdbContado.isChecked()){
                    empiezaSig(null);
                }
            }
        });
    }
    private void empiezaSig(View view) {
        Intent intent1 = new Intent(this, Agradecimientos.class);
        intent1.putExtra("factura", factura);
        startActivity(intent1);
    }
}
