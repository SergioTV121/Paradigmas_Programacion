/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameplanet;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Sergio
 */
public class Videojuego {

    
    String upc,
            descripcion,
            desarrollador,
            plataforma,
            clasificacion,
            generos,
            precio,
            imagen;

    public Videojuego()
	{}
   
    public Videojuego(String upc, String desc, String dev,String plat,
                        String clasif,String gen,String precio){
        this.upc=upc;
        this.descripcion=desc;
        this.desarrollador=dev;
        this.plataforma=plat;
        this.clasificacion=clasif;
        this.generos=gen;
        this.precio=precio;
    }
    
    public static Videojuego getVideojuegoFromBD(String UPC, Properties prop) {
             Videojuego vid = new Videojuego(); // Nuevo libro en blanco

            try
	    {

                String driver = prop.getProperty("dbdriver");
                String host   = prop.getProperty("dbhost");
                String user   = prop.getProperty("dbuser");
                String password = prop.getProperty("dbpassword");
                String name     = prop.getProperty("dbname");
                String url = host + name  + "?user=" + user + "&password=" + password;
                System.out.println("Conexion a la BD: " + url);


                Class.forName(driver);     // Carga el driver


                Connection con = DriverManager.getConnection(url); // Crea una conexion a la BD

                PreparedStatement ps = con.prepareStatement("SELECT * FROM VIDEOJUEGOS WHERE UPC = "+UPC);
                System.out.println(ps.toString());
                ps.executeQuery();
                ResultSet rs = ps.getResultSet();

                if(rs!=null && rs.next())
                {
                    String upc   = rs.getString("upc");
                    String descripcion = rs.getString("descripcion");
                    String desarrollador  = rs.getString("desarrollador");
                    String plataforma = rs.getString("plataforma");
                    String clasificacion = rs.getString("clasificacion");
                    String generos = rs.getString("generos");
                    String precio = rs.getString("precio");
                    String imagen = rs.getString("imagen");

                    vid.setUpc(upc);
                    vid.setDescripcion(descripcion);
                    vid.setDesarrollador(desarrollador);
                    vid.setPlataforma(plataforma);
                    vid.setClasificacion(clasificacion);
                    vid.setGeneros(generos);
                    vid.setPrecio(precio);
                    vid.setImagen(imagen);
                    con.close();
                    return vid;
                }

	    }
	    catch (Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	    return null;
    }
    
    
    
    
    
     public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getGeneros() {
        return generos;
    }

    public void setGeneros(String generos) {
        this.generos = generos;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return "imagenes/"+imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean alta(Properties prop)
	{
            boolean exito = false;
            
            try
	    {

                String driver = prop.getProperty("dbdriver");
                String host   = prop.getProperty("dbhost");
                String user   = prop.getProperty("dbuser");
                String password = prop.getProperty("dbpassword");
                String name     = prop.getProperty("dbname");
                String url = host + name  + "?user=" + user + "&password=" + password;
                System.out.println("Conexion a la BD: " + url);


                Class.forName(driver);     // Carga el driver

                Connection con = DriverManager.getConnection(url); // Crea una conexion a la BD

                PreparedStatement ps = con.prepareStatement("INSERT INTO VIDEOJUEGOS VALUES (?,?,?,?,?,?,?,?)");
                ps.setString(1, this.upc); 
                ps.setString(2, this.descripcion);
                ps.setString(3, this.desarrollador); 
                ps.setString(4, this.plataforma); 
                ps.setString(5, this.clasificacion); 
                ps.setString(6, this.generos); 
                ps.setString(7, this.precio); 
                ps.setString(8, this.imagen); 
                
                System.out.println(ps.toString());
                exito = ps.executeUpdate() > 0;
                con.close();
               
	    }
	    catch (Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	    return exito;
	}
    
    
    public boolean cambiar(Properties prop)
	{
            boolean exito = false;
            
            try
	    {

                String driver = prop.getProperty("dbdriver");
                String host   = prop.getProperty("dbhost");
                String user   = prop.getProperty("dbuser");
                String password = prop.getProperty("dbpassword");
                String name     = prop.getProperty("dbname");
                String url = host + name  + "?user=" + user + "&password=" + password;
                System.out.println("Conexion a la BD: " + url);


                Class.forName(driver);     // Carga el driver


                Connection con = DriverManager.getConnection(url); // Crea una conexion a la BD

                PreparedStatement ps = con.prepareStatement("UPDATE VIDEOJUEGOS SET "
                        + "DESCRIPCION = ?,DESARROLLADOR = ?,PLATAFORMA = ?,CLASIFICACION = ?,"
                        + "GENEROS = ?,PRECIO = ?,IMAGEN = ? WHERE UPC = "+this.upc);
                
                ps.setString(1, this.descripcion);
                ps.setString(2, this.desarrollador);
                ps.setString(3, this.plataforma);
                ps.setString(4, this.clasificacion);
                ps.setString(5, this.generos);
                ps.setString(6, this.precio);
                ps.setString(7, this.imagen);
                
                System.out.println(ps.toString());
                exito = ps.executeUpdate() > 0;
                con.close();
               
	    }
	    catch (Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	    return exito;
	}
    
    public boolean borrar(Properties prop)
	{
            boolean exito = false;
            
            try
	    {

                String driver = prop.getProperty("dbdriver");
                String host   = prop.getProperty("dbhost");
                String user   = prop.getProperty("dbuser");
                String password = prop.getProperty("dbpassword");
                String name     = prop.getProperty("dbname");
                String url = host + name  + "?user=" + user + "&password=" + password;
                System.out.println("Conexion a la BD: " + url);


                Class.forName(driver);     // Carga el driver


                Connection con = DriverManager.getConnection(url); // Crea una conexion a la BD

                PreparedStatement ps = con.prepareStatement("DELETE FROM VIDEOJUEGOS WHERE UPC = "+this.upc);
                System.out.println(ps.toString());
                exito = ps.executeUpdate() > 0;
                con.close();
               
	    }
	    catch (Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	    return exito;
	}
    
}
