package gui;

import java.util.ArrayList;
import java.util.*;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import pz.Sun;

public class SunUI {
	private static int animationDuration = 200;
	private static ArrayList<Sun> sunManager;
	
	static Image sunIcon; 
	static Animation sunAni = new Animation();	
	static int spawnCoolDownInMilisec = 5000;
	static int clock;
	
	static Timer timer;
	
	
	
	public static void init() throws SlickException{
		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 1.png"), animationDuration);
		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 2.png"), animationDuration);
		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 3.png"), animationDuration);
		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 4.png"), animationDuration);
		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 5.png"), animationDuration);
		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 6.png"), animationDuration);
		//sunIcon = sunAni.getImage(5); //bug...
		sunIcon = new Image("/res/Sun Sprite/Sun 6.png");
	}
	
	public static Image drawIcon(int iconPosX, int iconPosY, int iconWidth, int iconHeight) throws SlickException{
		sunIcon.draw(iconPosX, iconPosY, iconWidth, iconHeight);
		return sunIcon;
	}
	
	public static void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		//timer.schedule(sunTask, 0, spawnCoolDownInMilisec);
		
		//for (int i=0; i<sunManager.size(); i++)
		//	sunManager.get(i).updateSun();
	}
}
