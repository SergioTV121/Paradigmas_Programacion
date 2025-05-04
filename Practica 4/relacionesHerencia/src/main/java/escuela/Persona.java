package escuela;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sergio
 */
public class Persona {
    
    String id, nombre;
    int edad;
    
    public Persona(String id,String nombre,int edad){
        this.id=id;
        this.nombre=nombre;
        this.edad=edad;
    }
    
     public String getNombre(){
        return nombre;
    }
    
    public void showData(){
        System.out.printf("\nId persona: %s\nNombre: %s\nEdad: %d\n",id,nombre,edad);
    }
    
}
