/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplohilos;

import javax.swing.*;

public class Animador extends Thread{
	private JLabel et;
	private Parametros  p;
	private int width;
	private int height;
        private Animador otro; 

        
	public Animador(JLabel et, Parametros p, ImageIcon face, int w, int h){
		width = w;
		height= h;
		this.p = p;
		this.et = et;
		et.setIcon(face);
	}
        
           public Animador getOtro() {
        return otro;
    }

    public void setOtro(Animador otro) {
        this.otro = otro;
    }
         
    public JLabel getEt() {
        return et;
    }

    public void setEt(JLabel et) {
        this.et = et;
    }

    public Parametros getP() {
        return p;
    }

    public void setP(Parametros p) {
        this.p = p;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

        
	public void run(){
            int x = et.getX();
            int y = et.getY();
                 
            int dirX=1;
            int dirY=1;
          
            while(true){
                      try {
                        sleep(2);
                    }
                    catch (Exception ex){
			ex.printStackTrace();
                    }
		//System.out.println(et.getText()+ " en coordenadas (" + x + "," + y + ")");
                if(p.isMoving()){
                    
                   
                    if(Colision()){      
                        dirX*=-1;
                        try {
                        sleep(10);
                            }
                            catch (Exception ex){
                                ex.printStackTrace();
                            }
                    }else{
                        if(x > width-et.getWidth()-10 && dirX == 1){ 
                            dirX=-1; // si pega en la derecha
                            
                        }
                        if(x < 10 && dirX==-1){
                            dirX=1; // si pega en la izquierda
                            
                        }
                        //va de 1 en 1
                        if(y > height-et.getHeight() && dirY ==1){
                            dirY=-1; 
                           
                        }
                        if(y < 10 && dirY==-1){
                            dirY=1;//si pega arriba
                        }
                        
                    }
                    x=x+dirX;
                    y=y+dirY;
            
                    et.setLocation(x,y);

                    try {
                        sleep(8);
                    }
                    catch (Exception ex){
			ex.printStackTrace();
                    }
                    
		}

            }
	}
        
    public boolean Colision(){
        boolean colision=false;
       
        if((this.et.getX()+et.getWidth()==otro.et.getX()) || (otro.et.getX()+otro.et.getWidth() == this.et.getX()) ){
           colision=true; 
        }
        return colision; 
    }
}
