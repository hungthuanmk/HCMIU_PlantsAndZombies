package gui;

import java.awt.Cursor;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class PZGUI extends StateBasedGame {
	public static int width = 1366;
	public static int height = 768;
	public static int targetFPS = 65;
	public static boolean showFPS = true;
	public static boolean fullScreen = false;
	public static boolean vSync = true;
	
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
		this.addState(new GameOver(gameOver));
	}
	
	private void loadDefaultSettings() {
		width      = 800;
		height     = 600;
		targetFPS  = 1000;
		showFPS    = true;
		fullScreen = false;
		vSync      = false;
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		gc.setShowFPS(showFPS);
		this.getState(splashScreen).init(gc, this);
		this.getState(menu).		init(gc, this);
		this.getState(play).		init(gc, this);
		this.getState(gameOver).	init(gc, this);
		this.enterState(splashScreen); // show SplashScreen first
	}
	
	public static void main(String[] args){
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new PZGUI(gameName));
			appgc.setDisplayMode(width, height, fullScreen);
			//appgc.setIcon("res/pvz_icon.png"); // it not work -_-
			appgc.setTargetFrameRate(targetFPS);
			appgc.setVSync(vSync);
			appgc.start(); //Begin thread game
		} 
		catch(SlickException e) {
			e.printStackTrace();
		}
	}

}
