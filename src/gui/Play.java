package gui;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import pz.Zombie;

public class Play extends BasicGameState {
	
	Zombie zom;
	
	public Play(int state) {
		
	}
	// Init Zombie
	public void initZombie() throws SlickException{
		zom = new Zombie("bla");
	}
	
	// Initialization
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		initZombie();
	}
	
	
	// Show Zombie
	public void showZombie(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		zom.draw();
		//if (Mouse.isButtonDown(0))
	}
	
	// Show Seed Board
	public void showSeedBoardGrid(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
	}
	
	public void showSeedBoard(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
	}
	
	// Show Plant Zone
	public void showPlantZoneGrid(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
	}
	
	public void showPlantZone(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
	}
	// Render
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		showZombie(gc, sbg, g);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
	}
	
	public int getID() {
		return 2;
	}
}
