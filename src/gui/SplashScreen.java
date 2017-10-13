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
	public Image sun;
	public Image logo;
	public Image playButton;
	
	Animation sunAni;
	
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
		sunAni = new Animation(new SpriteSheet("res/sunSprite.png",500,500), 300);
		
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
		sunAni.draw(sunPosX, 100);
	}
	
	// Render
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		showBackGround(gc, sbg, g);
		showLogo(gc, sbg, g);
		startButton(gc, sbg, g);
		showSun(gc, sbg, g);		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		sunPosX++;					
	}
	
	public int getID() {
		return 0;
	}
}
