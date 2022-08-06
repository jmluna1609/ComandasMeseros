package com.example.comandasmeseros.ControladorProductos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.comandasmeseros.MainActivity;
import com.example.comandasmeseros.R;

public class detallesproducto extends AppCompatActivity {

    TextView tvid,tvProducto,tvVenta,tvCosto,tvUtilidad;
    int position;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallesproducto);
        System.out.println("Estoy en detalles del producto");
        //Initializing Views
        tvid = findViewById(R.id.txtid);
        tvProducto = findViewById(R.id.txtNombreProducto);
        tvVenta = findViewById(R.id.txtVenta);
        tvCosto = findViewById(R.id.txtCosto);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        tvid.setText("ID Producto: " + MainActivity.productosArrayList.get(position).getId_producto_final());
        tvProducto.setText("Nombre: " + MainActivity.productosArrayList.get(position).getNombre_producto());
        tvVenta.setText("Venta Bs.: " + MainActivity.productosArrayList.get(position).getVenta_bs());
        tvCosto.setText("Costo Bs.: " + MainActivity.productosArrayList.get(position).getCosto_bs());
    }
}