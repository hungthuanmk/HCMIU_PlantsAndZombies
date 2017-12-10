package gui;

import java.io.File;
import java.io.IOException;

import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.*;

public class PZGUI extends StateBasedGame {
	private static int width 	= 1600; 	
	private static int height 	= 900;
	
//	public static int width		= 800;  	public static int height	= 450;
	
	private static int 	   targetFPS = 65;
	private static boolean showFPS 	 = true;
	private static boolean fullScreen = false;
	private static boolean vSync 	 = true;
	private static boolean AA		 = true;
	
	private static final String gameName = "TNT Plants Vs. Zombies HCMIU";
	private static final int splashScreen = 0;
	private static final int menu = 1;
	private static final int play = 2;
	@SuppressWarnings("unused")
	private static final int gameOver = 3;
	
	private static float resolutionRateWidth;
	private static float resolutionRateHeight;
	
	private static int defaultWidth = 1600;
	private static int defaultHeight = 900;
	
	public PZGUI(String gameName) {
		super(gameName);
		try {
			Ini ini = new Ini(new File("config.ini"));
//			width      = Integer.parseInt	  (ini.get("DISPLAY", "width"	  ));
//			height     = Integer.parseInt	  (ini.get("DISPLAY", "height"	  ));
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
		width      = defaultWidth;
		height     = defaultWidth;
		targetFPS  = 60;
		showFPS    = true;
		fullScreen = false;
		vSync      = true;
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
			
			if (fullScreen == true){
				width = appgc.getScreenWidth();
				height  = appgc.getScreenHeight();
			}			
			appgc.setDisplayMode(width, height, fullScreen);
			appgc.setUpdateOnlyWhenVisible(true);
			appgc.setTargetFrameRate(targetFPS);
			appgc.setVSync(vSync);
			appgc.setSmoothDeltas(true);
			appgc.setAlwaysRender(true);					
			resolutionRateHeight = (float)appgc.getHeight() / (float)defaultHeight;
			resolutionRateWidth  = (float)appgc.getWidth() / (float)defaultWidth;
			
			appgc.start(); //Begin thread game
		} 
		catch(SlickException e) {
			e.printStackTrace();
		}
	}

	public static boolean isAA() 					{return AA;}
	public static void 	  setAA(boolean aA) 		{AA = aA;}

	public static int 	  getWidth() 				{return width;}
	public static void 	  setWidth(int width) 		{PZGUI.width = width;}

	public static int 	  getHeight() 				{return height;}
	public static void    setHeight(int height)     {PZGUI.height = height;}

	public static float   getResolutionRateWidth()  {return resolutionRateWidth;}
	public static float   getResolutionRateHeight() {return resolutionRateHeight;}
	
}
