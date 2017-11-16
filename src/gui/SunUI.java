package gui;

import java.util.ArrayList;
import java.util.*;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import pz.Sun;

public class SunUI {
	private static int animationDuration = 200;
	private static ArrayList<Sun> sunManager = new ArrayList<>();
	private static Integer sunCollected = 50;
	static Image sunIcon; 
	static Animation sunAni = new Animation();	
	static Integer spawnCoolDownInMilisec = 1000;
	static Integer spawnCoolDownInFrame = 300;
	static Integer startTime;
	static Integer framePass = 0;
	
	static Timer timer;		
	
	public static Integer getSunCollected() {
		return sunCollected;
	}
	
	public static void gainSun(Integer sunCollected) {
		SunUI.sunCollected += sunCollected;
	}

	public static void init() throws SlickException{
		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 1.png"), animationDuration);
		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 2.png"), animationDuration);
		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 3.png"), animationDuration);
		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 4.png"), animationDuration);
		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 5.png"), animationDuration);
		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 6.png"), animationDuration);
		//sunAni.addFrame(new Image("/res/Pvz2plantfood.png"), animationDuration); // this for test animation restart
		//sunIcon = sunAni.getImage(5); //bug...
		sunIcon = new Image("/res/Sun Sprite/Sun 6.png");
		startTime = (int) System.currentTimeMillis();
	}
	
	public static Image drawIcon(float iconPosX, float iconPosY, float iconWidth, float iconHeight) throws SlickException{
		sunIcon.draw(iconPosX, iconPosY, iconWidth, iconHeight);
		return sunIcon;
	}
	
	
	public static void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		framePass++;
		for (int i=0; i<sunManager.size(); i++)
			sunManager.get(i).drawSun();
		
		if (framePass > spawnCoolDownInFrame)
		{
			framePass = 0;
			sunManager.add(new Sun(sunAni));
		}
			
	}
	
	public static void update(GameContainer gc, StateBasedGame sbg) throws SlickException {
		//timer.schedule(sunTask, 0, spawnCoolDownInMilisec);
		
		for (int i=0; i<sunManager.size(); i++)
			if (sunManager.get(i).isDone() == false)
				sunManager.get(i).updateSun();
			else{
				sunManager.remove(i--);
			}
	}

}
