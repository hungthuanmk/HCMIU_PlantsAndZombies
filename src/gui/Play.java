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
	
	float plantScaleFactor = 0.25f;
	
	
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
		
		plant.add(new pz.plant.Peashooter(new Position(100,100)));
		plant.add(new pz.plant.Peashooter(new Position(200,100)));
		plant.add(new pz.plant.Peashooter(new Position(300,100)));
		
		//bullet.add(new pz.bullet.BPeashooter(new Position(200,200)));
		//bullet.add(new pz.bullet.BPeashooter(new Position(300,200)));
		//bullet.add(new pz.bullet.BPeashooter(new Position(500,200)));
		
		for (Plant iPlant: plant) {
			iPlant.loadAnimation();
			iPlant.attack(bullet);
			bullet.get(bullet.size()-1).loadAnimation();
		}
		
		
				
		//for (Bullet iBullet: bullet)
			//iBullet.loadAnimation();

	}

	// Show Background
	public void showBackground(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		background.draw(-350, -205, (float) 0.71);
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

		//pl.getIdleAni().draw(pl.getPos().x, pl.getPos().y);
		//bl.getAnimation().draw(bl.getPos().x, bl.getPos().y);
		//pl.getIdleAni().draw(pl.getPos().x, pl.getPos().y);
		
		for (Plant iPlant : plant) {
			iPlant.getIdleAni().draw(iPlant.getPos().x, iPlant.getPos().y, iPlant.getIdleAni().getWidth()*plantScaleFactor, iPlant.getIdleAni().getHeight()*plantScaleFactor);
			//g.setColor(Color.black);
			//g.setLineWidth(5);
			//g.drawRect(iPlant.getPos().x, iPlant.getPos().y, iPlant.getIdleAni().getWidth(), iPlant.getIdleAni().getHeight());
		}
		
		for (Bullet iBullet : bullet) {
			iBullet.getAnimation().draw(iBullet.getPos().x, iBullet.getPos().y);
			//g.drawRect(iBullet.getPos().x, iBullet.getPos().y, iBullet.getAnimation().getWidth(), iBullet.getAnimation().getHeight());

			g.drawRect(iBullet.getPos().x, iBullet.getPos().y, iBullet.getAnimation().getWidth(), iBullet.getAnimation().getHeight());

		}
		
		SunUI.render(gc, sbg, g);
		
		int posX = 443;
		int posY = 150;
		int W = 115;
		int H = 135;
		// 9//5
		if (PZGUI.width - Mouse.getX() >= posX && PZGUI.width - Mouse.getX() <= 115 * 9 &&
			PZGUI.height - Mouse.getY() >= posY && PZGUI.height - Mouse.getY() <= 135 * 5) {
			g.setColor(new Color(1,1,1,0.5f));
			g.drawRect();
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		SunUI.update(gc, sbg);
		
		for (Bullet iBullet : bullet) {
			iBullet.move();
		}
		
		
	}

	public int getID() {
		return 2;
	}
}
