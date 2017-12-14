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
import pz.sun.SunNatural;

public class SunUI {
	
	private static int animationDuration = 200;
	private static ArrayList<Sun> sunManager = new ArrayList<>();
	private static Integer sunCollected = 50;
	static Image sunIcon; 
	static Animation sunAni = new Animation();	
	static Integer spawnCoolDownInMilisec = 1000;
	static Integer spawnCoolDownInFrame = 300;
	static Integer startTime;
	static Integer framePassed = 0;
	
	static Timer timer;		
	
	/**
	 * Get sun animation
	 * @return	Sun Animation
	 */
	public static Animation getSunAni() { return sunAni; }

	/**
	 * Get sun collected, money
	 * @return	Sun collected
	 */
	public static Integer getSunCollected() { return sunCollected; }
	public static void setSunCollected(Integer sunCollected) { SunUI.sunCollected = sunCollected; }
	public static void setFramePassed(int framePassed) { SunUI.framePassed = SunUI.framePassed; }
	
	/**
	 * Gain sun
	 * @param sunCollected	Sun collected amount
	 */
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
		sunIcon = new Image("/res/Sun Sprite/Sun 6.png");
		//startTime = (int) System.currentTimeMillis();
	}
	
	/**
	 * Draw icon
	 * @param iconPosX	Pos X
	 * @param iconPosY	Pos Y
	 * @param iconWidth	Icon width
	 * @param iconHeight	Icon height
	 * @return	sun icon
	 * @throws SlickException SlickException
	 */
	public static Image drawIcon(float iconPosX, float iconPosY, float iconWidth, float iconHeight) throws SlickException{
		sunIcon.draw(iconPosX, iconPosY, iconWidth, iconHeight);
		return sunIcon;
	}
	
	/**
	 * Render SunUI
	 * @param gc	GameContainer
	 * @param sbg	StateBasedGame
	 * @param g	Graphics
	 * @throws SlickException
	 */
	public static void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		framePassed++;
		for (int i=0; i<sunManager.size(); i++)
			if ( !gc.isPaused() ) 
				sunManager.get(i).drawSun();	
			else 
				sunManager.get(i).drawStopedSun();
	}
	
	public static void update(GameContainer gc, StateBasedGame sbg) throws SlickException {
		//timer.schedule(sunTask, 0, spawnCoolDownInMilisec);
		if (framePassed > spawnCoolDownInFrame)
		{
			framePassed = 0;
			sunManager.add(new SunNatural(sunAni));
		}
		
		for (int i=0; i<sunManager.size(); i++)
			if (sunManager.get(i).isDone() == false)
				sunManager.get(i).updateSun();
			else {
				sunManager.remove(i--);
			}
	}

	public static ArrayList<Sun> getSunManager() { return sunManager; }	
}
