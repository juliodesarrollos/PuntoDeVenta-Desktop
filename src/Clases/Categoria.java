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
public class Categoria {

    private int idCategoria;
    private String nombreCategoria;
    private String descripcion;
    private double porcentaje;
    private static ArrayList<Categoria> categorias;

    public Categoria(int idCategoria, String nombreCategoria, String descripcion, int porcentaje) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static void crear_instancia(ArrayList<Categoria> cate) {
        if (categorias == null) {
            categorias = cate;
        }
    }

    public static void borrar_instancia() {
        categorias = null;
    }

    public static ArrayList<Categoria> recuperar_instancia() {
        return categorias;
    }
}
