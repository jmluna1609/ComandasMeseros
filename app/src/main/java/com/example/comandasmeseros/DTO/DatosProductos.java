package com.example.comandasmeseros.DTO;

public class DatosProductos {
    private int id_producto_final;
    private String categoria;
    private String nombre_producto;
    private double venta_bs;
    private double costo_bs;
    private double utilidad_bs;
    private String detalle;

    public DatosProductos() {
    }

    public DatosProductos(String nombre_producto, double venta_bs) {
        this.nombre_producto = nombre_producto;
        this.venta_bs = venta_bs;
    }

    public DatosProductos(int id_producto_final, String categoria, String nombre_producto,
                          double venta_bs, double costo_bs, double utilidad_bs, String detalle) {
        this.id_producto_final = id_producto_final;
        this.categoria = categoria;
        this.nombre_producto = nombre_producto;
        this.venta_bs = venta_bs;
        this.costo_bs = costo_bs;
        this.utilidad_bs = utilidad_bs;
        this.detalle = detalle;
    }

    public int getId_producto_final() {
        return id_producto_final;
    }

    public void setId_producto_final(int id_producto_final) {
        this.id_producto_final = id_producto_final;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public double getVenta_bs() {
        return venta_bs;
    }

    public void setVenta_bs(double venta_bs) {
        this.venta_bs = venta_bs;
    }

    public double getCosto_bs() {
        return costo_bs;
    }

    public void setCosto_bs(double costo_bs) {
        this.costo_bs = costo_bs;
    }

    public double getUtilidad_bs() {
        return utilidad_bs;
    }

    public void setUtilidad_bs(double utilidad_bs) {
        this.utilidad_bs = utilidad_bs;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
