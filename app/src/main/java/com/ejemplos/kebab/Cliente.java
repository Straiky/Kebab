package com.ejemplos.kebab;

import android.app.Application;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by adminportatil on 14/12/2016.
 */

public class Cliente extends AppCompatActivity{
    EditText nom, ape, direc, tel, cp;
    Button sig, salir, atras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cliente);
        nom=(EditText) findViewById(R.id.txtNombre);
        ape=(EditText) findViewById(R.id.txtApellido);
        direc=(EditText) findViewById(R.id.txtDireccion);
        tel=(EditText) findViewById(R.id.txtTelefono);
        cp=(EditText) findViewById(R.id.txtCP);
        atras=(Button) findViewById(R.id.btnatras);
        sig=(Button) findViewById(R.id.btnsiguiente);
        salir=(Button) findViewById(R.id.btnsalir);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
                if(!nom.getText().equals("") || !ape.getText().equals("") || !direc.getText().equals("") || !tel.getText().equals("")|| !cp.getText().equals("")){
                    Intent intent=new Intent();
                    intent.putExtra("nombre", nom.getText());
                    intent.putExtra("apellidos", ape.getText());
                    intent.putExtra("direccion", direc.getText());
                    intent.putExtra("telefono", tel.getText());
                    intent.putExtra("codigoPostal", cp.getText());
                }else{
                    if (nom.getText().equals("")){
                        nom.setText("fhbgjebhw");
                    }
                }
            }
        });
    }
}
