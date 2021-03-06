package com.ejemplos.kebab;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnContacto;
    Button btnEmp;
    Button btnMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnContacto = (Button) findViewById(R.id.btnContacto);
        btnEmp = (Button) findViewById(R.id.btnEmpezar);
        btnMaps = (Button) findViewById(R.id.btnMaps);
        btnContacto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:688603017"));

                if (ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });
        btnEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzaEmp();
            }
        });
        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzaMapa();

            }
        });
    }

    private void lanzaEmp() {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

    private void lanzaMapa() {
        Intent intent = new Intent(this, FirstMapActivity.class);
        startActivity(intent);
    }

}
