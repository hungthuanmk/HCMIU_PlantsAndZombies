package pz;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;

import com.Clickable;

import gui.PZGUI;
import gui.SunUI;

import java.util.concurrent.ThreadLocalRandom;

public class Sun implements Clickable{
	private float posX;
	private float posY;
	private int edgeY;
	
	private float width  = 80 * PZGUI.getResolutionRateWidth();
	private float height = 80 * PZGUI.getResolutionRateHeight();
	
	private int framePass;
	private int stayTimeInFrame = 60*10; // fps * second
	
	private boolean isClicked = false;
	private boolean isDone = false;
	private Animation animation;
	
	public Sun(Animation ani) throws SlickException{
		super();
		posX  = ThreadLocalRandom.current().nextInt((int)(420*PZGUI.getResolutionRateWidth()), (int)(PZGUI.getResolutionRateHeight()*1350));
		posY  = -98;
		edgeY = ThreadLocalRandom.current().nextInt((int)(100*PZGUI.getResolutionRateWidth()), (int)(750*PZGUI.getResolutionRateHeight()));
		ani.stop();
		this.animation = ani;
		this.animation.start(); // I think it can restart the animation
		framePass = 0;		
	}
	
	public void drawSun() throws SlickException{
		animation.draw(posX, posY, width, height);
	}
	
	public void drawStopSun() throws SlickException{
		animation.getCurrentFrame().draw(posX, posY, width, height);
	}
	
	public void updateSun(){
		clickOn();
		if (isClicked == false){
			if (posY < edgeY)
				this.posY++;
			else{
				if (framePass <= stayTimeInFrame)
					framePass++;
				else
					isDone = true;
			}
		}
		else{
			//if (posX > 30 && posY > 20)
			if (posX > 30)
			{
				posX -= posX / 20f;
				posY -= posY / 20f;
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
		if (Mouse.getX() >= posX && Mouse.getX() <= posX + width && PZGUI.getHeight() - Mouse.getY() >= posY && PZGUI.getHeight() - Mouse.getY() <= posY + height) {
			
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

	@Override
	public void onClicked() {
		// TODO Auto-generated method stub
		
	}	
}
