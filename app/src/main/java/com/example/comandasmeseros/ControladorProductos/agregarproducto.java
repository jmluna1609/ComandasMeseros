package com.example.comandasmeseros.ControladorProductos;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import com.example.comandasmeseros.MainActivity;
import com.example.comandasmeseros.R;

public class agregarproducto extends AppCompatActivity {

    EditText txtNombreProducto, txtVenta, txtCosto;
    Button btn_insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregarproducto);

        txtNombreProducto = findViewById(R.id.nombreProducto);
        txtVenta = findViewById(R.id.venta);
        txtCosto = findViewById(R.id.costo);

        btn_insert = findViewById(R.id.btnInsert);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
    }

    private void insertData() {
        final String nombreProducto = txtNombreProducto.getText().toString().trim();
        final String venta = txtVenta.getText().toString().trim();
        final String costo = txtCosto.getText().toString().trim();
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("cargando...");

        if(nombreProducto.isEmpty()){
            Toast.makeText(this, "ingrese nombre del producto", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(venta.isEmpty()){
            Toast.makeText(this, "Ingrese venta en Bs", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(costo.isEmpty()) {
            Toast.makeText(this, "Ingrese costo en Bs", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.100.35/crud_dbItaly_movilMeseros/insertar.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if(response.equalsIgnoreCase("datos insertados")){
                                Toast.makeText(agregarproducto.this, "datos insertados", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                            }
                            else{
                                Toast.makeText(agregarproducto.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(agregarproducto.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String,String>();
                    params.put("id_producto_final_Prod_Fin",nombreProducto); //valor int
                    params.put("venta_unitaria",venta); // valor double
                    params.put("costo",costo);  // valor double
   return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(agregarproducto.this);
            requestQueue.add(request);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}