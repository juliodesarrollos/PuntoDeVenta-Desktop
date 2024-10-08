/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author jandr
 */
public class Producto {
    private int idProducto;
    private String nombreProducto;
    private String descripcion;
    private double precioVenta;
    private int existencia;
    private Proveedor proveedor;
    private Categoria categoria;
    private static ArrayList<Producto> productos;

    public Producto(int idProducto, String nombreProducto, String descripcion, double precioVenta, int existencia, Proveedor proveedor, Categoria categoria) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.existencia = existencia;
        this.proveedor = proveedor;
        this.categoria = categoria;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
   
    public static void crear_instancia (ArrayList<Producto> producs) {
        productos = producs;
    }
    
    public static void borrar_instancia () {
        productos = null;
    }
    
    public static ArrayList<Producto> recuperar_instancia() {
        return productos;
    }
}
