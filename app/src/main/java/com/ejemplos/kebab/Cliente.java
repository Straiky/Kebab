package com.ejemplos.kebab;

import android.app.Application;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by adminportatil on 14/12/2016.
 */

public class Cliente extends AppCompatActivity{
    EditText nom, ape, direc, tel, cp;
    Button sig, salir, atras;
    String nombre, apell, direcc, tele, cop;
    ArrayList<String> cliente = new ArrayList<String>();
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
                nombre=nom.getText().toString();
                apell=ape.getText().toString();
                tele=tel.getText().toString();
                cop=cp.getText().toString();
                direcc=direc.getText().toString();
                if (nombre.equals("")||apell.equals("")||tele.equals("")||cop.equals("")||direcc.equals("")){
                    ponError();
                }else{
                    cliente.add(nombre);
                    cliente.add(apell);
                    cliente.add();
                    cliente.add(tele);
                }
            }
        });
    }

    private void empiezaSig(View view, RecogerDatos rd) {
        Intent intent=new Intent(this, Menu.class);
        startActivity(intent);
//        intent.putExtra("rd", rd);
    }

    private void ponError() {
        if(nom.getText().toString().equals(""))
            nom.setError("Este campo no puede estar vacio");
        if (ape.getText().toString().equals(""))
            ape.setError("Este campo no puede estar vacio");
        if (tel.getText().toString().equals(""))
            tel.setError("Este campo no puede estar vacio");
        if (direc.getText().toString().equals(""))
            direc.setError("Este campo no puede estar vacio");
        if (cp.getText().toString().equals(""))
            cp.setError("Este campo no puede estar vacio");
    }
}
