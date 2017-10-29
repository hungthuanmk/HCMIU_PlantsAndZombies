package gui;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import pz.Bullet;
import pz.Plant;
import pz.Sun;
import pz.Zombie;

public class Play extends BasicGameState {

	ArrayList<Zombie> zombie = new ArrayList<Zombie>();	
	ArrayList<Plant> plant = new ArrayList<Plant>();
	ArrayList<Bullet> bullet = new ArrayList<Bullet>();
	ArrayList<Sun> sunList = new ArrayList<Sun>();
	
	private Image background;

	public Play(int state) {

	}

	// Init Zombie
	public void initZombie() throws SlickException {

	}

	// Initialization
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("res/Map_1.jpg");
		SunUI.init();
	}

	// Show Background
	public void showBackground(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		background.draw(-350, -205, (float) 0.71);
	}

	// Render
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		showBackground(gc, sbg, g);
		PlayUI.showSunCollectedGrid(gc, sbg, g);
		PlayUI.showPlantZoneGrid(gc, sbg, g);
		PlayUI.showSeedZoneGrid(gc, sbg, g);
		PlayUI.showSunCollected(gc, sbg, g);
		
		SunUI.render(gc, sbg, g);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		SunUI.update(gc, sbg);
	}

	public int getID() {
		return 2;
	}
}
