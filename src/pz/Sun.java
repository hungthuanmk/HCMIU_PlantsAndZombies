package pz;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;

import gui.PZGUI;
import gui.Play;

import java.util.concurrent.ThreadLocalRandom;

public class Sun {
	private int posX = 100;
	private int posY = - 50;
	private int edgeY = 100;
	private int width = 100;
	private int height = 100;
	private boolean isClicked = false;
	private Animation animation;
	
	public Sun() throws SlickException{
		posX = ThreadLocalRandom.current().nextInt(500, 1000 + 1);
		edgeY = ThreadLocalRandom.current().nextInt(500, 1000 + 1);
	}
	
	public void drawSun() throws SlickException{
		animation.draw(posX, posY, width, height);
	}
	
	public void updateSun(){
		if (isClicked == false){
			if (posY < edgeY)
				this.posY++;
		}
		else{
			// fly to SunCollectedBoard
		}
		
	}
	
	public boolean isClicked(){
		if (isClicked == true)
			return true;
		else 
			return false;
	}
	
	public void clickOn(){
		if (Mouse.getX() >= posX && Mouse.getX() <= posX + width && PZGUI.height - Mouse.getY() >= posY && PZGUI.height - Mouse.getY() <= posY + height) {
			if (Mouse.isButtonDown(0))
			{
				Play.sunGain(50);
				isClicked = true;
			}		
		}
	}
	
	
}
