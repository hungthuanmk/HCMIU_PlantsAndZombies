package gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import com.Controller;
import pz.*;
import pz.plant.*;
import pz.zombie.*;

/**
 * 
 * @author Nguyen Thanh Xuan Tung + Nguyen Phan Hung Thuan
 *
 */
public class Play extends BasicGameState {

	private static ArrayList<Zombie> zombie 	= new ArrayList<Zombie>();	
	private static Plant[][] 		  plant 	= new Plant[5][9];
	private static ArrayList<Bullet> bullet 	= new ArrayList<Bullet>();
	private static Integer timePass = 1;
	
	private static Image background;
	
	public Play(int state) {}

	// Initialization
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		new AnimationLoader();
		background = new Image("res/Map/Map_1.jpg");
		
		SunUI.init();
		PlayUI.init();
		
		SeedUI.addSeed(Sunflower.  class, 50);
		SeedUI.addSeed(Peashooter. class, 100);
		SeedUI.addSeed(Peashooter2.class, 250);
		SeedUI.addSeed(Wallnut.    class, 50);
		SeedUI.addSeed(Torchwood.  class, 300);
		SeedUI.addSeed(Bloomerang. class, 300);	
	}

	/**
	 * Draw default background
	 * @param gc	GameContainer
	 * @param sbg	StateBasedGame
	 * @param g	Graphics
	 * @throws SlickException	SlickException
	 */
	public void showBackground(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		float rate 		= 0.69f;
		float width 	= background.getWidth() * PZGUI.getResolutionRateWidth() * rate;
		float height 	= background.getHeight() * PZGUI.getResolutionRateHeight() * rate;
		float moveLeft  = (float)PZGUI.getWidth() * (7.0f/32);
		float moveUp 	= (float)PZGUI.getHeight() * (41.0f/180);
		
		background.draw(-moveLeft, -moveUp, width, height);
	}

	// Render
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		showBackground(gc, sbg, g);
		eventHandle(gc, g);
		
		//PlayUI.showSunCollectedGrid(gc, sbg, g);
		//PlayUI.showPlantZoneGrid(gc, sbg, g);
		//PlayUI.showSeedZoneGrid(gc, sbg, g);
		//PlayUI.showSunCollected(gc, sbg, g);
		
		drawAllPlants(plant,  gc.isPaused());
		drawAllZombie(zombie, gc.isPaused());
		drawAllBullet(bullet, gc.isPaused());
		
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
					if (zombie.get(i).dead()) {
						zombie.remove(i);
					}
					continue;
				}
				zombie.get(i).move(); //move zombie
				zombie.get(i).attack(plant, bullet);
				toGameOver(sbg, zombie.get(i).getPos().x);
			}
			if ((int)((10.0f/timePass) * 4000000f) > 100) {
				spawnRandZombie((int)((10.0f/timePass) * 4000000f));
//				System.out.println((int)((10.0f/timePass) * 4000000f));
			}else {
				spawnRandZombie(100);
//				System.out.println(100);
			}
			timePass += delta;
		}	
	}	
	
	/**
	 * Draw all plants
	 * @param isPausing
	 */
	private static void drawAllPlants(Plant[][] plantList, boolean isPausing) {
		for (Plant[] iPlantRow : plantList) {
			for (Plant iPlant : iPlantRow) {
				if (iPlant != null) {
					iPlant.draw( !isPausing );
				}		
			}
		}
	}
	
	private static void drawAllZombie(ArrayList<Zombie> zombieList, boolean isPausing) {
		for (Zombie iZombie : zombieList) {
			iZombie.draw( !isPausing );
		}
	}
	
	private static void drawAllBullet(ArrayList<Bullet> bulletList, boolean isPausing) {
		for (Bullet iBullet : bulletList) {
			iBullet.draw( !isPausing );
		}
	}
	
	/**
	 * Handle events need drawing
	 * @param gc	GameContainer
	 * @param g	Graphics
	 */
	private void eventHandle(GameContainer gc, Graphics g) {
		int mouseX = Controller.getMouseX();
		int mouseY = Controller.getMouseY();
		
		// Mouse on PlantZone
		if (Controller.mouseInArea( PlayUI.getPlantZonePosX(), PlayUI.getPlantZonePosY(), 
				PlayUI.getPlantZonePosX()+9*PlayUI.getCellW(), PlayUI.getPlantZonePosY()+5*PlayUI.getCellH())) {
			
			int hozId = (int) ( (mouseX - PlayUI.getPlantZonePosX()) / PlayUI.getCellW() ) ;
			int verId = (int) ( (mouseY - PlayUI.getPlantZonePosY()) / PlayUI.getCellH() ) ;

			if (SeedUI.getPickedClass() != null || PlayUI.isShovelClicked())
				drawPlantZoneCoordinates(hozId, verId, g);
		}
		
		// Mouse on SeedZone
		int seedItemId = getSeedZoneItemId(mouseX, mouseY);	
		if (seedItemId > -1 && seedItemId < SeedUI.getSeedCount())
		{
			g.setAntiAlias(true);
			g.setLineWidth(5f);
			g.drawRoundRect(PlayUI.getSeedZonePosX(), PlayUI.getSeedZonePosY()+ seedItemId*PlayUI.getSeedZoneH(), 
			 			    PlayUI.getSeedZoneW(), PlayUI.getSeedZoneH(), 5);
			g.resetLineWidth();
		}
		
	}


	/**
	 * Mouse clicked event, sponsored by Slick2D engine
	 */
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
		
	}
	
	/**
	 * Spawn zombie randomly
	 * @param coefficient	Random factor, spawn zombie with ratio 5/delta
	 */
	private void spawnRandZombie(int coefficient) {
		int row = ThreadLocalRandom.current().nextInt(0, coefficient);
		int zombieN;
		@SuppressWarnings("rawtypes")
		Class[] zombieClass = {FemaleZombie.class, MaleZombie.class, NhiZombie.class};
		if (row>=0 && row<=4) {
			zombieN = ThreadLocalRandom.current().nextInt(0, zombieClass.length);
			zombie.add(CharacterBuilder.buildZombie(zombieClass[zombieN], row));
		}
	}
	
	/**
	 * Draw 2 white lines indicating mouse cooordinates on PlantZone
	 * @param hozId	Horizontal index
	 * @param verId	Vertical index
	 * @param g	Graphics
	 */
	private void drawPlantZoneCoordinates(int hozId, int verId, Graphics g) {
		g.setColor(new Color(1, 1, 1, 0.15f));
		g.fillRect(PlayUI.getPlantZonePosX(), PlayUI.getPlantZonePosY() + verId*PlayUI.getCellH(), 9*PlayUI.getCellW(), PlayUI.getCellH());
		g.fillRect(PlayUI.getPlantZonePosX() + hozId*PlayUI.getCellW(), PlayUI.getPlantZonePosY(), PlayUI.getCellW(), 5*PlayUI.getCellH());
	}
	
	/**
	 * If the cursor inside SeedZone return item index else return -1
	 * @param mouseX	X Mouse position
	 * @param mouseY	Y Mouse position
	 * @return	Seed index or -1 if outside seedzone
	 */
	private static int getSeedZoneItemId(float mouseX, float mouseY) {
		if (Controller.mouseInArea( PlayUI.getSeedZonePosX(), PlayUI.getSeedZonePosY(), 
			PlayUI.getSeedZonePosX()+PlayUI.getSeedZoneW(), PlayUI.getSeedZonePosY()+PlayUI.getSeedZoneH()*8))
			return (int) ( (mouseY - PlayUI.getSeedZonePosY()) / PlayUI.getSeedZoneH() );
		return -1; //outside SeedZone
	}


	private void toGameOver(StateBasedGame sbg, float x) {

		if (x < 130 * PZGUI.getResolutionRateWidth()) {
			zombie.clear();
			bullet.clear();
			for (int i=0; i<5; i++)
				for (int j=0; j<9; j++) {
					plant[i][j] = null;
				}
			timePass=1;
			sbg.getState(3);
			sbg.enterState(3);
		}
		
	}
	
	public int getID() {
		return 2;
	}
}
