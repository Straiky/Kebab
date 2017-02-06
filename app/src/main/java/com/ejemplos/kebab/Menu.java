package com.ejemplos.kebab;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;

public class Menu  extends AppCompatActivity {
    Button sig, salir,añadir;
    TextView txtPrecio;
    ImageView img;
    Spinner tipoKebab;
    ArrayList<String> kebabList = new ArrayList<>();
    ArrayList<String> cliente=new ArrayList<>();
    Double factura=0.0;
    Cursor kebabs;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        añadir=(Button) findViewById(R.id.btnAñadir);
        tipoKebab=(Spinner) findViewById(R.id.spnTipoKebab);
        sig=(Button) findViewById(R.id.btnsiguiente);
        salir=(Button) findViewById(R.id.btnsalir);
        txtPrecio=(TextView) findViewById(R.id.precio);
        img=(ImageView) findViewById(R.id.imagenPedido);

        cliente=getIntent().getStringArrayListExtra("cliente");

        ArrayAdapter adpTipoKebab=ArrayAdapter.createFromResource(this, R.array.TipoKebab, android.R.layout.simple_spinner_item);

        adpTipoKebab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoKebab.setAdapter(adpTipoKebab);


        tipoKebab.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        txtPrecio.setText("4€");
                        img.setImageResource(R.mipmap.doner);
                        break;
                    case 1:
                        img.setImageResource(R.mipmap.durum);
                        txtPrecio.setText("5€");
                        break;
                    case 2:
                        img.setImageResource(R.mipmap.lahmacum);
                        txtPrecio.setText("5€");
                        break;
                    case 3:
                        img.setImageResource(R.mipmap.shawarma);
                        txtPrecio.setText("6€");
                        break;
                    case 4:
                        img.setImageResource(R.mipmap.gyros);
                        txtPrecio.setText("4€");
                        break;
                    default:
                        txtPrecio.setText("Error");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tipoKebab.setSelection(0);
            }
        });



        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreVentana();
            }

        });
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            empiezaSig();
            }
        });

    }

    private void listo(String tipo, String tam, String carne, Integer cant) {
        if(compruebaNoRepe(tipo, tam, carne)) {
            kebabList.add(tipo);
            kebabList.add(tam);
            kebabList.add(carne);
            kebabList.add(cant.toString());
        }else{
            añadeCantidad(tipo, tam, carne, cant);
        }
        añadeFactura (tipoKebab.getSelectedItemPosition(), tam, cant);
        tipoKebab.setSelection(0);

    }

    private void añadeCantidad(String tipo, String tam, String carne, Integer cant) {
        for(int i = 0; i<kebabList.size();i++){
            if(kebabList.get(i).toString().equals(tipo)){
                if (kebabList.get(i+1).toString().equals(tam)){
                    if(kebabList.get(i+2).toString().equals(carne)){
                        kebabList.set(i+3, ""+(Integer.parseInt(kebabList.get(i+3))+cant));
                    }
                }
            }
        }
    }

    private boolean compruebaNoRepe(String tipo, String tam, String carne) {
        Boolean noElegido=true;
        for(int i = 0; i<kebabList.size();i++){
            if(kebabList.get(i).toString().equals(tipo)){
                if (kebabList.get(i+1).toString().equals(tam)){
                    if(kebabList.get(i+2).toString().equals(carne)){
                        noElegido=false;
                    }
                }
            }
        }
        return noElegido;
    }

    private void añadeFactura(Integer a, String c, Integer d) {
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
        if (c.toLowerCase().equals("completo"))
            este+=1;

        factura+=este*d;
        Toast.makeText(getApplicationContext(), "Este pedido vale "+este*d+". Llevas pedido "+factura, Toast.LENGTH_LONG).show();
    }

    private void abreVentana(){
        Intent intent=new Intent(this, VentaTipos.class);
        startActivityForResult(intent, 123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String tipo=tipoKebab.getSelectedItem().toString();

        if (requestCode==123 && resultCode==RESULT_OK){
            listo(tipo, data.getExtras().getString("carne"), data.getExtras().getString("tamanyo"), data.getExtras().getInt("cantidad"));
        }
    }

    private void empiezaSig() {
        Intent intent=new Intent(this, Bebidas.class);
        intent.putExtra("pedido", kebabList);
        intent.putExtra("cliente", cliente);
        intent.putExtra("factura", factura);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menupedido, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.Logout:
                Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            case R.id.settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
