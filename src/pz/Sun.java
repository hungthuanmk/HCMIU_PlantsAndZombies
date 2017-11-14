package pz;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import gui.PZGUI;
import gui.SunUI;

import java.util.concurrent.ThreadLocalRandom;

public class Sun{
	private int posX;
	private int posY;
	private int edgeY;
	
	private int width = 80;
	private int height = 80;
	private boolean isClicked = false;
	private boolean isDone = false;
	private Animation animation;
	
	public Sun(Animation ani) throws SlickException{
		super();
		posX = ThreadLocalRandom.current().nextInt(450, 1400 + 1);
		posY = -98;
		edgeY = ThreadLocalRandom.current().nextInt(100, 760 + 1);
		ani.stop();
		this.animation = ani;
		this.animation.start(); // I think it can restart the animation
		
	}
	
	public void drawSun() throws SlickException{
		animation.draw(posX, posY, width, height);
	}
	
	public void updateSun(){
		clickOn();
		if (isClicked == false){
			if (posY < edgeY)
				this.posY++;
		}
		else{
			if (posX > 30 && posY > 20)
			{
				posX -= posX / 20;
				posY -= posY / 20;
			}
			else
				isDone = true;
		}
		
	}
	
	public boolean isClicked(){
		if (isClicked == true){
			return true;
		}			
		else{
			return false;
		}			
	}
	
	public void clickOn(){
		if (Mouse.getX() >= posX && Mouse.getX() <= posX + width && PZGUI.height - Mouse.getY() >= posY && PZGUI.height - Mouse.getY() <= posY + height) {
			
			if (Mouse.isButtonDown(0) && isClicked == false)
			{
				SunUI.gainSun(50);
				isClicked = true;
			}
		}
	}

	public boolean isDone() {
		return isDone;
	}
	
	
}
