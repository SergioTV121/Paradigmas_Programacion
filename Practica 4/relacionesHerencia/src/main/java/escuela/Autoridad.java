/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuela;

/**
 *
 * @author Sergio
 */
public final class Autoridad extends Persona implements Contribuyente{
    
    String puesto,cargo;
    
   public Autoridad(String id, String nombre, int edad,String puesto,String cargo){
       super(id,nombre,edad);
       this.puesto=puesto;
       this.cargo=cargo;
   }
   
   public void showData(){
        super.showData();
        System.out.println("Puesto: "+puesto+"\n"+"Cargo: "+cargo+"\n");
   }
   
     @Override
    
    public void Trabajar(String nombre){
        System.out.println(nombre+" esta trabajando en el edificio de gobierno");
    }
        
    @Override
     public void PagarImpuestos(String nombre){
        System.out.println(nombre+" paga impuestos desde su tarjeta de credito");
    }
    
}
