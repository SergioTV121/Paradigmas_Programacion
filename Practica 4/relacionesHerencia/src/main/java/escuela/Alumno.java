/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuela;

/**
 *
 * @author Sergio
 */
public final class Alumno extends Persona implements Aprendiz{
    
    double promedio;
    String carrera;
    
    public Alumno(String id, String nombre, int edad,double promedio,String carrera){
        super(id,nombre,edad);
        this.promedio=promedio;
        this.carrera=carrera;
    }
    
      
    
    @Override
    
    public void anotar(String nombre){
        System.out.println(nombre+" esta tomando nota del tema");
    }
        
    @Override
     public void estudiar(String nombre){
        System.out.println(nombre+" esta estudiando");
    }
     
         
      public void showData(){
        super.showData();
        System.out.printf("Promedio: %.2f\n",promedio);
        System.out.print("Carrera: "+carrera+"\n");
   }
    
}
