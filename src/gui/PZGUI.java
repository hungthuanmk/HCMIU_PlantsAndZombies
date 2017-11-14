package gui;

import java.io.File;
import java.io.IOException;

import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.*;

public class PZGUI extends StateBasedGame {
	public static int width 	= 1600;
	public static int height 	= 900;
	public static int targetFPS = 65;
	public static boolean showFPS 	 = true;
	public static boolean fullScreen = false;
	public static boolean vSync 	 = true;
	public static boolean AA		 = true;
	
	public static final String gameName = "TNT Plants Vs. Zombies HCMIU";
	public static final int splashScreen = 0;
	public static final int menu = 1;
	public static final int play = 2;
	public static final int gameOver = 3;
	
	public PZGUI(String gameName) {
		super(gameName);
		try {
			Ini ini = new Ini(new File("config.ini"));
			width      = Integer.parseInt	  (ini.get("DISPLAY", "width"	  ));
			height     = Integer.parseInt	  (ini.get("DISPLAY", "height"	  ));
			targetFPS  = Integer.parseInt	  (ini.get("DISPLAY", "targetFPS" ));
			showFPS    = Boolean.parseBoolean (ini.get("DISPLAY", "showFPS"	  ));
			fullScreen = Boolean.parseBoolean (ini.get("DISPLAY", "fullScreen"));
			vSync      = Boolean.parseBoolean (ini.get("DISPLAY", "vSync"	  ));
			AA         = Boolean.parseBoolean (ini.get("DISPLAY", "AA"	  ));
			
		} catch (InvalidFileFormatException e) {
			e.printStackTrace();
			this.loadDefaultSettings();
			
		} catch (IOException e) {
			e.printStackTrace();
			this.loadDefaultSettings();
		}
		this.addState(new SplashScreen(splashScreen));
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		//this.addState(new GameOver(gameOver));
	}
	
	private void loadDefaultSettings() {
		width      = 800;
		height     = 600;
		targetFPS  = 1000;
		showFPS    = true;
		fullScreen = false;
		vSync      = false;
		AA         = true;
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		//this.getState(splashScreen).init(gc, this);
		//this.getState(menu).		  init(gc, this);
		//this.getState(play).		  init(gc, this);
		//this.getState(gameOver).	  init(gc, this);
		this.enterState(splashScreen, new FadeInTransition(), new EmptyTransition()); // show SplashScreen first	
	}
	
	public static void main(String[] args){
		AppGameContainer appgc;
	    
		try {
			appgc = new AppGameContainer(new PZGUI(gameName));			
			appgc.setShowFPS(showFPS);
			appgc.setDisplayMode(width, height, fullScreen);
			appgc.setTargetFrameRate(targetFPS);
			appgc.setVSync(vSync);
			appgc.setSmoothDeltas(true);
			appgc.setAlwaysRender(true);
			
			appgc.start(); //Begin thread game
		} 
		catch(SlickException e) {
			e.printStackTrace();
		}
	}

}
