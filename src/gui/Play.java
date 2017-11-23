package gui;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;

import org.newdawn.slick.state.*;

import com.Controller;
import com.Position;

import pz.*;
import pz.plant.Peashooter;


public class Play extends BasicGameState {

	ArrayList<Zombie> zombie = new ArrayList<Zombie>();	
	Plant[][] plant = new Plant[9][5];
	ArrayList<Bullet> bullet = new ArrayList<Bullet>();
	ArrayList<Sun> sunList = new ArrayList<Sun>();
	
	Image demoSeedPack;
	
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
		zombie.add(new pz.zombie.FemaleZombie(new Position(PZGUI.width, PlayUI.getPlantZonePosY()+PlayUI.getCellW()*1)));
		zombie.add(new pz.zombie.MaleZombie  (new Position(PZGUI.width, PlayUI.getPlantZonePosY()+PlayUI.getCellW()*2)));
		
		PlayUI.init();
	}

	// Show Background
	public void showBackground(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		float rate = 0.69f;
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
		
		//PlayUI.showSunCollectedGrid(gc, sbg, g);
		//PlayUI.showPlantZoneGrid(gc, sbg, g);
		PlayUI.showSeedZoneGrid(gc, sbg, g);
		PlayUI.showSunCollected(gc, sbg, g);

		PlayUI.showPauseButton(g);
		PlayUI.showSpeedUpButton(g);
    
		for (Plant[] iPlantRow : plant) {
			for (Plant iPlant : iPlantRow) {
				if (iPlant != null)
					iPlant.draw();
			}
		}
		
		for (Zombie iZombie : zombie) {
			iZombie.draw();
		}
		
		for (Bullet iBullet : bullet) {
			iBullet.draw();
		}
		
		SunUI.render(gc, sbg, g);
		
		DebugTool.showMousePosition(g);	
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		SunUI.update(gc, sbg);
		
		for (Plant[] iPlantRow : plant) {
			for (Plant iPlant : iPlantRow) {
				if (iPlant != null)
					iPlant.attack(bullet);
			}
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
	
	private void eventHandle(Graphics g) {
		int mouseX = Controller.getMouseX();
		int mouseY = Controller.getMouseY();
		
		// Mouse on PlantZone
		if (Controller.mouseInArea( PlayUI.getPlantZonePosX(), PlayUI.getPlantZonePosY(), 
									PlayUI.getPlantZonePosX()+9*PlayUI.getCellW(), PlayUI.getPlantZonePosY()+5*PlayUI.getCellH())) {
			int hozId = (int) ( (mouseX - PlayUI.getPlantZonePosX()) / PlayUI.getCellW() ) ;
			int verId = (int) ( (mouseY - PlayUI.getPlantZonePosY()) / PlayUI.getCellH() ) ;
			Position posCell = new Position(  (PlayUI.getPlantZonePosX() + (hozId) * PlayUI.getCellW()), 
											    (PlayUI.getPlantZonePosY() + (verId) * PlayUI.getCellH())  );
			onPlantZoneMoveOn(hozId, verId, posCell, g);
		}
		
		// Mouse on SeedZone
		if (Controller.mouseInArea( PlayUI.getSeedZonePosX(), PlayUI.getSeedZonePosY(), 
									PlayUI.getSeedZonePosX()+PlayUI.getSeedZoneW(), PlayUI.getSeedZonePosY()+PlayUI.getSeedZoneH()*8)) {
			int itemId = (int) ( (mouseY - PlayUI.getSeedZonePosY()) / PlayUI.getSeedZoneH() ) ;
			Position posItem = new Position(PlayUI.getSeedZonePosX(), PlayUI.getSeedZonePosY() + itemId * PlayUI.getSeedZoneH()  );
			onSeedZoneMoveOn(itemId, posItem, g);
		}
	}

	private void onSeedZoneMoveOn(int itemId, Position posItem, Graphics g) {
		g.fillRect(posItem.x, posItem.y, PlayUI.getSeedZoneW(), PlayUI.getSeedZoneH());
	}

	@Override
	public void mousePressed(int button, int x, int y) {
	}
	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		System.out.println(String.format("%d %d", newx, newy));
	}
	
	private void onPlantZoneMoveOn(int hozId, int verId, Position pos, Graphics g) {
		g.setColor(new Color(1, 1, 1, 0.15f));
		g.fillRect(PlayUI.getPlantZonePosX(), PlayUI.getPlantZonePosY() + verId*PlayUI.getCellH(), 9*PlayUI.getCellW(), PlayUI.getCellH());
		g.fillRect(PlayUI.getPlantZonePosX() + hozId*PlayUI.getCellW(), PlayUI.getPlantZonePosY(), PlayUI.getCellW(), 5*PlayUI.getCellH());

		if (Mouse.getEventButton() == 0 && Mouse.getEventButtonState() == true) {
			if (plant[hozId][verId] == null) 
				plant[hozId][verId] = new Peashooter(pos);
		}
	}
	
	public int getID() {
		return 2;
	}
}
