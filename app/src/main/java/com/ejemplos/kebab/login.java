package com.ejemplos.kebab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by adminportatil on 03/02/2017.
 */

public class login extends AppCompatActivity {
    Button btnLogin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btnLogin=(Button) findViewById(R.id.login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empiezaSig();
            }
        });
    }

    private void empiezaSig() {
        Intent intent=new Intent(this, Cliente.class);
        startActivity(intent);
    }

}
