package gui;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.state.*;

import com.Controller;
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
	}

	// Initialization
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("res/Map_1.jpg");
		demoSeedPack = new Image("res/Plants/PeaShooter/Peashooter_Seed_Packet.png");
		SunUI.init();
		
		plant.add(new pz.plant.Peashooter(new Position(100,300)));
		plant.add(new pz.plant.Peashooter(new Position(100,500)));
		plant.add(new pz.plant.Peashooter(new Position(100,100)));
		plant.add(new pz.plant.Sunflower(new Position(100, 200)));
		
		zombie.add(new pz.zombie.FemaleZombie(new Position(1200, 200)));
		zombie.add(new pz.zombie.MaleZombie(new Position(1200, 300)));
		
		PlayUI.init();
	}

	// Show Background
	public void showBackground(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		float rate = (float)0.69;
		float width = background.getWidth() * PZGUI.resolutionRateWidth * rate;
		float height = background.getHeight() * PZGUI.resolutionRateHeight * rate;
		float moveLeft = (float)PZGUI.width * (7.0f/32);
		float moveUp = (float)PZGUI.height * (41.0f/180);
		
		background.draw(-moveLeft, -moveUp, width, height);
	}

	// Render
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

		showBackground(gc, sbg, g);
		
		eventHandle(g);
		
		demoSeedPack.draw(10,120, 140, 90);
		demoSeedPack.draw(10,120+90, 140, 90);
		demoSeedPack.draw(10,120+90+90, 140, 90);
		demoSeedPack.draw(10,120+90+90+90, 140, 90);
		
		//PlayUI.showSunCollectedGrid(gc, sbg, g);
		//PlayUI.showPlantZoneGrid(gc, sbg, g);
		PlayUI.showSeedZoneGrid(gc, sbg, g);
		PlayUI.showSunCollected(gc, sbg, g);
		
		SunUI.render(gc, sbg, g);
		
		for (Zombie iZombie : zombie) {
			iZombie.getAnimation().draw(iZombie.getPos().x, iZombie.getPos().y, iZombie.getAnimation().getWidth()*zombieScaleFactor, iZombie.getAnimation().getHeight()*zombieScaleFactor);
		}
		
		for (Plant iPlant : plant) {
			iPlant.getIdleAni().draw(iPlant.getPos().x, iPlant.getPos().y, iPlant.getIdleAni().getWidth()*plantScaleFactor, iPlant.getIdleAni().getHeight()*plantScaleFactor);
		}
		
		for (Bullet iBullet : bullet) {
			iBullet.getAnimation().draw(iBullet.getPos().x, iBullet.getPos().y, iBullet.getAnimation().getWidth()*bulletScaleFactor, iBullet.getAnimation().getHeight()*bulletScaleFactor);
		}
		
		
		
		DebugTool.showMousePosition(g);
		
	}
	
	
	
	private void eventHandle(Graphics g) {
		int mouseX = Controller.getMouseX();
		int mouseY = Controller.getMouseY();
		
		if (mouseX >= PlayUI.getPlantZonePosX() && mouseX <= PlayUI.getPlantZonePosX() + PlayUI.getCellW() * 9 &&
			mouseY >= PlayUI.getPlantZonePosY() && mouseY <= PlayUI.getPlantZonePosY() + PlayUI.getCellH() * 5   ) {
			int hozId = (int) ( (mouseX - PlayUI.getPlantZonePosX()) / (int)PlayUI.getCellW() ) ;
			int verId = (int) ( (mouseY - PlayUI.getPlantZonePosY()) / (int)PlayUI.getCellH() ) ;
			Position posCell = new Position( (int) (PlayUI.getPlantZonePosX() + (hozId) * PlayUI.getCellW()), 
											   (int) (PlayUI.getPlantZonePosY() + (verId) * PlayUI.getCellH())  );
			onCellMoveOn(hozId, verId, posCell, g);
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
	
	public void onCellMoveOn(int hozId, int verId, Position pos, Graphics g) {
		g.setColor(new Color(1, 1, 1, 0.15f));
		g.fillRect(PlayUI.getPlantZonePosX(), PlayUI.getPlantZonePosY() + verId*PlayUI.getCellH(), 9*PlayUI.getCellW(), PlayUI.getCellH());
		g.fillRect(PlayUI.getPlantZonePosX() + hozId*PlayUI.getCellW(), PlayUI.getPlantZonePosY(), PlayUI.getCellW(), 5*PlayUI.getCellH());
	}
	

	public int getID() {
		return 2;
	}
}
