package gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class PlayUI {
	
	// Sun Collected
	public static void showSunCollectedGrid(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		int posX = 10;
		int posY = 20;
		int W = 200;
		int H = 50;
		g.drawRect(posX, posY, W, H);
	}

	public static void showSunCollected(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setColor(new Color(0, 0, 0, 150));
		g.fillRoundRect(60, 20, 150, 50, 20);
		SunUI.drawIcon(10, 5, 80, 80);
		
		g.drawString(SunUI.getSunCollected().toString(), 100, 100);
		g.setColor(new Color(255, 255, 255));
	}
	
	// Show Seed Zone
	public static void showSeedZoneGrid(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		int posX = 10;
		int posY = 120;
		int W = 140;
		int H = 90;
		for (int i = 0; i < 8; i++) {
			g.drawRect(posX, posY + H * i, W, H);
		}
	}

	public static void showSeedZone(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

	}
	
	// Show Plant Zone
	public static void showPlantZoneGrid(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		int posX = 443;
		int posY = 150;
		int W = 115;
		int H = 135;
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 9; j++)
				g.drawRect(posX + W * j, posY + H * i, W, H);

	}

	public static void showPlantZone(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

	}
	
}
