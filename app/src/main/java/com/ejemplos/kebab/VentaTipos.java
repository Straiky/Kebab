package com.ejemplos.kebab;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by adminportatil on 24/01/2017.
 */

public class VentaTipos extends AppCompatActivity{
    Spinner tipoCarne, tipoTamanyo;
    Button añadir;
    TextView txtmas;
    EditText cantidad;
    Integer plus=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ventanatipos);

        tipoCarne=(Spinner) findViewById(R.id.spnTipoCarne);
        tipoTamanyo=(Spinner) findViewById(R.id.spnrTamanyo);
        txtmas=(TextView) findViewById(R.id.precio2);
        añadir=(Button) findViewById(R.id.botonAñadirVentana);
        cantidad=(EditText) findViewById(R.id.txtCantidad);

        ArrayAdapter adpTipoCarne=ArrayAdapter.createFromResource(this, R.array.TipoCarne, android.R.layout.simple_spinner_item);
        ArrayAdapter adpTipoTamanyo=ArrayAdapter.createFromResource(this, R.array.TipoTamanyo, android.R.layout.simple_spinner_item);

        adpTipoCarne.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoCarne.setAdapter(adpTipoCarne);
        adpTipoTamanyo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoTamanyo.setAdapter(adpTipoTamanyo);

        tipoTamanyo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        txtmas.setText("");
                        plus=0;
                        break;
                    case 1:
                        txtmas.setText("+1€");
                        plus=1;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tipoTamanyo.setSelection(0);
            }
        });

        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cantidad.getText().toString().equals("") || cantidad.getText().toString().equals("0")){
                    Toast.makeText(getApplicationContext(), "No puedes añadir esa cantidad", Toast.LENGTH_LONG).show();
                }else{
                    Intent intent=new Intent();
                    intent.putExtra("carne", tipoCarne.getSelectedItem().toString());
                    intent.putExtra("tamanyo", tipoTamanyo.getSelectedItem().toString());
                    intent.putExtra("precioPlus", plus);
                    intent.putExtra("cantidad", Integer.parseInt(cantidad.getText().toString()));
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
