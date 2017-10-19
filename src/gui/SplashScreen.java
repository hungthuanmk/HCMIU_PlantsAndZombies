package gui;

import java.util.Vector;
import java.util.Random;
import com.SSound;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class SplashScreen extends BasicGameState {
	// Declare variable
	public Image background;
	
	public Image logo;
	public Image playButton;
	
	Animation sunAni = new Animation();
	Animation peaShooter = new Animation();
	
	int sunPosX = 0, sunPosY = 0;
	
	// PlaySound
	public SplashScreen(int state) {
		SSound.play("res/main_theme.ogg",false, 1f, 1f);
	}
	
	// Initialization
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		gc.getGraphics().setAntiAlias(PZGUI.AA);
		
		background = new Image("res/wallpaper.jpg");
		logo = new Image("res/pvz_logo.png");
		
		playButton = new Image("res/Button/PlayDemo.png");
		
		
		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 1.png"), 200);
		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 2.png"), 200);
		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 3.png"), 200);
		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 4.png"), 200);
		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 5.png"), 200);
		sunAni.addFrame(new Image("/res/Sun Sprite/Sun 6.png"), 200);
		
		int ani_speed = 250;
		peaShooter.addFrame(new Image("/res/Peashooter/PeaShooter 1.png"), ani_speed);
		peaShooter.addFrame(new Image("/res/Peashooter/PeaShooter 2.png"), ani_speed);
		peaShooter.addFrame(new Image("/res/Peashooter/PeaShooter 3.png"), ani_speed);
		peaShooter.addFrame(new Image("/res/Peashooter/PeaShooter 4.png"), ani_speed);
		peaShooter.addFrame(new Image("/res/Peashooter/PeaShooter 5.png"), ani_speed);
		
		System.out.println("SplashScreen Init complete");
		System.out.println("Wid: " + PZGUI.width);
		System.out.println("Hei: " + PZGUI.height);
	}
	
	// Create Thing
	// Start Button
	public void startButton(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		int posX = 420;
		int posY = 520;
		int edgeX = posX + playButton.getWidth();
		int edgeY = posY + playButton.getHeight();
		
		if (Mouse.getX() >= posX && 
			Mouse.getX() <= edgeX && 
			PZGUI.height - Mouse.getY() >= posY && 
			PZGUI.height - Mouse.getY() <= edgeY)
		{
			playButton.draw(posX, posY, playButton.getWidth(), playButton.getHeight(), new Color(100, 100, 100, 2f));
			//playButton.drawCentered(posX, posY); //can't change filter, set size 
			if (Mouse.isButtonDown(0))
				sbg.enterState(1);
			
		}
		else 
			playButton.draw(posX, posY, playButton.getWidth(), playButton.getHeight());		
		
	}
	// BackGround
	public void showBackGround(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		//background.drawWarped(0, 0, 0, PZGUI.height, PZGUI.width, PZGUI.height, PZGUI.width, 0);
		background.draw(0, 0, PZGUI.width, PZGUI.height);
	}
	// Game Logo
	public void showLogo(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		float posX = PZGUI.width / (9/2); //Just a random number ._.
		float posY = PZGUI.height / (16/2); 
		float wid = logo.getWidth() / (2);
		float hei = logo.getHeight() / (2);
		
		logo.draw(posX, posY, wid, hei);
	}	
	// Sun
	public void showSun(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		sunAni.draw(400, sunPosY, 100, 100);
		peaShooter.draw(500, 500, 200, 200);
		
		
	}
	
	// Render
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		showBackGround(gc, sbg, g);
		showLogo(gc, sbg, g);
		startButton(gc, sbg, g);
		showSun(gc, sbg, g);		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		//sunPosX++;					
		sunPosY++;					
	}
	
	public int getID() {
		return 0;
	}
}
