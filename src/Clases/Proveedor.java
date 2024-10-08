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
public class Proveedor {

    private int idProveedor;
    private String nombreProveedor;
    private String direccion;
    private String RFC;
    private static ArrayList<Proveedor> proveedores;

    public Proveedor(int idProveedor, String nombreProveedor, String direccion, String RFC) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.direccion = direccion;
        this.RFC = RFC;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public static void crear_instancia(ArrayList<Proveedor> provee) {
        if (proveedores == null) {
            proveedores = provee;
        }
    }

    public static void borrar_instancia() {
        proveedores = null;
    }

    public static ArrayList<Proveedor> recuperar_instancia() {
        return proveedores;
    }
}
