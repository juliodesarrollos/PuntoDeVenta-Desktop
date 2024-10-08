/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author jandr
 */
public class Venta {
    private int idVenta;
    private Producto producto;
    private int cantidad;
    private double total;
    private java.util.Date fechaVenta;
    private Vendedor vendedor;
    private static ArrayList<Venta> ventas;

    public Venta(int idVenta, Producto producto, int cantidad, double total, java.util.Date fechaVenta, Vendedor vendedor) {
        this.idVenta = idVenta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
        this.fechaVenta = fechaVenta;
        this.vendedor = vendedor;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public java.util.Date getFechaVenta() {
        return fechaVenta;
    }
    
    public String getFechaFormat() {
        
        DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String fecha = hourdateFormat.format(fechaVenta);
        return fecha;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    public static void crear_instancia(ArrayList<Venta> v) {
        ventas = v;
    }

    public static void borrar_instancia() {
        ventas = null;
    }
    
    public static ArrayList<Venta> recuperar_instancia() {
        return ventas;
    }
}