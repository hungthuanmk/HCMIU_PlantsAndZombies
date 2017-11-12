package gui;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import com.Position;

import pz.Bullet;
import pz.Plant;
import pz.Zombie;
import pz.plant.Peashooter;

public class Play extends BasicGameState {

	ArrayList<Zombie> zombie = new ArrayList<Zombie>();	
	ArrayList<Plant> plant = new ArrayList<Plant>();
	ArrayList<Bullet> bullet = new ArrayList<Bullet>();
	
	private Image background;
	
	Plant pl = new pz.plant.Peashooter(new Position(100,100));

	public Play(int state) {
		
	}

	// Init Zombie
	public void initZombie() throws SlickException {
		((Peashooter) pl).loadAnimation();
	}

	// Initialization
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("res/Map_1.jpg");
		pl.getIdleAni().addFrame(new Image("res/Plants/PeaShooter/Idle/1.png"), 100);
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
		//pl.getIdleAni().draw(pl.getPos().x, pl.getPos().y);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

	}

	public int getID() {
		return 2;
	}
}
