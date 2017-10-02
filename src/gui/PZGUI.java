package gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class PZGUI extends StateBasedGame {
	
	public static final boolean showFPS = true;
	
	public static final String gameName = "TNT Plants Vs. Zombies HCMIU";
	public static final int splashScreen = 0;
	public static final int menu = 1;
	public static final int play = 2;
	public static final int gameOver = 3;
	
	public PZGUI() {
		super(gameName);
		this.addState(new SplashScreen(splashScreen));
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new GameOver(gameOver));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		gc.setShowFPS(showFPS);
		this.getState(splashScreen).init(gc, this);
		this.getState(menu).		init(gc, this);
		this.getState(play).		init(gc, this);
		this.getState(gameOver).	init(gc, this);
		this.enterState(splashScreen); // show SplashScreen first
	}
	
	public static void changeState(int state) {
		
	}
	
	public static void main(String[] args){
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new PZGUI());
			appgc.setDisplayMode(800, 600, false);
			appgc.start();
		} 
		catch(SlickException e) {
			e.printStackTrace();
		}
	}

}
