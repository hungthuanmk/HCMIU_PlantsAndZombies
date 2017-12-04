package gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.Controller;

public class PlayUI {
	
	private static Text text = new Text();
	private static Image pauseButton;
	private static Image playButton;
	private static Image speedUpButton;
	
	
	private static float plantZonePosX = 432 * PZGUI.resolutionRateWidth;
	private static float plantZonePosY = 142 * PZGUI.resolutionRateHeight;
	private static float cellW = 110 * PZGUI.resolutionRateWidth;
	private static float cellH = 130 * PZGUI.resolutionRateHeight;
	
	private static float seedZonePosX = 10 * PZGUI.resolutionRateWidth;
	private static float seedZonePosY = 120 * PZGUI.resolutionRateHeight;
	private static float seedZoneW = 140 * PZGUI.resolutionRateWidth;
	private static float seedZoneH = 90 * PZGUI.resolutionRateHeight;
	
	private static float pauseButtonPosX = 1530 * PZGUI.resolutionRateWidth;
	private static float pauseButtonPosY = 10 * PZGUI.resolutionRateHeight;
	private static float pauseButtonWidth = 60 * PZGUI.resolutionRateWidth;
	private static float pauseButtonHeight = 60 * PZGUI.resolutionRateHeight;
	
	private static float speedUpButtonPosX = 1460 * PZGUI.resolutionRateWidth;
	private static float speedUpButtonPosY = 10 * PZGUI.resolutionRateHeight;
	private static float speedUpButtonWidth = 60 * PZGUI.resolutionRateWidth;
	private static float speedUpButtonHeight = 60 * PZGUI.resolutionRateHeight;
	
	public static float getPlantZonePosX() {
		return plantZonePosX;
	}
	public static float getPlantZonePosY() {
		return plantZonePosY;
	}
	public static float getCellW() {
		return cellW;
	}
	public static float getCellH() {
		return cellH;
	}
	public static float getSeedZonePosX() {
		return seedZonePosX;
	}
	public static float getSeedZonePosY() {
		return seedZonePosY;
	}
	public static float getSeedZoneW() {
		return seedZoneW;
	}
	public static float getSeedZoneH() {

		return seedZoneH;
	}
	
	public static void init() throws SlickException{
		text.loadFont("res/Fonts/FbUsv8C5eI.ttf", 35.0f * PZGUI.resolutionRateHeight);
		pauseButton = new Image("res/UI/pause.png");
		playButton = new Image("res/UI/play.png");
		speedUpButton = new Image("res/UI/speedUp.png");
	}
	
	// Sun Collected
	public static void showSunCollectedGrid(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		float posX = 10 * PZGUI.resolutionRateWidth;
		float posY = 20 * PZGUI.resolutionRateHeight;
		float W = 200 * PZGUI.resolutionRateWidth;
		float H = 45 * PZGUI.resolutionRateHeight;
		g.drawRect(posX, posY, W, H);
	}

	public static void showSunCollected(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		float iconPosX = 10 * PZGUI.resolutionRateWidth;
		float iconPosY = 5 * PZGUI.resolutionRateHeight;
		float iconW = 80 * PZGUI.resolutionRateWidth;
		float iconH = 80 * PZGUI.resolutionRateHeight;
		
		float textPosX = 120 * PZGUI.resolutionRateWidth;
		float textPosY = 22 * PZGUI.resolutionRateHeight;
		
		float posX = 60 * PZGUI.resolutionRateWidth;
		float posY = 20 * PZGUI.resolutionRateHeight;
		float W = 150 * PZGUI.resolutionRateWidth;
		float H = 45 * PZGUI.resolutionRateHeight;
		
		g.setColor(new Color(0, 0, 0, 150));
		g.fillRoundRect(posX, posY, W, H, 20);
		SunUI.drawIcon(iconPosX, iconPosY, iconW, iconH);
		
		text.render(textPosX, textPosY, SunUI.getSunCollected().toString(), Color.white);
		g.setColor(new Color(255, 255, 255));
	}
	
	// Show Seed Zone
	public static void showSeedZoneGrid(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		for (int i = 0; i < 8; i++) {
			g.drawRect(seedZonePosX, seedZonePosY + seedZoneH * i, seedZoneW, seedZoneH);
		}
	}
	
	// Show Plant Zone
	public static void showPlantZoneGrid(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 9; j++)
				g.drawRect(plantZonePosX + cellW * j, plantZonePosY + cellH * i, cellW, cellH);
	}

	// Pause button
	public static void showPauseButton(Graphics g) throws SlickException {
		pauseButton.draw(pauseButtonPosX, pauseButtonPosY, pauseButtonWidth, pauseButtonHeight);
		
		if (Controller.mouseInArea(pauseButtonPosX, pauseButtonPosY, pauseButtonPosX+pauseButtonHeight, pauseButtonPosY+pauseButtonHeight))
			pauseButton.draw(pauseButtonPosX, pauseButtonPosY, pauseButtonWidth, pauseButtonHeight, new Color(0, 0, 0, 50));
	}
	
	// Speed Up button
	public static void showSpeedUpButton(Graphics g) throws SlickException {
		speedUpButton.draw(speedUpButtonPosX, speedUpButtonPosY, speedUpButtonWidth, speedUpButtonHeight);
		
		if (Controller.mouseInArea(speedUpButtonPosX, speedUpButtonPosY, speedUpButtonPosX+speedUpButtonWidth, speedUpButtonPosY+speedUpButtonHeight))
			speedUpButton.draw(speedUpButtonPosX, speedUpButtonPosY, speedUpButtonWidth, speedUpButtonHeight, new Color(0, 0, 0, 50));
	}
	
}
