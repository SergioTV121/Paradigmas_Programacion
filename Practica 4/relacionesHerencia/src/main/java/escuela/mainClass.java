/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuela;

/**
 *
 * @author Sergio
 */
public class mainClass {
    
    public static void main(String[] args){
        Alumno sergio=new Alumno("2020630534","Sergio Tinoco",20,8.0,"Ing en IA");
        Docente mandrake=new Docente("DEC51384","Miguel Abel",41,"Basicas","Vespertino");
        Autoridad andres=new Autoridad("DIE021564","Andres Ortigoza",46,"Direccion general","Director de ESCOM");
        
        
        sergio.showData();
        mandrake.showData();
        andres.showData();
        
        sergio.anotar(sergio.getNombre());
        sergio.estudiar(sergio.getNombre());
        
        mandrake.Trabajar(mandrake.getNombre());
        mandrake.PagarImpuestos(mandrake.getNombre());
        
        andres.Trabajar(andres.getNombre());
        andres.PagarImpuestos(andres.getNombre());
    }
    
}
