/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuela;

/**
 *
 * @author Sergio
 */
public final class Docente extends Persona implements Contribuyente{
    
      String area,turno;
   public Docente(String id, String nombre,int edad,String area,String turno){
       super(id,nombre,edad);
       this.area=area;
       this.turno=turno;
   }
   
   public void showData(){
        super.showData();
        System.out.println("Area: "+area+"\n"+"Turno: "+turno+"\n");
   }
    
   
    @Override
    
    public void Trabajar(String nombre){
        System.out.println(nombre+" esta trabajando impartiendo clases a los alumnos de ESCOM");
    }
        
    @Override
     public void PagarImpuestos(String nombre){
        System.out.println(nombre+" paga impuestos desde de su cuenta de ahorros");
    }
}
