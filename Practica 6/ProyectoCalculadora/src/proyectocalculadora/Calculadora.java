/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalculadora;
import static java.lang.Math.*;
import javax.swing.JOptionPane;
/**
 *
 * @author 
 */
public class Calculadora 
{
        private double memoria=0;
	private char operadorAnterior='=';
        private boolean radianes=true;
        
	public void operacion(double numero, char operador)
	{
            
            if(operadorAnterior=='=')
                memoria = numero;
            else
            	switch(operadorAnterior)
		{
                   case '+': memoria+=numero; break;
                    case '-': memoria-=numero; break;
                    case 'x': memoria*=numero; break;
                    case '÷': memoria/=numero; break;
                    case 'I': memoria=1/memoria; break;
                    case '√': memoria=sqrt(memoria); break;
                    case 'S': 
                        if(radianes){
                              memoria=Math.sin(memoria); 
                        }
                        else{
                            memoria=Math.sin((memoria*Math.PI)/180);
                        }     
                        break;
                    case 'C': if(radianes){
                              memoria=Math.cos(memoria); 
                        }
                        else{
                            memoria=Math.cos((memoria*Math.PI)/180);
                        } 
                    break;
                    case 'T':
                        if(memoria==90.0 || memoria==(Math.PI/2)){
                            JOptionPane.showMessageDialog(null, 
                                    "La tangente de 90° no esta definida",
                                    "Error matematico",
                                    JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                        
                        if(radianes){
                              memoria=Math.tan(memoria); 
                        }
                        else{
                            memoria=Math.tan((memoria*Math.PI)/180);
                        } 
                    break;
                    case '∛': memoria=Math.cbrt(memoria); break;
                    case '^': memoria=memoria*memoria; break;
		}
            operadorAnterior=operador;
	}

        public void clearMemory()
        {
            this.memoria=0;
            this.operadorAnterior='=';
        }
        
	public double getMemoria()
	{
		return memoria;
	}

        public void setRadianes()
        {
            radianes=true;
        }
        
        public void setDegrees()
        {
            radianes=false;
        }
        
}
