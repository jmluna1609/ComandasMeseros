package com.example.comandasmeseros;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.comandasmeseros.ControladorProductos.AdapterProducto;
import com.example.comandasmeseros.ControladorProductos.agregarproducto;
import com.example.comandasmeseros.ControladorProductos.detallesproducto;
import com.example.comandasmeseros.ControladorProductos.editarproducto;
import com.example.comandasmeseros.DTO.DatosProductos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    //RecyclerView reciclerView;
    AdapterProducto adapterProductos;

    public static ArrayList<DatosProductos>productosArrayList=new ArrayList<>();
    String url="http://192.168.100.35/crud_dbItaly_movilMeseros/mostrar.php";
    DatosProductos datosProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.myListView);
        //listView = findViewById(R.id.listaProductos);
        adapterProductos = new AdapterProducto(this, productosArrayList);
        listView.setAdapter(adapterProductos);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());

                CharSequence[] dialogItem = {"Ver datos", "Editar Datos", "Eliminar Datos"};
                builder.setTitle(productosArrayList.get(position).getNombre_producto());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        switch (i) {

                            case 0:

                                startActivity(new Intent(getApplicationContext(), detallesproducto.class)
                                        .putExtra("position", position));

                                break;

                            case 1:
                                startActivity(new Intent(getApplicationContext(), editarproducto.class)
                                        .putExtra("position", position));
                                break;
                            case 2:

                                 deleteData(""+productosArrayList.get(position).getId_producto_final());
                                break;
                        }
                    }
                });

                builder.create().show();
            }
        });
        retrieveData();
        //listarProductos();
    }

    private void deleteData(final String id) {

        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.100.35/crud_dbItaly_movilMeseros/eliminar.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.equalsIgnoreCase("datos eliminados")){
                            Toast.makeText(MainActivity.this, "eliminado correctamente", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        }
                        else{
                            Toast.makeText(MainActivity.this, "no se pudo eliminar", Toast.LENGTH_SHORT).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"error: "+ error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();
                params.put("id_producto_final", id);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
    /***
     * para listar datos
     */
    public void retrieveData(){

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        productosArrayList.clear();
                        try{

                            JSONObject jsonObject = new JSONObject(response);
                            String exito = jsonObject.getString("exito");
                            JSONArray jsonArray = jsonObject.getJSONArray("datos");

                            if(exito.equals("1")){
                                for(int i=0;i<jsonArray.length();i++){

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    int id_producto_final = object.getInt("id_producto_final");
                                    String  categoria = object.getString("categoria");
                                    String nombre_producto = object.getString("nombre_producto");
                                    double venta_bs = object.getDouble("venta_bs");
                                    double costo_bs = object.getDouble("costo_bs");
                                    double utilidad_bs = object.getDouble("utilidad_bs");
                                    String detalle = object.getString("detalle");

                                    datosProductos = new DatosProductos(id_producto_final,categoria,nombre_producto,venta_bs,costo_bs,utilidad_bs,detalle);
                                    productosArrayList.add(datosProductos);
                                    adapterProductos.notifyDataSetChanged();
                                }
                            }
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
    public void agregarPedido(View view) {
        startActivity(new Intent(getApplicationContext(), agregarproducto.class));
    }
}