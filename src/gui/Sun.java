package gui;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import java.util.concurrent.ThreadLocalRandom;

public class Sun {
	private int posX = ThreadLocalRandom.current().nextInt(500, 1000 + 1);
	private int posY = 0;
	private int edgeY = ThreadLocalRandom.current().nextInt(500, 1000 + 1);
	private int width = 100;
	private int height = 100;
	
	private static int animationDuration = 200;
	
	static Animation sunAni = new Animation();	
	
//	public static void loadImage() throws SlickException{
//		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 1.png"), animationDuration);
//		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 2.png"), animationDuration);
//		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 3.png"), animationDuration);
//		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 4.png"), animationDuration);
//		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 5.png"), animationDuration);
//		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 6.png"), animationDuration);
//	}
	
	public void drawSun() throws SlickException{
		sunAni.draw(posX, posY, width, height);
	}
	
	public void updateSun(){
		if (posY < edgeY)
			this.posY++;
	}
	
	public void clickOn(){
		if (Mouse.getX() >= posX && Mouse.getX() <= posX + width && PZGUI.height - Mouse.getY() >= posY && PZGUI.height - Mouse.getY() <= posY + height) {
			if (Mouse.isButtonDown(0))
			{
				
			}
		
		}
	}
	
}
