package gui;

import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.openal.SoundStore;
import org.newdawn.slick.state.StateBasedGame;

import com.Position;
import com.SSound;

import pz.CharacterBuilder;
import pz.Plant;

public class SeedUI {
	
	private static float x,y,w,h;
	private static int itemPrice;
	private static Text cost = new Text(41.0f);
	
	private static ArrayList<Seed> seed = new ArrayList<>();
	//private static boolean picked = false;
	@SuppressWarnings({ "rawtypes" })
	private static Class pickedClass = null;
	private static Image pickedImg = null;
	
	public static Image getPickedImg() { return pickedImg; }

	@SuppressWarnings("rawtypes")
	/**
	 * Set picked class for onItemClicked event
	 * @param pickedClass Class of plant had been selected
	 */
	public static void setPickedClass(Class pickedClass) { SeedUI.pickedClass = pickedClass; }

	@SuppressWarnings("rawtypes")
	/**
	 * Get picked class after onItemClicked event
	 * @return Class of plant Ex: Peashooter.class
	 */
	public static Class getPickedClass() { return pickedClass; }
	/** 
	 * Initiaize SeedUI and clear all existing seeds in collection
	 */
	public SeedUI() 		   { seed.clear(); }
	/**
	 * Clear all existing seed in collection
	 */
	public static void clear() { new SeedUI(); }
	
	@SuppressWarnings("rawtypes")
	/**
	 * Add new Seed into Seeds collections area
	 * @param plantClass	Class of plants Ex: Peashooter.class
	 * @param price		Price for buying
	 */
	public static void addSeed(Class plantClass, Integer price) {
		if (plantClass.getSuperclass() == Plant.class)
			seed.add(new Seed(plantClass, "res/Seed/"+plantClass.getSimpleName()+".png", price));
		else
			System.out.println(plantClass.getName() + " is not subclass of Plant!");		
	}
	
	/**
	 * Render Seeds area
	 * @param gc GameContainer
	 * @param sbg StateBasedGame
	 * @param g	Graphics
	 */
	public static void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		for (int i=0; i<seed.size() && i<8; i++) {
			if (seed.get(i) != null) {
				x = PlayUI.getSeedZonePosX();
				y = PlayUI.getSeedZonePosY();
				w = PlayUI.getSeedZoneW();
				h = PlayUI.getSeedZoneH();
				seed.get(i).getImg().draw(  x, y + i*h, w, h );
//				g.drawString(""+seed.get(i).getPrice(), x + w * 0.71f, y + i*h + h*0.7f);
				if (seed.get(i).getPrice() > SunUI.getSunCollected()) {
					g.setColor(new Color(1,1,1,100));
					g.fillRoundRect(x, y + i*h, w, h, 5);
				}	
			}
		}
		for (int i=0; i<seed.size() && i<8; i++) {
			if (seed.get(i) != null) {
				x = PlayUI.getSeedZonePosX();
				y = PlayUI.getSeedZonePosY();
				w = PlayUI.getSeedZoneW();
				h = PlayUI.getSeedZoneH();
				if (seed.get(i).getPrice() > SunUI.getSunCollected())
					cost.render(x + w * 0.594f, y + i*h + h*0.5f, (seed.get(i).getPrice()<100 ? "   " : "") + seed.get(i).getPrice().toString(), new Color(180, 180, 180));
				else
					cost.render(x + w * 0.594f, y + i*h + h*0.5f, (seed.get(i).getPrice()<100 ? "   " : "") + seed.get(i).getPrice().toString(), new Color(245, 245, 245));
					
			}
		}
	}
	
	/**
	 * EVENT: Click one of items on Seeds area
	 * @param itemIdx Item index, 0 to maximum 7 
	 */
	public static void onItemClicked(int itemIdx) {
		if (itemIdx > seed.size()) return;
		if (seed.get(itemIdx).getPrice() <= SunUI.getSunCollected()) { //having enough money
			itemPrice = seed.get(itemIdx).getPrice();
			pickedClass = seed.get(itemIdx).get_class();
			pickedImg = CharacterBuilder.buildPlant(pickedClass, new Position(0,0)).getAnimation().getImage(0).getScaledCopy(0.15f);
			System.out.println(""+ itemIdx + " - " + seed.get(itemIdx).get_class().getSimpleName());
		}
	}
	
	/**
	 * The plant had been bought successfully and subtract money!
	 */
	public static void bought() {
		pickedClass = null;
		pickedImg = null;
		SunUI.gainSun( - itemPrice);
		//SSound.play("res/Sound/effect/tantan.wav");
	}
	
	
}
