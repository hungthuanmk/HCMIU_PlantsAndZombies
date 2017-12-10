package gui;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import com.SSound;

public class SplashScreen extends BasicGameState {
	// Declare variable
	private Image background;
	public Image logo;
	public Image playButton;
	
	
	// PlaySound
	public SplashScreen(int state) {
		SSound.play("res/main_theme.ogg", false, 1f, 1f);
	}
	
	// Initialization
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		gc.getGraphics().setAntiAlias(PZGUI.isAA());

		background = new Image("res/wallpaper.jpg");
		logo = new Image("res/pvz_logo.png");
		playButton = new Image("res/Button/PlayDemo.png");

		System.out.println("SplashScreen Init complete");
		System.out.println("Wid: " + PZGUI.getWidth());
		System.out.println("Hei: " + PZGUI.getHeight());
	}

	// Start Button
	public void startButton(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		float rate = 0.9f;
		float width = playButton.getWidth() * PZGUI.getResolutionRateWidth() * rate;
		float height = playButton.getHeight() * PZGUI.getResolutionRateHeight() * rate;
		
		float posX = PZGUI.getWidth()  /2 - width/2;
		float posY = PZGUI.getHeight() * (float)(0.7) - height/2;
		
		float edgeX = posX + width;
		float edgeY = posY + height;

		playButton.draw(posX, posY, width, height);
		if (	Mouse.getX() >= posX && 
				Mouse.getX() <= edgeX && 
				PZGUI.getHeight() - Mouse.getY() >= posY	&& 
				PZGUI.getHeight() - Mouse.getY() <= edgeY) {
			playButton.draw(posX, posY, width, height, new Color(100, 100, 100, 60));
			
			if (Mouse.isButtonDown(0))
				sbg.enterState(1);
		}
	}

	// BackGround
	public void showBackGround() throws SlickException {
		background.draw(0, 0, PZGUI.getWidth(), PZGUI.getHeight());
	}

	// Game Logo
	public void showLogo() throws SlickException {
		float rate = (float) 0.7;
		float width = logo.getWidth() * PZGUI.getResolutionRateWidth() * rate;
		float height = logo.getHeight() * PZGUI.getResolutionRateHeight() * rate;
		float posX = PZGUI.getWidth()/2 - width/2;
		float posY = PZGUI.getHeight()*(float)(0.2) - height/2;

		logo.draw(posX, posY, width, height);
	}
	
	// Render
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setAntiAlias(PZGUI.isAA());
		showBackGround();
		showLogo();
		startButton(gc, sbg, g);
		//DebugTool.showMousePosition(g);
	}	
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
	}

	public int getID() {
		return 0;
	}
}
