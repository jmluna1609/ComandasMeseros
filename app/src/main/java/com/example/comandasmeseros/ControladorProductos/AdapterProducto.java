package com.example.comandasmeseros.ControladorProductos;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.comandasmeseros.DTO.DatosProductos;
import com.example.comandasmeseros.R;
import java.util.List;
public class AdapterProducto extends ArrayAdapter<DatosProductos> {
    Context context;
    List<DatosProductos> arrayproductos;
    public AdapterProducto(@NonNull Context context, List<DatosProductos>arrayproductos) {
        super(context, R.layout.list_productos,arrayproductos);
        this.context = context;
        this.arrayproductos = arrayproductos;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,@NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_productos,null,true);
        TextView viewIdProd = view.findViewById(R.id.txt_id); //list productos.xml
        TextView viewNombreProd = view.findViewById(R.id.txt_name); // list productos.xml
        viewIdProd.setText(String.valueOf(arrayproductos.get(position).getId_producto_final()));
        viewNombreProd.setText(""+arrayproductos.get(position).getNombre_producto());
        System.out.println("Estoy en Adapter Producto: ");
        return view;
    }
}