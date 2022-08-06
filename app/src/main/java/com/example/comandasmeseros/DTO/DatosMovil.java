package com.example.comandasmeseros.DTO;

public class DatosMovil {
   private int id_pedidoMovil;
    private int id_pedido_fina_Prod_Fin;
    private String fecha;
    private double cantidad;
    private double venta_unitaria;
    private double subtotal;
    private int numMesa;
    private double costo;
    private double utilidad;
    private double Visible;

 public DatosMovil() {
 }

 public DatosMovil(int id_pedidoMovil, int id_pedido_fina_Prod_Fin, String fecha, double cantidad,
                   double venta_unitaria, double subtotal, int numMesa, double costo,
                   double utilidad, double visible) {
  this.id_pedidoMovil = id_pedidoMovil;
  this.id_pedido_fina_Prod_Fin = id_pedido_fina_Prod_Fin;
  this.fecha = fecha;
  this.cantidad = cantidad;
  this.venta_unitaria = venta_unitaria;
  this.subtotal = subtotal;
  this.numMesa = numMesa;
  this.costo = costo;
  this.utilidad = utilidad;
  Visible = visible;
 }

 public int getId_pedidoMovil() {
  return id_pedidoMovil;
 }

 public void setId_pedidoMovil(int id_pedidoMovil) {
  this.id_pedidoMovil = id_pedidoMovil;
 }

 public int getId_pedido_fina_Prod_Fin() {
  return id_pedido_fina_Prod_Fin;
 }

 public void setId_pedido_fina_Prod_Fin(int id_pedido_fina_Prod_Fin) {
  this.id_pedido_fina_Prod_Fin = id_pedido_fina_Prod_Fin;
 }

 public String getFecha() {
  return fecha;
 }

 public void setFecha(String fecha) {
  this.fecha = fecha;
 }

 public double getCantidad() {
  return cantidad;
 }

 public void setCantidad(double cantidad) {
  this.cantidad = cantidad;
 }

 public double getVenta_unitaria() {
  return venta_unitaria;
 }

 public void setVenta_unitaria(double venta_unitaria) {
  this.venta_unitaria = venta_unitaria;
 }

 public double getSubtotal() {
  return subtotal;
 }

 public void setSubtotal(double subtotal) {
  this.subtotal = subtotal;
 }

 public int getNumMesa() {
  return numMesa;
 }

 public void setNumMesa(int numMesa) {
  this.numMesa = numMesa;
 }

 public double getCosto() {
  return costo;
 }

 public void setCosto(double costo) {
  this.costo = costo;
 }

 public double getUtilidad() {
  return utilidad;
 }

 public void setUtilidad(double utilidad) {
  this.utilidad = utilidad;
 }

 public double getVisible() {
  return Visible;
 }

 public void setVisible(double visible) {
  Visible = visible;
 }
}
