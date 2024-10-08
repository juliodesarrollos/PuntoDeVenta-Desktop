/**
 *
 * @author Julio Vazquez
 */
package Clases;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Strings {

    //Acceso base de datos
    public static String contraseña_host = "la_rosa_123";
    public static String usuario_host = "u888976791_la_rosa";
    public static String host_bd = "jdbc:mysql://jandr.tech/u888976791_la_rosa";

    //Variables de base de datos
    public static String contraseña_encriptado = "P@ssw0rd123";

    //Codigos de error 
    public static String error_password = "PASS";
    public static String error_usuario = "USER";
    public static String error_desconocido = "ERROR";
    
    //Variables JOptionPane
    public static String titulo_sin_internet = "Sin conexión";
    public static String mensaje_error = "Ha ocurrido un error.";
    public static String login_correcto = "Inicio de sesión correcto.";
    public static String bienvenido_colaborador = "Bienvenido: ";
    public static String mensaje_error_password = "Contraseña incorrecta.";
    public static String login_incorrecto = "Inicio de sesión incorrecto.";
    public static String mensaje_error_usuario = "Usuario no registrado.";
    public static String ingrese_contraseña = "Ingrese su contraseña.";
    public static String ingrese_usuario = "Ingrese su usuario.";
    public static String ingrese_categoria = "Ingrese el nombre de categoria.";
    public static String ingrese_producto = "Ingrese el nombre del producto.";
    public static String ingrese_rfc = "Ingrese el RFC del proveedor.";
    public static String ingrese_proveedor = "Ingrese el nombre de un proveedor.";
    public static String ingrese_direccion = "Ingrese la dirección del proveedor.";
    public static String ingrese_descripcion = "Ingrese una desripción para esta categoria.";
    public static String ingrese_descripcionP = "Ingrese una desripción para este producto.";
    public static String ingrese_precioV = "Ingrese un precio de venta para este producto.";
    public static String ingrese_existencia = "Ingrese el numero de piezas disponible para venta de este producto.";
    public static String ventana_confirmacion = "Ventana de confirmación";
    public static String confirmacion_logout = "Esta seguro de querer cerrar sesión?";
    public static String ventana_informacion = "Ventana de información";
    public static String cliente_registrado = "Se ha registrado exitosamente al nuevo cliente.";
    public static String colaborador_registrado = "Se ha registrado exitosamente al nuevo colaborador.";
    public static String datos_guardados = "Sus datos han sido guardados correctamente, las modificaciones se notaran en su proximo inicio de sesión.";
    public static String actualizar_documentos = "¿Desea actualizar los documentos del proyecto?";
    public static String correos_invalido = "Favor de ingresar un formato valido de correo.";
    public static String correos_distiontos = "El correo y la confirmación de correo deben de ser identicos";
    
    //Variables globales
    public static String bienvenido = "¡Bienvenido!";
    
    //Strings login_form
    public static String login_form_title = "Internet la Rosa - Inicio de sesión";
    public static String inicio_sesion = "Inicio de sesión";
    public static String ing_usuario = "Ingresa tu usuario: ";
    public static String ing_contraseña = "Ingresa tu contraseña: ";
    public static String iniciar_sesion = "Iniciar sesion";
    
    //Strings form_padre
    public static String form_padre_titulo = "Internet la Rosa - Página principal";
    
    //Strings form_venta_directa
    public static String venta_directa = "Venta directa";
    public static String venta_directa_titulo = "Internet la Rosa - Venta de productos";
    
    //Strings form_agregar_vendedor
    public static String agregar_vendedor_titulo = "Internet la Rosa - Agregar vendedor";
    public static String agregar_vendedor = "Agregar vendedor";
    public static String nombre_vendedor = "Nombre del vendedor:";
    public static String usuario_vendedor = "Nombre de usuario:";
    public static String contraseña_confirmacion = "Confirma tu contraseña:";
    public static String contraseña = "Contraseña:";
    public static String reguistrar_vendedor = "Registrar vendedor:";
    
    //Strings form_agregar_producto 
    public static String agregar_producto_titulo = "Internet la rosa - Agregar producto";
    public static String agregar_producto = "Agregar producto";
    
    //JoptionPane 
    public static String confirmar_cerrar = "¿Estas seguro de querer cerrar el programa?";
    public static String confirmar_insertar_vendedor = "¿Has verificado bien los datos a ingresar?";
    public static String confirmar_cerrar_titulo = "Cerrar el programa";
    public static String confirmar_cerrar_ventana = "¿Estas seguro de querer cerrar esta ventana?";
    public static String confirmar_cerrar_ventana_titulo = "Cerrar venta";
    public static String campos_vacios = "Por favor llene todos los campos solicitados";
    public static String titulo_error_vendedor = "Error al registrar al vendedor";
    public static String titulo_error_ventana = "No puede abriri dos veces la misma ventana";
    public static String venta_abierta = "Ya tiene una ventana abierta de: ";
    public static String ventana_informacion_titulo = "Información sobre su petición";
    public static String vendedor_agregado = "Vendedor agregado correctamente";
    public static String producto_agregado = "Producto agregado correctamente";
    public static String categoria_agregada = "Categoria agregada correctamente";
    public static String venta_agregada = "Venta registrada correctamente";
    public static String proveedor_agregado = "Proveedor agregado correctamente";
    public static String contraseñas_distintas = "La contraseña y la confirmación de contraseña deben de ser identicas";
    public static String usuario_existente = "Un vendedor ya se encuentra registrado con ese usuario, por favor intente con otro nombre de usuario";
    public static String sin_internet = "Su dispositivo se encuentra desconectado, por favor verifique su conexión a internet";
    public static String mensaje_error_desconocido = "Surgio un error desconocidodurante su petición";
    public static String categoria_existente = "Esta categoria ya se encuentra registrada en el sistema";
    public static String proveedor_existente = "Este proveedor ya se encuentra registrado en el sistema";
    public static String categoria_modificada = "La categoria ha sido modificada exitosamente";
    public static String proveedor_modificado = "El proveedor ha sido modificada exitosamente";
    public static String producto_modificado = "El producto ha sido modificada exitosamente";

    //Textos ayuda
    public static String ayuda_categoria = "<html>NOTA: Se considera una categoria a todo aquel rubro en el que uno de sus productos  podría pertenecer, por ejemplo: <br> - Papelería <br> - Dulces <br> - Regalos<html";
    public static String ayuda_proveedor = "<html>NOTA: Se considera una proveedor a todo aquel establecimiento en el cual se compran los productos que nosotros vendemos <html";
    
      
    public static String getStringDate6DiasAntes () {
        Calendar c = Calendar.getInstance();
        java.util.Date date = c.getTime();
        c.setTime(date);
        c.add(Calendar.DAY_OF_YEAR, -6);
        date = c.getTime();
        DateFormat hourdateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = hourdateFormat.format(date);
        return fecha;
    }
    
     public static String getStringDate7DiasAntes () {
        Calendar c = Calendar.getInstance();
        java.util.Date date = c.getTime();
        c.setTime(date);
        c.add(Calendar.DAY_OF_YEAR, -6);
        date = c.getTime();
        DateFormat hourdateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = hourdateFormat.format(date);
        return fecha;
    }
     
    public static String getStringDate () {
        Calendar c = Calendar.getInstance();
        java.util.Date date = c.getTime();
        DateFormat hourdateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = hourdateFormat.format(date);
        return fecha;
    }
}
