package gui;

import java.util.concurrent.TimeUnit;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.Controller;
import com.sun.glass.events.MouseEvent;

public class PlayUI {

	private static Image pauseButton;
	private static Image playButton;
	private static Image speedUpButton;
	
	private static Text sunView = new Text(35.0f);
	private static Text gamePausedText = new Text(70.0f);
	
	private static boolean isSpeedUpClicked = false;

	private static float plantZonePosX = 432 * PZGUI.getResolutionRateWidth();
	private static float plantZonePosY = 142 * PZGUI.getResolutionRateHeight();
	private static float cellW = 110 * PZGUI.getResolutionRateWidth();
	private static float cellH = 130 * PZGUI.getResolutionRateHeight();

	private static float seedZonePosX = 10  * PZGUI.getResolutionRateWidth();
	private static float seedZonePosY = 120 * PZGUI.getResolutionRateHeight();
	private static float seedZoneW = 140 * PZGUI.getResolutionRateWidth();
	private static float seedZoneH = 90  * PZGUI.getResolutionRateHeight();

	private static float pauseButtonPosX = 1530 * PZGUI.getResolutionRateWidth();
	private static float pauseButtonPosY = 10   * PZGUI.getResolutionRateHeight();
	private static float pauseButtonWidth = 60  * PZGUI.getResolutionRateWidth();
	private static float pauseButtonHeight = 60 * PZGUI.getResolutionRateHeight();

	private static float speedUpButtonPosX = 1460 * PZGUI.getResolutionRateWidth();
	private static float speedUpButtonPosY = 10   * PZGUI.getResolutionRateHeight();
	private static float speedUpButtonWidth = 60  * PZGUI.getResolutionRateWidth();
	private static float speedUpButtonHeight = 60 * PZGUI.getResolutionRateHeight();

	public static float getPlantZonePosX() {return plantZonePosX;}
	public static float getPlantZonePosY() {return plantZonePosY;}
	public static float getCellW() 		   {return cellW;}
	public static float getCellH() 		   {return cellH;}
	public static float getSeedZonePosX()  {return seedZonePosX;}
	public static float getSeedZonePosY()  {return seedZonePosY;}
	public static float getSeedZoneW()     {return seedZoneW;}
	public static float getSeedZoneH()     {return seedZoneH;}

	public static void init() throws SlickException {
		pauseButton   = new Image("res/UI/pause.png");
		playButton    = new Image("res/UI/play.png");
		speedUpButton = new Image("res/UI/speedUp.png");
	}

	// Sun Collected
	public static void showSunCollectedGrid(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		float posX = 10 * PZGUI.getResolutionRateWidth();
		float posY = 20 * PZGUI.getResolutionRateHeight();
		float W = 200 * PZGUI.getResolutionRateWidth();
		float H = 45  * PZGUI.getResolutionRateHeight();
		g.drawRect(posX, posY, W, H);
	}

	public static void showSunCollected(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		float iconPosX = 10 * PZGUI.getResolutionRateWidth();
		float iconPosY = 5  * PZGUI.getResolutionRateHeight();
		float iconW = 80 * PZGUI.getResolutionRateWidth();
		float iconH = 80 * PZGUI.getResolutionRateHeight();

		float textPosX = 120 * PZGUI.getResolutionRateWidth();
		float textPosY = 22  * PZGUI.getResolutionRateHeight();

		float posX = 60 * PZGUI.getResolutionRateWidth();
		float posY = 20 * PZGUI.getResolutionRateHeight();
		float W = 150 * PZGUI.getResolutionRateWidth();
		float H = 45  * PZGUI.getResolutionRateHeight();

		g.setColor(new Color(0, 0, 0, 150));
		g.fillRoundRect(posX, posY, W, H, 20);
		SunUI.drawIcon(iconPosX, iconPosY, iconW, iconH);

		sunView.render(textPosX, textPosY, SunUI.getSunCollected().toString(), Color.white);
		g.setColor(new Color(255, 255, 255));
	}

	// Show Seed Zone
	public static void showSeedZoneGrid(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		for (int i = 0; i < 8; i++) 
			g.drawRect(seedZonePosX, seedZonePosY + seedZoneH * i, seedZoneW, seedZoneH);
	}

	// Show Plant Zone
	public static void showPlantZoneGrid(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 9; j++)
				g.drawRect(plantZonePosX + cellW * j, plantZonePosY + cellH * i, cellW, cellH);
	}

	// Pause button
	public static void showPauseButton(GameContainer gc, Graphics g) throws SlickException {
		pauseButton.draw(pauseButtonPosX, pauseButtonPosY, pauseButtonWidth, pauseButtonHeight);

		if (Controller.mouseInArea(pauseButtonPosX, pauseButtonPosY, pauseButtonPosX + pauseButtonHeight,
									pauseButtonPosY + pauseButtonHeight)) {
			pauseButton.draw(pauseButtonPosX, pauseButtonPosY, pauseButtonWidth, pauseButtonHeight, new Color(0, 0, 0, 50));

			if (Mouse.getEventButtonState() && Mouse.getEventButton() == 0) {
				gc.setPaused(!gc.isPaused());
				try {
					TimeUnit.MICROSECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void showPlayButton(GameContainer gc, Graphics g) {
		if (gc.isPaused()) {
			g.setColor(new Color(1, 1, 1, 100));
			g.fillRect(0, 0, PZGUI.getWidth(), PZGUI.getHeight());
			gamePausedText.render((PZGUI.getWidth()/2 - 170) * PZGUI.getResolutionRateWidth(), 300 * PZGUI.getResolutionRateHeight(), "Game is Paused!");
			playButton.draw(pauseButtonPosX, pauseButtonPosY, pauseButtonWidth, pauseButtonHeight);
		}
	}

	// Speed Up button
	public static void showSpeedUpButton(GameContainer gc, Graphics g) throws SlickException {
		speedUpButton.draw(speedUpButtonPosX, speedUpButtonPosY, speedUpButtonWidth, speedUpButtonHeight);
		
		if (Controller.mouseInArea(speedUpButtonPosX, speedUpButtonPosY, speedUpButtonPosX + speedUpButtonWidth,
									speedUpButtonPosY + speedUpButtonHeight)) {
			speedUpButton.draw(speedUpButtonPosX, speedUpButtonPosY, speedUpButtonWidth, speedUpButtonHeight,
								new Color(0, 0, 0, 50));
			if (Mouse.getEventButtonState() && Mouse.getEventButton() == 0) {
				gc.setTargetFrameRate(60 * (isSpeedUpClicked==false?0:1));
				gc.setVSync(isSpeedUpClicked);
				isSpeedUpClicked = !isSpeedUpClicked;
				try {
					TimeUnit.MICROSECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		if (isSpeedUpClicked == false) {
			speedUpButton.draw(speedUpButtonPosX, speedUpButtonPosY, speedUpButtonWidth, speedUpButtonHeight, new Color(0, 0, 0, 100));
		}
		
	}

}
