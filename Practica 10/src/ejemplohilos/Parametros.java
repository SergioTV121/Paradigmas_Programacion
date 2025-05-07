/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplohilos;



// Almacena el estado del Sprite

public class Parametros{
	public boolean moving = true;

	public boolean isMoving(){
            return moving;
	}

	public void stopMoving(){
            moving = false;
	}

	public void startMoving(){
            moving = true;
	}

}