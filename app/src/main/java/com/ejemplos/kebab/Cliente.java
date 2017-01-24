package com.ejemplos.kebab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

/**
 * Created by adminportatil on 14/12/2016.
 */

public class Cliente extends AppCompatActivity {
    EditText nom, ape, direc, tel, cp;
    Button sig, salir;
    String nombre, apell, direcc, tele, cop;
    ArrayList<String> cliente = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cliente);

        nom=(EditText) findViewById(R.id.txtNombre);
        ape=(EditText) findViewById(R.id.txtApellido);
        direc=(EditText) findViewById(R.id.txtDireccion);
        tel=(EditText) findViewById(R.id.txtTelefono);
        cp=(EditText) findViewById(R.id.txtCP);
        sig=(Button) findViewById(R.id.btnsiguiente);
        salir=(Button) findViewById(R.id.btnsalir);

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                System.runFinalization();
                System.exit(0);
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
                    listo();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void listo() {
        if (tele.length()<9){
            tel.setError("Telefono no valido");
        }else if(cp.length()<5) {
            cp.setError("Codigo incorrecto");
        }else {

                cliente.add(nombre);
                cliente.add(apell);
                cliente.add(direcc);
                cliente.add(tele);
                cliente.add(cop);
                empiezaSig();
        }
    }

    private void empiezaSig() {
        Intent intent=new Intent(this, Menu.class);
        intent.putExtra("cliente", cliente);
        startActivity(intent);
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
