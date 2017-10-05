package gui;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
	Animation zom = new Animation();
	public Play(int state) {
		
	}
	// Init Zombie
	public void initZombie() throws SlickException{
		int time=100;
		zom.addFrame(new Image("res/Zombie/male/Walk (1).png"), time);
		zom.addFrame(new Image("res/Zombie/male/Walk (2).png"), time);
		zom.addFrame(new Image("res/Zombie/male/Walk (3).png"), time);
		zom.addFrame(new Image("res/Zombie/male/Walk (4).png"), time);
		zom.addFrame(new Image("res/Zombie/male/Walk (5).png"), time);
		zom.addFrame(new Image("res/Zombie/male/Walk (6).png"), time);
		zom.addFrame(new Image("res/Zombie/male/Walk (7).png"), time);
		zom.addFrame(new Image("res/Zombie/male/Walk (8).png"), time);
		zom.addFrame(new Image("res/Zombie/male/Walk (9).png"), time);
		zom.addFrame(new Image("res/Zombie/male/Walk (10).png"), time);		
	}
	
	// Initialization
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		initZombie();
	}
	
	
	// Show Zombie
	public void showZombie(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		if (Mouse.isButtonDown(0))
			zom.draw(Mouse.getX() - 20 , 768 - 50 - Mouse.getY(), zom.getWidth()/3, zom.getHeight()/3);
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
