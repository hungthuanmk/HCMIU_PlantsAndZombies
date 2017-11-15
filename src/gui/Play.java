package gui;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import com.Position;

import pz.*;

public class Play extends BasicGameState {

	ArrayList<Zombie> zombie = new ArrayList<Zombie>();	
	ArrayList<Plant> plant = new ArrayList<Plant>();
	ArrayList<Bullet> bullet = new ArrayList<Bullet>();
	ArrayList<Sun> sunList = new ArrayList<Sun>();
	
	Image demoSeedPack;
	
	private static float plantScaleFactor  = 0.25f;
	private static float zombieScaleFactor = 0.3f;
	private static float bulletScaleFactor = 0.6f;
	
	private Image background;
	
	public Play(int state) {	
	}

	// Init Zombie
	public void initZombie() throws SlickException {
		//((Peashooter) pl).loadAnimation();
	}

	// Initialization
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("res/Map_1.jpg");
		demoSeedPack = new Image("res/Plants/PeaShooter/Peashooter_Seed_Packet.png");
		SunUI.init();
		
		plant.add(new pz.plant.Peashooter(new Position(100,300)));
		plant.add(new pz.plant.Peashooter(new Position(100,500)));
		plant.add(new pz.plant.Peashooter(new Position(100,700)));
		plant.add(new pz.plant.Sunflower(new Position(100, 200)));
		
		zombie.add(new pz.zombie.FemaleZombie(new Position(1400, 700)));
		zombie.add(new pz.zombie.MaleZombie(new Position(1400, 500)));
		
		//for (Plant iPlant: plant) {
		//	iPlant.attack(bullet);
		//}
		
	}

	// Show Background
	public void showBackground(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		background.draw(-350, -205, (float) 0.71);
		//background.draw(0, 0, (float)PZGUI.width/background.getWidth() + (float)PZGUI.height/background.getHeight());
	}

	// Render
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		showBackground(gc, sbg, g);
		demoSeedPack.draw(10,120, 140, 90);
		demoSeedPack.draw(10,120+90, 140, 90);
		demoSeedPack.draw(10,120+90+90, 140, 90);
		demoSeedPack.draw(10,120+90+90+90, 140, 90);
		PlayUI.showSunCollectedGrid(gc, sbg, g);
		PlayUI.showPlantZoneGrid(gc, sbg, g);
		//PlayUI.showSeedZoneGrid(gc, sbg, g);
		PlayUI.showSunCollected(gc, sbg, g);
		
		for (Plant iPlant : plant) {
			iPlant.getIdleAni().draw(iPlant.getPos().x, iPlant.getPos().y, iPlant.getIdleAni().getWidth()*plantScaleFactor, iPlant.getIdleAni().getHeight()*plantScaleFactor);
		}
		
		for (Zombie iZombie : zombie) {
			iZombie.getAnimation().draw(iZombie.getPos().x, iZombie.getPos().y, iZombie.getAnimation().getWidth()*zombieScaleFactor, iZombie.getAnimation().getHeight()*zombieScaleFactor);
		}
		
		for (Bullet iBullet : bullet) {
			iBullet.getAnimation().draw(iBullet.getPos().x, iBullet.getPos().y, iBullet.getAnimation().getWidth()*bulletScaleFactor, iBullet.getAnimation().getHeight()*bulletScaleFactor);
		}
		
		SunUI.render(gc, sbg, g);
		
		int posX = 443;
		int posY = 150;
	//	int W = 115;
	//	int H = 135;
		// 9//5
		if (PZGUI.width - Mouse.getX() >= posX && PZGUI.width - Mouse.getX() <= 115 * 9 &&
			PZGUI.height - Mouse.getY() >= posY && PZGUI.height - Mouse.getY() <= 135 * 5) {
			g.setColor(new Color(1,1,1,0.5f));
			//g.drawRect();
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		SunUI.update(gc, sbg);
		
		for (Plant iPlant : plant) {
			iPlant.attack(bullet);
		}
		
		for (Zombie iZombie : zombie) {
			iZombie.move(); //move zombie
		}
		
		for (Bullet iBullet : bullet) {
			iBullet.move();
			if (iBullet.getPos().x > PZGUI.width + 500 || iBullet.getPos().y > PZGUI.height + 500) {
				iBullet = null;
			}
		}
	}

	public int getID() {
		return 2;
	}
}
