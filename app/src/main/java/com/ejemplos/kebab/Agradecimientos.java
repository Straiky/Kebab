package com.ejemplos.kebab;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by adminportatil on 07/01/2017.
 */

public class Agradecimientos extends AppCompatActivity{
    Button salir, menu;
    Double factura;
    ImageView android, vale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agradecimientos);

        salir=(Button) findViewById(R.id.btnsalir);
        menu=(Button) findViewById(R.id.btnmenuprincipal);
        factura=getIntent().getExtras().getDouble("factura");
        android=(ImageView) findViewById(R.id.imgRegalo1);
        vale=(ImageView) findViewById(R.id.imgRegalo2);

        if (factura<33){

        }

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                System.runFinalization();
                System.exit(0);
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(null, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
