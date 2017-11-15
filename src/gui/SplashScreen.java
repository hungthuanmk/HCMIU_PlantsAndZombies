package gui;

import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class SplashScreen extends BasicGameState {
	// Declare variable
	private Image background;
	public Image logo;
	public Image playButton;
	
	// PlaySound
	public SplashScreen(int state) {
		//SSound.play("res/main_theme.ogg", false, 1f, 1f);
	}
	
	// Text
	
	// Initialization
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		gc.getGraphics().setAntiAlias(PZGUI.AA);

		background = new Image("res/wallpaper.jpg");
		logo = new Image("res/pvz_logo.png");
		playButton = new Image("res/Button/PlayDemo.png");

		System.out.println("SplashScreen Init complete");
		System.out.println("Wid: " + PZGUI.width);
		System.out.println("Hei: " + PZGUI.height);
	}

	// Create Thing
	// Start Button
	public void startButton(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		float rate = (float)0.9;
		float width = playButton.getWidth() * PZGUI.resolutionRateWidth * rate;
		float height = playButton.getHeight() * PZGUI.resolutionRateHeight * rate;
		
		float posX = PZGUI.width  /2 - width/2;
		float posY = PZGUI.height * (float)(0.7) - height/2;
		
		float edgeX = posX + width;
		float edgeY = posY + height;

//		System.out.println("Width = " + width);
//		System.out.println("Height = " + height);
		
		playButton.draw(posX, posY, width, height);
		if (	Mouse.getX() >= posX && 
				Mouse.getX() <= edgeX && 
				PZGUI.height - Mouse.getY() >= posY	&& 
				PZGUI.height - Mouse.getY() <= edgeY) {
			playButton.draw(posX, posY, width, height, new Color(100, 100, 100, 60));
			
			if (Mouse.isButtonDown(0))
				sbg.enterState(1);
		}
	}

	// BackGround
	public void showBackGround(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		background.draw(0, 0, PZGUI.width, PZGUI.height);
	}

	// Game Logo
	public void showLogo(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		float rate = (float) 0.7;
		float width = logo.getWidth() * PZGUI.resolutionRateWidth * rate;
		float height = logo.getHeight() * PZGUI.resolutionRateHeight * rate;
		float posX = PZGUI.width/2 - width/2;
		float posY = PZGUI.height*(float)(0.2) - height/2;

		logo.draw(posX, posY, width, height);
	}

	
	// Render
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		showBackGround(gc, sbg, g);
		showLogo(gc, sbg, g);
		startButton(gc, sbg, g);
		DebugTool.showMousePosition(g);
		
	}	
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
	}

	public int getID() {
		return 0;
	}
}
