package gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.loading.LoadingList;
import org.newdawn.slick.state.*;

import com.Controller;
import com.Position;

import pz.*;
import pz.plant.*;
import pz.zombie.*;

/**
 * 
 * @author Nguyen Thanh Xuan Tung + Nguyen Phan Hung Thuan
 *
 */
public class Play extends BasicGameState {

	private ArrayList<Zombie> zombie 	= new ArrayList<Zombie>();	
	private Plant[][] 		  plant 	= new Plant[5][9];
	private ArrayList<Bullet> bullet 	= new ArrayList<Bullet>();
	
	private static Image background;
	
	public Play(int state) {	
	}

	// Initialization
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		new AnimationLoader();
		background = new Image("res/Map/Map_1.jpg");
		
		SunUI.init();
		PlayUI.init();
		
		SeedUI.addSeed(Sunflower.  class, 50);
		SeedUI.addSeed(Peashooter. class, 100);
		SeedUI.addSeed(Peashooter2.class, 200);
		SeedUI.addSeed(Wallnut.    class, 50);
		SeedUI.addSeed(Torchwood.  class, 100);
	}

	// Show Background
	private void showBackground(Graphics g) throws SlickException {
		float rate 		= 0.69f;
		float width 	= background.getWidth() * PZGUI.getResolutionRateWidth() * rate;
		float height 	= background.getHeight() * PZGUI.getResolutionRateHeight() * rate;
		float moveLeft  = (float)PZGUI.getWidth() * (7.0f/32);
		float moveUp 	= (float)PZGUI.getHeight() * (41.0f/180);
		
		background.draw(-moveLeft, -moveUp, width, height);
	}

	// Render
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		showBackground(g);
		eventHandle(gc, g);
		
		//PlayUI.showSunCollectedGrid(gc, sbg, g);
		//PlayUI.showPlantZoneGrid(gc, sbg, g);
		//PlayUI.showSeedZoneGrid(gc, sbg, g);
		//PlayUI.showSunCollected(gc, sbg, g);

		for (Plant[] iPlantRow : plant) {
			for (Plant iPlant : iPlantRow) {
				if (iPlant != null) {
					iPlant.draw(!gc.isPaused());
				}		
			}
		}
		
		for (Zombie iZombie : zombie) {
			iZombie.draw(!gc.isPaused());
		}
		
		for (Bullet iBullet : bullet) {
			iBullet.draw(!gc.isPaused());
		}
	
		
		SunUI. render(gc, sbg, g);
		SeedUI.render(gc, sbg, g);
		
		PlayUI.showSunCollected (gc, sbg, g);
		PlayUI.showPauseButton  (gc, g);
		PlayUI.showSpeedUpButton(gc, g);
		PlayUI.showPlayButton   (gc, g);
		PlayUI.showShovel       (gc, g);
		
		if (SeedUI.getPickedImg() != null)
			SeedUI.getPickedImg().drawCentered(Controller.getMouseX(), Controller.getMouseY());
			
		//DebugTool.showMousePosition(g);	
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if (! gc.isPaused() ) {
			SunUI.update(gc, sbg);
			
			for (int i=0; i<5; i++)
				for (int j=0; j<9; j++) {
					if (plant[i][j] != null) {
						if (plant[i][j].getHp() <= 0) {
							plant[i][j] = null;
							continue;
						}
						plant[i][j].attack(bullet);
					}
				}
			
			for (int i=0; i<bullet.size(); i++) {
				bullet.get(i).move();
				bullet.get(i).attack(zombie, bullet);				
			}
			
			for (int i=0; i < zombie.size(); i++) {
				if (zombie.get(i) == null) continue;
				if (zombie.get(i).getHp() <= 0) {
					zombie.remove(i);
					continue;
				}
				zombie.get(i).move(); //move zombie
				zombie.get(i).attack(plant, bullet);
				toGameOver(sbg, zombie.get(i).getPos().x);
			}
		}	
		
		spawnRandZombie(1500 - ((bullet.size() * 10)<1400 ? bullet.size()*10 : 1000));
	}
	
	private void eventHandle(GameContainer gc, Graphics g) {
		int mouseX = Controller.getMouseX();
		int mouseY = Controller.getMouseY();
		
		// Mouse on PlantZone
		if (Controller.mouseInArea( PlayUI.getPlantZonePosX(), PlayUI.getPlantZonePosY(), 
				PlayUI.getPlantZonePosX()+9*PlayUI.getCellW(), PlayUI.getPlantZonePosY()+5*PlayUI.getCellH())) {
			
			int hozId = (int) ( (mouseX - PlayUI.getPlantZonePosX()) / PlayUI.getCellW() ) ;
			int verId = (int) ( (mouseY - PlayUI.getPlantZonePosY()) / PlayUI.getCellH() ) ;
			Position posCell = new Position(  (PlayUI.getPlantZonePosX() + (hozId) * PlayUI.getCellW()), 
						    (PlayUI.getPlantZonePosY() + (verId) * PlayUI.getCellH())  );
			if (SeedUI.getPickedClass() != null)
				onPlantZoneMoveOn(hozId, verId, posCell, g);
			
			if (PlayUI.isShovelClicked() == true)
				onPlantZoneMoveOn(hozId, verId, posCell, g);
		}
	}

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
	}
	
	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		if (Controller.mouseInArea( PlayUI.getSeedZonePosX(), PlayUI.getSeedZonePosY(), 
				PlayUI.getSeedZonePosX()+PlayUI.getSeedZoneW(), PlayUI.getSeedZonePosY()+PlayUI.getSeedZoneH()*8)) {
			int itemId = (int) ( (y - PlayUI.getSeedZonePosY()) / PlayUI.getSeedZoneH() ) ;
			SeedUI.onItemClicked(itemId);
		}
		
		if (Controller.mouseInArea( PlayUI.getPlantZonePosX(), PlayUI.getPlantZonePosY(), 
				PlayUI.getPlantZonePosX()+9*PlayUI.getCellW(), PlayUI.getPlantZonePosY()+5*PlayUI.getCellH())) {
			int hozId = (int) ( (x - PlayUI.getPlantZonePosX()) / PlayUI.getCellW() ) ;
			int verId = (int) ( (y - PlayUI.getPlantZonePosY()) / PlayUI.getCellH() ) ;

			if (plant[verId][hozId] == null && SeedUI.getPickedClass() != null) {
				plant[verId][hozId] = CharacterBuilder.buildPlant(SeedUI.getPickedClass(), verId, hozId);
				SeedUI.bought(); //had bought
			}
			
			if (plant[verId][hozId] != null && PlayUI.isShovelClicked() == true) { 
				plant[verId][hozId] = null;
				PlayUI.setShovelClicked(false);
			}
		}
		
		if (PlayUI.isShovelClicked() == true) {
			PlayUI.setShovelClicked(false);
		}
		
	}
	
	private void spawnRandZombie(int delta) {
		int row = ThreadLocalRandom.current().nextInt(0,delta);
		int zombieN;
		Class[] zombieClass = {FemaleZombie.class, MaleZombie.class, NhiZombie.class};
		if (row>=0 && row<=4) {
			zombieN = ThreadLocalRandom.current().nextInt(0, zombieClass.length);
			zombie.add(CharacterBuilder.buildZombie(zombieClass[zombieN], row));
		}
	}
	
	private void onPlantZoneMoveOn(int hozId, int verId, Position pos, Graphics g) {
		g.setColor(new Color(1, 1, 1, 0.15f));
		g.fillRect(PlayUI.getPlantZonePosX(), PlayUI.getPlantZonePosY() + verId*PlayUI.getCellH(), 9*PlayUI.getCellW(), PlayUI.getCellH());
		g.fillRect(PlayUI.getPlantZonePosX() + hozId*PlayUI.getCellW(), PlayUI.getPlantZonePosY(), PlayUI.getCellW(), 5*PlayUI.getCellH());
	}
	
	private void toGameOver(StateBasedGame sbg, float x) {
		if (x < 130 * PZGUI.getResolutionRateWidth()) { 
			zombie.clear();
			bullet.clear();
			for (int i=0; i<5; i++)
				for (int j=0; j<9; j++) {
					plant[i][j] = null;
				}
			SunUI.getSunManager().clear();
			SunUI.setSunCollected(50);
			SunUI.setFramePassed(0);
			sbg.getState(3);
			sbg.enterState(3);
		}
	}
	
	public int getID() {
		return 2;
	}
}
