/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.IOException;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author julio
 */
public class CRUD {
    
    
    public static ArrayList<Gasto> consultar_gastos() throws SQLException, ClassNotFoundException {
        ArrayList<Gasto> gastos = new ArrayList<>();
        try {
            BD bd = new BD();
            System.out.println("SELECT * FROM gastos");
            PreparedStatement query = bd.getConnection().prepareStatement("SELECT * FROM gastos");
            ResultSet result = query.executeQuery();
            while (result.next()) {
                int idGasto = result.getInt("id_gasto");
                String nombreGasto = result.getString("gasto");
                Double semanal = result.getDouble("monto_semanal");
                Double mensual = result.getDouble("monto_mensual");
                Gasto gasto = new Gasto(idGasto, nombreGasto, mensual, semanal);
                gastos.add(gasto);
            }
            Gasto.borrar_instancia();
            Gasto.crear_instancia(gastos);
            bd.close();
            return Gasto.recuperar_instancia();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
    
     public static ArrayList<Venta> consultar_ventas_semana_categorias(String fecha1, String fecha2) throws SQLException, ClassNotFoundException {
        ArrayList<Venta> ventas = new ArrayList<>();
        try {
            BD bd = new BD();
            System.out.println("SELECT idVenta, producto, SUM(cantidad) as cantidad, SUM(total) as total, fechaVenta, "
                    + "vendedor, idProducto, nombreProducto, descripcion, precioVenta, existencia, proveedor, categoria, "
                    + "idVendedor, nombreVendedor, usuario, contraseña, idCategoria, nombreCategoria, descripcionC "
                    + "FROM VVPC WHERE fechaVenta BETWEEN '" + fecha1 + "' AND '" + fecha2 + "' GROUP BY nombreCategoria "
                    + "ORDER BY nombreCategoria ASC");
            PreparedStatement query = bd.getConnection().prepareStatement("SELECT idVenta, producto, SUM(cantidad) as cantidad, SUM(total) as total, fechaVenta, "
                    + "vendedor, idProducto, nombreProducto, descripcion, precioVenta, existencia, proveedor, categoria, "
                    + "idVendedor, nombreVendedor, usuario, contraseña, idCategoria, nombreCategoria, descripcionC "
                    + "FROM VVPC WHERE fechaVenta BETWEEN '" + fecha1 + "' AND '" + fecha2 + "' GROUP BY nombreCategoria "
                    + "ORDER BY nombreCategoria ASC");
            ResultSet result = query.executeQuery();
            while (result.next()) {
                int idVendedor = result.getInt("idVendedor");
                String nombreVendedor = result.getString("nombreVendedor");
                Vendedor vendedor = new Vendedor(idVendedor, nombreVendedor, null, null);
                int id_categoria = result.getInt("idCategoria");
                String nombreCategoria = result.getString("nombreCategoria");
                String descripcionC = result.getString("descripcionC");
                int porcentaje = 0;
                Categoria cat = new Categoria(id_categoria, nombreCategoria, descripcionC, porcentaje);
                int idProducto = result.getInt("idProducto");
                String nombreProducto = result.getString("nombreProducto");
                String descripcion = result.getString("descripcion");
                double precioVenta = result.getDouble("precioVenta");
                int existencia = result.getInt("existencia");
                Producto produc = new Producto(idProducto, nombreProducto, descripcion, precioVenta, existencia, null, cat);
                int idVenta = result.getInt("idVenta");
                double total = result.getDouble("total");
                int cantidad = result.getInt("cantidad");
                Date fechaVenta = result.getTimestamp("fechaVenta");
                Venta venta = new Venta(idVenta, produc, cantidad, total, fechaVenta, vendedor);
                String col[] = {"Producto", "Cantidad", "Precio unitario", "Total", "Fecha y hora", "Vendido por:"};
                ventas.add(venta);
            }
            Venta.borrar_instancia();
            Venta.crear_instancia(ventas);
            bd.close();
            return Venta.recuperar_instancia();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
     
     public static ArrayList<Venta> consultar_ventas_dia_categorias(String fecha) throws SQLException, ClassNotFoundException {
        ArrayList<Venta> ventas = new ArrayList<>();
        try {
            BD bd = new BD();
            System.out.println("SELECT idVenta, producto, SUM(cantidad) as cantidad, SUM(total) as total, fechaVenta, "
                    + "vendedor, idProducto, nombreProducto, descripcion, precioVenta, existencia, proveedor, categoria, "
                    + "idVendedor, nombreVendedor, usuario, contraseña, idCategoria, nombreCategoria, descripcionC "
                    + "FROM VVPC WHERE fechaVenta like '" + fecha + "%' GROUP BY nombreCategoria ORDER BY total DESC");
            PreparedStatement query = bd.getConnection().prepareStatement("SELECT idVenta, producto, "
                    + "SUM(cantidad) as cantidad, SUM(total) as total, fechaVenta, "
                    + "vendedor, idProducto, nombreProducto, descripcion, precioVenta, existencia, proveedor, categoria, "
                    + "idVendedor, nombreVendedor, usuario, contraseña, idCategoria, nombreCategoria, descripcionC "
                    + "FROM VVPC WHERE fechaVenta like '" + fecha + "%' GROUP BY nombreCategoria ORDER BY total DESC");
            ResultSet result = query.executeQuery();
            while (result.next()) {
                int idVendedor = result.getInt("idVendedor");
                String nombreVendedor = result.getString("nombreVendedor");
                Vendedor vendedor = new Vendedor(idVendedor, nombreVendedor, null, null);
                int id_categoria = result.getInt("idCategoria");
                String nombreCategoria = result.getString("nombreCategoria");
                String descripcionC = result.getString("descripcionC");
                int porcentaje = 0;
                Categoria cat = new Categoria(id_categoria, nombreCategoria, descripcionC, porcentaje);
                int idProducto = result.getInt("idProducto");
                String nombreProducto = result.getString("nombreProducto");
                String descripcion = result.getString("descripcion");
                double precioVenta = result.getDouble("precioVenta");
                int existencia = result.getInt("existencia");
                Producto produc = new Producto(idProducto, nombreProducto, descripcion, precioVenta, existencia, null, cat);
                int idVenta = result.getInt("idVenta");
                double total = result.getDouble("total");
                int cantidad = result.getInt("cantidad");
                Date fechaVenta = result.getTimestamp("fechaVenta");
                Venta venta = new Venta(idVenta, produc, cantidad, total, fechaVenta, vendedor);
                String col[] = {"Producto", "Cantidad", "Precio unitario", "Total", "Fecha y hora", "Vendido por:"};
                ventas.add(venta);
            }
            Venta.borrar_instancia();
            Venta.crear_instancia(ventas);
            bd.close();
            return Venta.recuperar_instancia();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public static ArrayList<Venta> consultar_ventas_dia(String fecha) throws SQLException, ClassNotFoundException {
        ArrayList<Venta> ventas = new ArrayList<>();
        try {
            BD bd = new BD();
            System.out.println("SELECT * FROM VVPC WHERE fechaVenta like '" + fecha + "%' ORDER BY fechaVenta DESC");
            PreparedStatement query = bd.getConnection().prepareStatement("SELECT * FROM VVPC WHERE fechaVenta like '" + fecha + "%' ORDER BY fechaVenta DESC");
            ResultSet result = query.executeQuery();
            while (result.next()) {
                int idVendedor = result.getInt("idVendedor");
                String nombreVendedor = result.getString("nombreVendedor");
                Vendedor vendedor = new Vendedor(idVendedor, nombreVendedor, null, null);
                int id_categoria = result.getInt("idCategoria");
                String nombreCategoria = result.getString("nombreCategoria");
                String descripcionC = result.getString("descripcionC");
                int porcentaje = 0;
                Categoria cat = new Categoria(id_categoria, nombreCategoria, descripcionC, porcentaje);
                int idProducto = result.getInt("idProducto");
                String nombreProducto = result.getString("nombreProducto");
                String descripcion = result.getString("descripcion");
                double precioVenta = result.getDouble("precioVenta");
                int existencia = result.getInt("existencia");
                Producto produc = new Producto(idProducto, nombreProducto, descripcion, precioVenta, existencia, null, cat);
                int idVenta = result.getInt("idVenta");
                double total = result.getDouble("total");
                int cantidad = result.getInt("cantidad");
                Date fechaVenta = result.getTimestamp("fechaVenta");
                Venta venta = new Venta(idVenta, produc, cantidad, total, fechaVenta, vendedor);
                String col[] = {"Producto", "Cantidad", "Precio unitario", "Total", "Fecha y hora", "Vendido por:"};
                ventas.add(venta);
            }
            Venta.borrar_instancia();
            Venta.crear_instancia(ventas);
            bd.close();
            return Venta.recuperar_instancia();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public static int insertar_venta(Venta venta)
            throws SQLException, ClassNotFoundException {
        BD bd = new BD();
        System.out.println("INSERT INTO ventas "
                + "(producto, cantidad, total, fechaVenta, vendedor)"
                + " VALUES (" + venta.getProducto().getIdProducto() + "," + venta.getCantidad() + ", "
                + venta.getTotal() + ", '" + venta.getFechaFormat() + "',"
                + venta.getVendedor().getId_vendedor() + ");");
        PreparedStatement statement = bd.getConnection().prepareStatement("INSERT INTO ventas "
                + "(producto, cantidad, total, fechaVenta, vendedor)"
                + " VALUES (" + venta.getProducto().getIdProducto() + "," + venta.getCantidad() + ", "
                + venta.getTotal() + ", '" + venta.getFechaFormat() + "',"
                + venta.getVendedor().getId_vendedor() + ");",
                Statement.RETURN_GENERATED_KEYS);

        int affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
            return 0;
        }

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int n = generatedKeys.getInt(1);
                bd.close();
                return n;
            } else {
                bd.close();
                return 0;
            }
        }
    }

    public static boolean modificar_producto(Producto producto) throws SQLException, ClassNotFoundException {
        try {
            BD bd = new BD();
            String query = "UPDATE producto SET nombreProducto = ? , descripcion = ?, precioVenta = ?, existencia = ? "
                    + ", proveedor = ?, categoria = ? WHERE idProducto = ?";
            PreparedStatement sttm = bd.getConnection().prepareStatement(query);
            sttm.setString(1, producto.getNombreProducto());
            sttm.setString(2, producto.getDescripcion());
            sttm.setDouble(3, producto.getPrecioVenta());
            sttm.setInt(4, producto.getExistencia());
            sttm.setInt(5, producto.getProveedor().getIdProveedor());
            sttm.setInt(6, producto.getCategoria().getIdCategoria());
            sttm.setInt(7, producto.getIdProducto());
            sttm.executeUpdate();
            bd.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static ArrayList<Producto> consultar_productos_categoria(int exi, String order, int categoria) throws SQLException, ClassNotFoundException {
        ArrayList<Producto> productos = new ArrayList<>();
        try {
            BD bd = new BD();
            System.out.println("SELECT * FROM PPC WHERE existencia >=" + exi + " AND categoria=" + categoria + " ORDER BY " + order +"");
            PreparedStatement query = bd.getConnection().prepareStatement("SELECT * FROM PPC WHERE existencia >=" + exi + " AND categoria=" + categoria + " ORDER BY " + order +"");
            ResultSet result = query.executeQuery();
            while (result.next()) {
                int idProveedor = result.getInt("idProveedor");
                String nombreProveedor = result.getString("nombreProveedor");
                String direccion = result.getString("direccion");
                String rfc = result.getString("rfc");
                Proveedor pro = new Proveedor(idProveedor, nombreProveedor, direccion, rfc);
                int id_categoria = result.getInt("idCategoria");
                String nombreCategoria = result.getString("nombreCategoria");
                String descripcionC = result.getString("descripcionC");
                int porcentaje = 0;
                Categoria cat = new Categoria(id_categoria, nombreCategoria, descripcionC, porcentaje);
                int idProducto = result.getInt("idProducto");
                String nombreProducto = result.getString("nombreProducto");
                String descripcion = result.getString("descripcion");
                double precioVenta = result.getDouble("precioVenta");
                int existencia = result.getInt("existencia");
                Producto produc = new Producto(idProducto, nombreProducto, descripcion, precioVenta, existencia, pro, cat);
                productos.add(produc);
            }
            bd.close();
            return productos;
        } catch (SQLException ex) {                    
            System.out.println("SELECT * FROM PPC WHERE existencia >=" + exi + " AND categoria=" + categoria + " ORDER BY " + order +"");
            throw new SQLException(ex);
        }
    }
    
    public static ArrayList<Producto> consultar_productos(int exi, String order) throws SQLException, ClassNotFoundException {
        ArrayList<Producto> productos = new ArrayList<>();
        try {
            BD bd = new BD();
            System.out.println("SELECT * FROM PPC WHERE existencia >=" + exi + " ORDER BY " + order +"");
            PreparedStatement query = bd.getConnection().prepareStatement("SELECT * FROM PPC WHERE existencia >=" + exi + " ORDER BY " + order +"");
            ResultSet result = query.executeQuery();
            while (result.next()) {
                int idProveedor = result.getInt("idProveedor");
                String nombreProveedor = result.getString("nombreProveedor");
                String direccion = result.getString("direccion");
                String rfc = result.getString("rfc");
                Proveedor pro = new Proveedor(idProveedor, nombreProveedor, direccion, rfc);
                int id_categoria = result.getInt("idCategoria");
                String nombreCategoria = result.getString("nombreCategoria");
                String descripcionC = result.getString("descripcionC");
                int porcentaje = 0;
                Categoria cat = new Categoria(id_categoria, nombreCategoria, descripcionC, porcentaje);
                int idProducto = result.getInt("idProducto");
                String nombreProducto = result.getString("nombreProducto");
                String descripcion = result.getString("descripcion");
                double precioVenta = result.getDouble("precioVenta");
                int existencia = result.getInt("existencia");
                Producto produc = new Producto(idProducto, nombreProducto, descripcion, precioVenta, existencia, pro, cat);
                productos.add(produc);
            }
            Producto.borrar_instancia();
            Producto.crear_instancia(productos);
            bd.close();
            return Producto.recuperar_instancia();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public static boolean existe_producto(String producto) throws SQLException, ClassNotFoundException {
        try {
            BD bd = new BD();
            PreparedStatement query = bd.getConnection().prepareStatement("SELECT * FROM producto WHERE nombreProducto = '" + producto + "'");
            ResultSet result = query.executeQuery();
            if (result.next()) {
                bd.close();
                return true;
            } else {
                bd.close();
                return false;
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public static int insertar_producto(Producto producto)
            throws SQLException, ClassNotFoundException {
        BD bd = new BD();
        System.out.println("INSERT INTO producto "
                + "(nombreProducto, descripcion, precioVenta, existencia, proveedor, categoria)"
                + " VALUES ('" + producto.getNombreProducto() + "','" + producto.getDescripcion() + "', "
                + producto.getPrecioVenta() + ", " + producto.getExistencia() + ","
                + producto.getProveedor().getIdProveedor() + "," + producto.getCategoria().getIdCategoria() + ");");
        PreparedStatement statement = bd.getConnection().prepareStatement("INSERT INTO producto "
                + "(nombreProducto, descripcion, precioVenta, existencia, proveedor, categoria)"
                + " VALUES ('" + producto.getNombreProducto() + "','" + producto.getDescripcion() + "', "
                + producto.getPrecioVenta() + ", " + producto.getExistencia() + ","
                + producto.getProveedor().getIdProveedor() + "," + producto.getCategoria().getIdCategoria() + ");",
                Statement.RETURN_GENERATED_KEYS);

        int affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
            return 0;
        }

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int n = generatedKeys.getInt(1);
                bd.close();
                return n;
            } else {
                bd.close();
                return 0;
            }
        }

    }

    public static boolean modificar_proveedor(Proveedor proveedor) throws SQLException, ClassNotFoundException {
        try {
            BD bd = new BD();
            String query = "UPDATE proveedor SET nombreProveedor = ? , direccion = ?, rfc = ? WHERE idProveedor = ?";
            PreparedStatement sttm = bd.getConnection().prepareStatement(query);
            sttm.setString(1, proveedor.getNombreProveedor());
            sttm.setString(2, proveedor.getDireccion());
            sttm.setString(3, proveedor.getRFC());
            sttm.setInt(4, proveedor.getIdProveedor());
            sttm.executeUpdate();
            bd.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static ArrayList<Proveedor> consultar_proveedores() throws SQLException, ClassNotFoundException {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        try {
            BD bd = new BD();
            System.out.println("SELECT * FROM proveedor ");
            PreparedStatement query = bd.getConnection().prepareStatement("SELECT * FROM proveedor ");
            ResultSet result = query.executeQuery();
            while (result.next()) {
                int idProveedor = result.getInt("idProveedor");
                String nombreProveedor = result.getString("nombreProveedor");
                String direccion = result.getString("direccion");
                String rfc = result.getString("rfc");
                Proveedor pro = new Proveedor(idProveedor, nombreProveedor, direccion, rfc);
                proveedores.add(pro);
            }
            Proveedor.borrar_instancia();
            Proveedor.crear_instancia(proveedores);
            bd.close();
            return Proveedor.recuperar_instancia();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public static boolean existe_proveedor(String proveedor) throws SQLException, ClassNotFoundException {
        try {
            BD bd = new BD();
            PreparedStatement query = bd.getConnection().prepareStatement("SELECT * FROM proveedor WHERE nombreProveedor = '" + proveedor + "'");
            ResultSet result = query.executeQuery();
            if (result.next()) {
                bd.close();
                return true;
            } else {
                bd.close();
                return false;
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public static int insertar_proveedor(String nom, String direc, String rfc)
            throws SQLException, ClassNotFoundException {
        BD bd = new BD();
        System.out.println("INSERT INTO proveedor "
                + "(nombreProveedor,direccion, rfc)"
                + " VALUES ('" + nom + "','" + direc + "', '" + rfc + "');");
        PreparedStatement statement = bd.getConnection().prepareStatement("INSERT INTO proveedor "
                + "(nombreProveedor,direccion, rfc)"
                + " VALUES ('" + nom + "','" + direc + "', '" + rfc + "');",
                Statement.RETURN_GENERATED_KEYS);

        int affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
            return 0;
        }

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int n = generatedKeys.getInt(1);
                bd.close();
                return n;
            } else {
                bd.close();
                return 0;
            }
        }

    }

    public static boolean modificar_categoria(Categoria categoria) throws SQLException, ClassNotFoundException {
        try {
            BD bd = new BD();
            String query = "UPDATE categoria SET nombreCategoria = ? , descripcionC = ? WHERE idCategoria = ?";
            PreparedStatement sttm = bd.getConnection().prepareStatement(query);
            sttm.setString(1, categoria.getNombreCategoria());
            sttm.setString(2, categoria.getDescripcion());
            sttm.setInt(3, categoria.getIdCategoria());
            sttm.executeUpdate();
            bd.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static ArrayList<Categoria> consultar_categorias() throws SQLException, ClassNotFoundException {
        ArrayList<Categoria> cate = new ArrayList<>();
        try {
            BD bd = new BD();
            System.out.println("SELECT * FROM categoria ORDER BY nombreCategoria ASC");
            PreparedStatement query = bd.getConnection().prepareStatement("SELECT * FROM categoria ORDER BY nombreCategoria ASC");
            ResultSet result = query.executeQuery();
            while (result.next()) {
                int id_categoria = result.getInt("idCategoria");
                String nombreCategoria = result.getString("nombreCategoria");
                String descripcion = result.getString("descripcionC");
                int porcentaje = result.getInt("porcentaje");
                Categoria cat = new Categoria(id_categoria, nombreCategoria, descripcion, porcentaje);
                cate.add(cat);
            }
            Categoria.borrar_instancia();
            Categoria.crear_instancia(cate);
            bd.close();
            return Categoria.recuperar_instancia();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public static boolean existe_categoria(String categoria) throws SQLException, ClassNotFoundException {
        try {
            BD bd = new BD();
            PreparedStatement query = bd.getConnection().prepareStatement("SELECT * FROM categoria WHERE nombreCategoria = '" + categoria + "'");
            ResultSet result = query.executeQuery();
            if (result.next()) {
                bd.close();
                return true;
            } else {
                bd.close();
                return false;
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public static int insertar_categoria(String nom, String desc)
            throws SQLException, ClassNotFoundException {
        BD bd = new BD();
        System.out.println("INSERT INTO categoria "
                + "(nombreCategoria,descripcionC)"
                + " VALUES ('" + nom + "','" + desc + "'");
        PreparedStatement statement = bd.getConnection().prepareStatement("INSERT INTO categoria "
                + "(nombreCategoria,descripcionC)"
                + " VALUES ('" + nom + "','" + desc + "');",
                Statement.RETURN_GENERATED_KEYS);

        int affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
            return 0;
        }

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int n = generatedKeys.getInt(1);
                bd.close();
                return n;
            } else {
                bd.close();
                return 0;
            }
        }
    }

    public static int insertar_producto(String nom, String desc, double precio,
            int existencia, int proveedor, int categoria) throws SQLException, ClassNotFoundException {
        BD bd = new BD();
        System.out.println("INSERT INTO producto "
                + "(nombreProducto,descripcion,precioVenta,existencia,proveedor,categoria)"
                + " VALUES ('" + nom + "','" + desc + "'," + precio + "," + existencia + "," + proveedor + "," + categoria + "");
        PreparedStatement statement = bd.getConnection().prepareStatement("INSERT INTO producto "
                + "(nombreProducto,descripcion,precioVenta,existencia,proveedor,categoria)"
                + " VALUES ('" + nom + "','" + desc + "'," + precio + "," + existencia + "," + proveedor + "," + categoria + "",
                Statement.RETURN_GENERATED_KEYS);

        int affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
            return 0;
        }

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int n = generatedKeys.getInt(1);
                bd.close();
                return n;
            } else {
                bd.close();
                return 0;
            }
        }
    }

    public static int insertar_vendedor(String nom, String pass, String user) throws SQLException, ClassNotFoundException {
        BD bd = new BD();
        System.out.println("INSERT INTO vendedor "
                + "(nombreVendedor,usuario,contraseña)"
                + " VALUES ('" + nom + "','" + user + "', AES_ENCRYPT('" + pass + "','" + Strings.contraseña_encriptado + "'))");
        PreparedStatement statement = bd.getConnection().prepareStatement("INSERT INTO vendedor "
                + "(nombreVendedor,usuario,contraseña)"
                + " VALUES ('" + nom + "','" + user + "', AES_ENCRYPT('" + pass + "','" + Strings.contraseña_encriptado + "'))",
                Statement.RETURN_GENERATED_KEYS);

        int affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
            return 0;
        }

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int n = generatedKeys.getInt(1);
                bd.close();
                return n;
            } else {
                bd.close();
                return 0;
            }
        }
    }

    public static Object login(String vendedor, String contraseña) throws SQLException, ClassNotFoundException {
        try {
            BD bd = new BD();
            System.out.println("SELECT *, AES_DECRYPT(contraseña, '" + Strings.contraseña_encriptado + "') as passw FROM vendedor WHERE usuario = '" + vendedor + "'");
            PreparedStatement query = bd.getConnection().prepareStatement("SELECT *, AES_DECRYPT(contraseña, '" + Strings.contraseña_encriptado + "') as passw FROM vendedor WHERE usuario = '" + vendedor + "'");
            ResultSet result = query.executeQuery();
            if (result.next()) {
                byte[] varbinary = (byte[]) result.getObject("passw");
                String contraseña_decrypt = new String(varbinary);
                if (contraseña_decrypt.equals(contraseña)) {
                    int id_vendedor = result.getInt("idVendedor");
                    String nombreVendedor = result.getString("nombreVendedor");
                    String usuario = result.getString("usuario");
                    Vendedor.crear_instancia(id_vendedor, nombreVendedor, usuario, contraseña);
                    bd.close();
                    return Vendedor.recuperar_instancia();
                } else {
                    return Strings.error_password;
                }
            } else {
                return Strings.error_usuario;
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public static boolean existe_usuario(String usuario) throws SQLException, ClassNotFoundException {
        try {
            BD bd = new BD();
            PreparedStatement query = bd.getConnection().prepareStatement("SELECT * FROM vendedor WHERE usuario = '" + usuario + "'");
            ResultSet result = query.executeQuery();
            if (result.next()) {
                bd.close();
                return true;
            } else {
                bd.close();
                return false;
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public static int num_vendedores() throws SQLException, ClassNotFoundException {
        int num_vendedores = 0;
        try {
            BD bd = new BD();
            PreparedStatement query = bd.getConnection().prepareStatement("SELECT * FROM vendedor");
            ResultSet result = query.executeQuery();
            while (result.next()) {
                num_vendedores++;
            }
            bd.close();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return num_vendedores;
    }

    public static boolean conexion_internet() throws InterruptedException, IOException {
        String dirWeb = "www.lineadecodigo.com";
        int puerto = 80;
        try {
            Socket s = new Socket(dirWeb, puerto);
            if (s.isConnected()) {
                System.out.println("Conexión establecida con la dirección: " + dirWeb + " a travéz del puerto: " + puerto);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println("No se pudo establecer conexión con: " + dirWeb + " a travez del puerto: " + puerto);
            return false;
        }
    }
}
