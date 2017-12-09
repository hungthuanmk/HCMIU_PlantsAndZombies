package gui;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import pz.Plant;
import pz.plant.Peashooter;

public class SeedUI {
	
	private ArrayList<Seed> img = new ArrayList<>();

	public SeedUI() {
		img.clear();	
	}
	
	public void addSeed(Class plantClass, Integer money) {
		if (plantClass.getSuperclass() == Plant.class)
			img.add(new Seed(plantClass, "res/Seed/"+plantClass.getName(), money));
		else
			System.out.println(plantClass.getName() + " is not subclass of Plant!");
		
	}
	
	
}
