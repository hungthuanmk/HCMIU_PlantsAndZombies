package gui;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import pz.Plant;

public class SeedUI {
	
	private static float x,y,w,h;
	private static int itemPrice;
	
	private static ArrayList<Seed> seed = new ArrayList<>();
	//private static boolean picked = false;
	@SuppressWarnings({ "rawtypes" })
	private static Class pickedClass = null;
	
	@SuppressWarnings("rawtypes")
	public static void setPickedClass(Class pickedClass) {
		SeedUI.pickedClass = pickedClass;
	}

	@SuppressWarnings("rawtypes")
	public static Class getPickedClass() {
		return pickedClass;
	}


	public SeedUI() {
		seed.clear();	
	}
	
	public static void clear() { new SeedUI(); }
	
	@SuppressWarnings("rawtypes")
	public static void addSeed(Class plantClass, Integer money) {
		if (plantClass.getSuperclass() == Plant.class)
			seed.add(new Seed(plantClass, "res/Seed/"+plantClass.getSimpleName()+".png", money));
		else
			System.out.println(plantClass.getName() + " is not subclass of Plant!");		
	}
	
	public static void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		for (int i=0; i<seed.size() && i<8; i++) {
			if (seed.get(i) != null) {
				x = PlayUI.getSeedZonePosX();
				y = PlayUI.getSeedZonePosY();
				w = PlayUI.getSeedZoneW();
				h = PlayUI.getSeedZoneH();
				seed.get(i).getImg().draw(  x, y + i*h, w, h );
				g.drawString(""+seed.get(i).getPrice(), x + w * 0.71f, y + i*h + h*0.7f);
				if (seed.get(i).getPrice() > SunUI.getSunCollected()) {
					g.setColor(new Color(1,1,1,100));
					g.fillRoundRect(x, y + i*h, w, h, 5);
				}	
			}
		}
	}
	
	public static void onItemClicked(int itemIdx) {
		if (seed.get(itemIdx) == null) return;
		if (seed.get(itemIdx).getPrice() <= SunUI.getSunCollected()) { //having enough money
			itemPrice = seed.get(itemIdx).getPrice();
			pickedClass = seed.get(itemIdx).get_class();
			System.out.println(""+ itemIdx + " - " + seed.get(itemIdx).get_class().getSimpleName());
		}
	}
	
	public static void bought() {
		pickedClass = null;
		SunUI.gainSun( - itemPrice);
	}
	
	
}
