package com.example.comandasmeseros.ControladorProductos;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class editarproducto extends AppCompatActivity {

    EditText edId, edNombreProd, edVentaBs, edCostoBs;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editarproducto);

        edId = findViewById(R.id.id);
        edNombreProd = findViewById(R.id.nomProd);
        edVentaBs = findViewById(R.id.ventabs);
        edCostoBs = findViewById(R.id.costoBs);
        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");


        edId.setText(MainActivity.productosArrayList.get(position).getId_producto_final());
        edNombreProd.setText(MainActivity.productosArrayList.get(position).getNombre_producto());
        edVentaBs.setText(""+MainActivity.productosArrayList.get(position).getVenta_bs());
        edCostoBs.setText(""+MainActivity.productosArrayList.get(position).getCosto_bs());

    }

    public void actualizar(View view) {
        final String id = edId.getText().toString();
        final String nomprod = edNombreProd.getText().toString();
        final String ventabs = edVentaBs.getText().toString();
        final String costobs = edCostoBs.getText().toString();
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Actualizando....");
        progressDialog.show();

       StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.100.35/crud_dbItaly_movilMeseros/actualizar.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(editarproducto.this, response, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        finish();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(editarproducto.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                params.put("id",id);
                params.put("nombre_producto",nomprod);
                params.put("venta_bs",ventabs);
                params.put("costo_bs",costobs);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(editarproducto.this);
        requestQueue.add(request);
    }
}