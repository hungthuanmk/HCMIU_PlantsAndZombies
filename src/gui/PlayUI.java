package gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class PlayUI {
	
	private static Text text = new Text();
	
	public static void init(){
		text.init("res/Fonts/FbUsv8C5eI.ttf", 35);
	}
	
	// Sun Collected
	public static void showSunCollectedGrid(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		float posX = 10 * PZGUI.resolutionRateWidth;
		float posY = 20 * PZGUI.resolutionRateHeight;
		float W = 200 * PZGUI.resolutionRateWidth;
		float H = 50 * PZGUI.resolutionRateHeight;
		g.drawRect(posX, posY, W, H);
	}

	public static void showSunCollected(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		float iconPosX = 10 * PZGUI.resolutionRateWidth;
		float iconPosY = 5 * PZGUI.resolutionRateHeight;
		float iconW = 80 * PZGUI.resolutionRateWidth;
		float iconH = 80 * PZGUI.resolutionRateHeight;
		float posX = 60 * PZGUI.resolutionRateWidth;
		float posY = 20 * PZGUI.resolutionRateHeight;
		float W = 150 * PZGUI.resolutionRateWidth;
		float H = 45 * PZGUI.resolutionRateHeight;
		
		g.setColor(new Color(0, 0, 0, 150));
		g.fillRoundRect(posX, posY, W, H, 20);
		SunUI.drawIcon(iconPosX, iconPosY, iconW, iconH);
		
		text.render(120, 22, SunUI.getSunCollected().toString());
		g.drawString(SunUI.getSunCollected().toString(), 100, 100);
		g.setColor(new Color(255, 255, 255));
	}
	
	// Show Seed Zone
	public static void showSeedZoneGrid(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		float posX = 10 * PZGUI.resolutionRateWidth;
		float posY = 120 * PZGUI.resolutionRateHeight;
		float W = 140 * PZGUI.resolutionRateWidth;
		float H = 90 * PZGUI.resolutionRateHeight;
		for (int i = 0; i < 8; i++) {
			g.drawRect(posX, posY + H * i, W, H);
		}
	}

	public static void showSeedZone(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

	}
	
	// Show Plant Zone
	public static void showPlantZoneGrid(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		float posX = 432 * PZGUI.resolutionRateWidth;
		float posY = 142 * PZGUI.resolutionRateHeight;
		
		float W = 110 * PZGUI.resolutionRateWidth;
		float H = 130 * PZGUI.resolutionRateHeight;
		
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 9; j++)
				g.drawRect(posX + W * j, posY + H * i, W, H);

	}

	public static void showPlantZone(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

	}
	
}
