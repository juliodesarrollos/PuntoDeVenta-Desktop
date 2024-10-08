/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author julio
 */
public class Vendedor {
    private int id_vendedor;
    private String nombre_vendeor;
    private String usuario;
    private String contraseña;
    private static Vendedor vendedor;

    public Vendedor (int id_vendedor, String nombre_vendedor, String usuario, String contraseña) {
        this.id_vendedor = id_vendedor;
        this.nombre_vendeor = nombre_vendedor;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public int getId_vendedor (){
        return this.id_vendedor;
    }
    
    public String getContraseña (){
        return this.contraseña;
    }
    
    public String getUsuario (){
        return this.usuario;
    }
    
    public String getNombre_vendedor (){
        return this.nombre_vendeor;
    }
    
    public static void crear_instancia(int id_vendedor, String nombre_vendedor, String usuario, String contraseña) {
        if (vendedor == null) {
            vendedor = new Vendedor (id_vendedor, nombre_vendedor, usuario, contraseña);
        } else {
            System.out.println("No se puede crear el objeto " + nombre_vendedor + " porque ya existe un objeto de la clase Vendedor");
        }
    }

    public void borar_instancia() {
        Vendedor.vendedor = null;
    }

    public static Vendedor recuperar_instancia() {
        return Vendedor.vendedor;
    }
}
