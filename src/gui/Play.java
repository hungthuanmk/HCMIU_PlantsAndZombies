package gui;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import pz.Plant;
import pz.Zombie;

public class Play extends BasicGameState {

	Zombie[] zombie = new Zombie[50];
	Plant[] plant;

	public Play(int state) {

	}

	// Init Zombie
	public void initZombie() throws SlickException {

	}

	// Initialization
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		initZombie();
	}

	// Sun collected
	public void showSuncollectedGrid(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		int posX = 10;
		int posY = 10;
		int W = 200;
		int H = 45;
		g.drawRect(posX, posY, W, H);
	}

	public void showSuncollected(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

	}

	// Show Seed Board
	public void showSeedZoneGrid(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		int posX = 10;
		int posY = 120;
		int W = 140;
		int H = 90;
		for (int i = 0; i < 8; i++) {
			g.drawRect(posX, posY + H * i, W, H);
		}
	}

	public void showSeedZone(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

	}

	// Show Plant Zone
	public void showPlantZoneGrid(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		int posX = 350;
		int posY = 150;
		int W = 115;
		int H = 135;
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 9; j++)
				g.drawRect(posX + W * j, posY + H * i, W, H);

	}

	public void showPlantZone(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

	}

	// Render
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		showSuncollectedGrid(gc, sbg, g);
		showSeedZoneGrid(gc, sbg, g);
		showPlantZoneGrid(gc, sbg, g);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

	}

	public int getID() {
		return 2;
	}
}
