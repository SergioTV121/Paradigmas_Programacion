/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appgui;

/**
 *
 * @author Sergio
 */
public class Usuario {
    
    private String nombre,correo,numero,contraseña;
    
   public void setNombre(String nombre){
       this.nombre=nombre;
   }
   
   public void setNumero(String num){
       this.numero=num;
   }
   
   public void setCorreo(String email){
       this.correo=email;
   }
   
   public void setContraseña(String pasw){
       this.contraseña=pasw;
   }
   
   
   public String getDatos(){
       String datos;
       
       datos="\nNombre: "+this.nombre+
              "\nE-mail: "+this.correo+
               "\nNumero celular: "+this.numero;
       
       
       return datos;
   }
   
   
}
