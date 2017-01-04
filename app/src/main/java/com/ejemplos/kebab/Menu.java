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
import android.widget.Toast;

import java.util.ArrayList;

public class Menu  extends AppCompatActivity {
    Button sig, salir, atras,añadir;
    EditText cantidad;
    Spinner tipoKebab, tipoCarne, tipoTamanyo;
    String pedido="";
    ArrayList<String> kebabList = new ArrayList<String>();
    ArrayList<String> cliente=new ArrayList<String>();
    Double factura=0.0;
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

            String tipo=tipoKebab.getSelectedItem().toString();
            String tam=(tipoTamanyo.getSelectedItem().toString());
            String carne=(tipoCarne.getSelectedItem().toString());
            Integer cant=Integer.parseInt(cantidad.getText().toString());
            @Override
            public void onClick(View v) {
                pedido="";
                pedido+=tipo+" ";
                pedido+=tam+" ";
                pedido+=carne+" ";
                pedido+=cant;
                kebabList.add(pedido);
                añadeFactura(tipoKebab.getSelectedItemPosition(), tipoTamanyo.getSelectedItemPosition(), cant);
                tipoKebab.setSelection(0);
                tipoTamanyo.setSelection(0);
                tipoCarne.setSelection(0);
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

    private void añadeFactura(Integer a, Integer c, Integer d) {
        Double este=0.0;
        switch (a){
            case 0:
                este+=4;
                break;
            case 1:
                este+=5;
                break;
            case 2:
                este+=5.5;
                break;
            case 3:
                este+=6;
                break;
            case 4:
                este+=4;
        }
        if (c==1)
            este+=1;

        factura+=este*d;
        Toast.makeText(getApplicationContext(), "Este pedido vale "+este*d+". Llevas pedido "+factura, Toast.LENGTH_LONG);
    }

    private void empiezaSig(View view) {
        Intent intent=new Intent(this, Bebidas.class);
        intent.putExtra("pedido", kebabList);
        intent.putExtra("cliente", cliente);
        intent.putExtra("factura", factura);
        startActivity(intent);
    }
}
