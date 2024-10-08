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
public class Gasto {
    
    private int id;
    private String nombreGasto;
    private double mensual;
    private double semanal;
    private static ArrayList<Gasto> gastos = new ArrayList<>();

    public Gasto(int id, String nombreGasto, double mensual, double semanal) {
        this.id = id;
        this.nombreGasto = nombreGasto;
        this.mensual = mensual;
        this.semanal = semanal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreGasto() {
        return nombreGasto;
    }

    public void setNombreGasto(String nombreGasto) {
        this.nombreGasto = nombreGasto;
    }

    public double getMensual() {
        return mensual;
    }

    public void setMensual(double mensual) {
        this.mensual = mensual;
    }

    public double getSemanal() {
        return semanal;
    }

    public void setSemanal(double semanal) {
        this.semanal = semanal;
    }
    
      public static void crear_instancia(ArrayList<Gasto> gasto) {
        if (gastos == null) {
            gastos = gasto;
        }
    }

    public static void borrar_instancia() {
        gastos = null;
    }

    public static ArrayList<Gasto> recuperar_instancia() {
        return gastos;
    }
}