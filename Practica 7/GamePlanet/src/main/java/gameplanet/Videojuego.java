/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameplanet;

/**
 *
 * @author Sergio
 */
public class Videojuego {
    String upc,descripcion,desarrollador,plataforma,clasificacion,generos;
    double precio;
    public Videojuego(String upc, String desc, String dev,String plat,
                        String clasif,String gen,double precio){
        this.upc=upc;
        this.descripcion=desc;
        this.desarrollador=dev;
        this.plataforma=plat;
        this.clasificacion=clasif;
        this.generos=gen;
        this.precio=precio;
    }
    
    String getDatos(){
        String datos;
        datos="UPC: "+this.upc;
        datos=datos+"\nDescripcion: "+this.descripcion;
        datos=datos+"\nDesarrollador: "+this.desarrollador;
        datos=datos+"\nPlataforma: "+this.plataforma;
        datos=datos+"\nClasificacion: "+this.clasificacion;
        datos=datos+"\nGeneros: "+this.generos;
        datos=datos+"\nPrecio: "+this.precio+" pesos";
        
        return datos;
    }
}
